# Cucumber Parallel Execution Guide (Java + Selenium)

This guide explains how to run **parallel execution in Cucumber** at:

1.  Feature File Level
2.  Scenario Level

------------------------------------------------------------------------

# 1. Feature Level Parallel Execution (JUnit + Maven)

## Project Structure

    src
     └─ test
         ├─ java
         │   ├─ runner
         │   │   ├─ TestRunner1.java
         │   │   └─ TestRunner2.java
         │   ├─ stepDefinitions
         │   └─ hooks
         └─ resources
             └─ features
                 ├─ login.feature
                 └─ payment.feature

------------------------------------------------------------------------

## Runner Class Example

### TestRunner1.java

``` java
package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty","html:target/cucumber-reports/login.html"},
        monochrome = true
)
public class TestRunner1 {
}
```

### TestRunner2.java

``` java
package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/payment.feature",
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty","html:target/cucumber-reports/payment.html"},
        monochrome = true
)
public class TestRunner2 {
}
```

------------------------------------------------------------------------

## Maven Configuration

Add this in **pom.xml**

``` xml
<build>
 <plugins>

  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.0.0</version>

    <configuration>
        <parallel>classes</parallel>
        <threadCount>2</threadCount>
    </configuration>

  </plugin>

 </plugins>
</build>
```

### Meaning

| Property \| Description \|

\|--------\|-------------\| parallel=classes \| Runner classes run in
parallel \| \| threadCount \| Number of threads \|

Execution:

    Thread1 → TestRunner1 → login.feature
    Thread2 → TestRunner2 → payment.feature

------------------------------------------------------------------------

# 2. Scenario Level Parallel Execution (Cucumber + TestNG)

Scenario-level parallel execution is best implemented using **TestNG**.

------------------------------------------------------------------------

## Dependencies (pom.xml)

``` xml
<dependency>
 <groupId>io.cucumber</groupId>
 <artifactId>cucumber-java</artifactId>
 <version>7.14.0</version>
</dependency>

<dependency>
 <groupId>io.cucumber</groupId>
 <artifactId>cucumber-testng</artifactId>
 <version>7.14.0</version>
</dependency>

<dependency>
 <groupId>org.testng</groupId>
 <artifactId>testng</artifactId>
 <version>7.8.0</version>
</dependency>
```

------------------------------------------------------------------------

## Runner Class

``` java
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty","html:target/cucumber-report.html"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
```

Important Line:

    @DataProvider(parallel = true)

This runs **each scenario in parallel threads**.

------------------------------------------------------------------------

## TestNG Configuration

Create **testng.xml**

``` xml
<suite name="CucumberSuite" parallel="tests" thread-count="3">

 <test name="CucumberTests">
  <classes>
   <class name="runner.TestRunner"/>
  </classes>
 </test>

</suite>
```

Meaning:

  Property           Purpose
  ------------------ -----------------------
  parallel="tests"   run tests in parallel
  thread-count       number of threads

------------------------------------------------------------------------

# 3. ThreadSafe WebDriver (Important for Selenium)

Parallel execution requires **ThreadLocal WebDriver**.

    public class DriverManager {

     private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

     public static WebDriver getDriver() {
      return driver.get();
     }

     public static void setDriver(WebDriver webDriver) {
      driver.set(webDriver);
     }

    }

------------------------------------------------------------------------

# 4. Hook Example

    @Before
    public void setup(){

     WebDriver driver = new ChromeDriver();
     DriverManager.setDriver(driver);

    }

------------------------------------------------------------------------

# 5. Execution

Feature level:

    mvn test

Scenario level (TestNG):

Run using **testng.xml**

------------------------------------------------------------------------

# 6. Interview Summary

Feature Level Parallel - Implemented using **JUnit + Maven Surefire** -
Runner classes execute in parallel

Scenario Level Parallel - Implemented using **Cucumber + TestNG** - Uses
**@DataProvider(parallel=true)**

Important - WebDriver must be **ThreadSafe using ThreadLocal** - Helps
reduce automation execution time

------------------------------------------------------------------------
