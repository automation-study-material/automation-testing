Below is the **updated section you can add to your Cucumber + TestNG notes** to include **Feature-Level Parallel Execution** along with Scenario-Level execution.

---

# 1️⃣ Feature-Level Parallel Execution (Cucumber + TestNG)

Feature-level parallel execution means **each feature file runs in a separate thread**.

Example:

```text
Thread1 → login.feature
Thread2 → payment.feature
Thread3 → order.feature
```

---

# 2️⃣ Runner Class (Feature Parallel)

In TestNG, feature-level parallel execution can be achieved by creating **multiple runner classes**, each pointing to a specific feature.

### LoginRunner

```java
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty","html:target/login-report.html"},
        monochrome = true
)

public class LoginRunner extends AbstractTestNGCucumberTests {
}
```

---

### PaymentRunner

```java
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/payment.feature",
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty","html:target/payment-report.html"},
        monochrome = true
)

public class PaymentRunner extends AbstractTestNGCucumberTests {
}
```

---

# 3️⃣ TestNG Configuration

Create **testng.xml**

```xml
<suite name="CucumberSuite" parallel="classes" thread-count="2">

    <test name="FeatureTests">

        <classes>
            <class name="runner.LoginRunner"/>
            <class name="runner.PaymentRunner"/>
        </classes>

    </test>

</suite>
```

### Meaning

| Property           | Description                    |
| ------------------ | ------------------------------ |
| parallel="classes" | runner classes run in parallel |
| thread-count       | number of parallel threads     |

Execution:

```text
Thread1 → LoginRunner → login.feature
Thread2 → PaymentRunner → payment.feature
```

---

# 4️⃣ Scenario-Level Parallel Execution (Cucumber + TestNG)

Scenario-level execution means **each scenario runs in parallel**.

Example:

```text
Thread1 → Scenario1
Thread2 → Scenario2
Thread3 → Scenario3
```

---

# 5️⃣ Runner Class for Scenario Parallel

```java
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

Important line:

```java
@DataProvider(parallel = true)
```

This runs **each scenario in a separate thread**.

---

# 6️⃣ Feature vs Scenario Parallel

| Parallel Type  | Implementation                                 | Thread Behavior                |
| -------------- | ---------------------------------------------- | ------------------------------ |
| Feature Level  | Multiple runner classes + `parallel="classes"` | Each feature runs in parallel  |
| Scenario Level | `@DataProvider(parallel=true)`                 | Each scenario runs in parallel |

---

# 7️⃣ Important Selenium Requirement

For both approaches:

✔ WebDriver must be **ThreadSafe**

Example:

```java
private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
```

Each thread gets its **own browser instance**.

---

# ⭐ Interview Summary

Feature-level parallel execution runs multiple feature files simultaneously using separate runner classes and TestNG class-level parallel execution. Scenario-level parallel execution runs individual scenarios in parallel using the DataProvider with the parallel flag enabled.

---

If you want, I can also show you **a real enterprise automation approach used in companies**:

⚡ **Cucumber Parallel Plugin (Generates 50+ runners automatically)**

This is **very powerful and often used in large Selenium frameworks** where there are **hundreds of feature files**.
