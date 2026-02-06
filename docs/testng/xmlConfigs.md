# 📘 TestNG XML & Execution — Complete Practical Guide

---

# 🔵 1️⃣ Structure of testng.xml

## ✅ Purpose
Controls:
- which tests run
- execution order
- grouping
- parallelism
- parameters
- listeners

👉 Think of it as **execution controller of TestNG**

---

## ✅ Hierarchy

```
<suite>
   <test>
      <classes>
         <class>
            <methods>
```

---

## ✅ Basic Example

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="EcommerceSuite">

    <test name="SmokeTests">

        <classes>
            <class name="tests.LoginTest"/>
            <class name="tests.OrderTest"/>
        </classes>

    </test>

</suite>
```

---

## ✅ Flow

```
Suite → Test → Class → Method
```

---

# 🔵 2️⃣ suite vs test vs class vs method

## ✅ Purpose
Defines **execution scope**

---

## ✅ Comparison Table

| Level | Scope | Runs |
|--------|---------|---------|
| suite | entire run | once |
| test | group of classes | per test block |
| class | per class | per class |
| method | each test | per method |

---

## ✅ Example

```xml
<suite name="Suite">

   <test name="LoginTests">
      <classes>
         <class name="LoginTest"/>
      </classes>
   </test>

   <test name="OrderTests">
      <classes>
         <class name="OrderTest"/>
      </classes>
   </test>

</suite>
```

---

## ✅ Execution

```
Suite start
   LoginTests
      LoginTest methods
   OrderTests
      OrderTest methods
Suite end
```

---

## ✅ Use Cases

| Level | When to use |
|---------|-------------|
| suite | global setup |
| test | environment split |
| class | feature |
| method | actual test |

---

# 🔵 3️⃣ How to pass parameters from XML?

## ✅ Purpose
Pass:
- browser
- environment
- url
- credentials

👉 externalize config

---

## Example XML

```xml
<test name="ChromeRun">
    <parameter name="browser" value="chrome"/>
    <classes>
        <class name="tests.LoginTest"/>
    </classes>
</test>
```

---

## Test Code

```java
@Parameters("browser")
@Test
public void launch(String browser){
    System.out.println(browser);
}
```

---

## Output

```
chrome
```

---

# 🔵 4️⃣ @Parameters vs @DataProvider

## ✅ Comparison

| Feature | @Parameters | @DataProvider |
|-----------|--------------|---------------|
| Data source | XML | Java method |
| Multiple rows | ❌ | ✅ |
| Parallel | ❌ | ✅ |
| Best for | config | test data |

---

## @Parameters Example

```xml
<parameter name="url" value="test.com"/>
```

---

## DataProvider Example

```java
@DataProvider
public Object[][] users(){
    return new Object[][]{
        {"user1"},
        {"user2"}
    };
}
```

---

## Use Cases

| Scenario | Use |
|------------|-----------|
| browser/env | Parameters |
| test inputs | DataProvider |

---

# 🔵 5️⃣ How to run only failed tests?

## ✅ Purpose
Rerun failures only (save time)

---

## Method 1 — testng-failed.xml
After execution:

```
test-output/testng-failed.xml
```

Run this file again.

---

## Method 2 — RetryAnalyzer

```java
public class Retry implements IRetryAnalyzer {
    int count = 0;

    public boolean retry(ITestResult result){
        if(count < 2){
            count++;
            return true;
        }
        return false;
    }
}
```

```java
@Test(retryAnalyzer = Retry.class)
```

---

# 🔵 6️⃣ Group include/exclude

## Purpose
Run subset of tests

---

## Example

```java
@Test(groups="smoke")
public void login(){}

@Test(groups="regression")
public void payment(){}
```

---

## XML

```xml
<groups>
   <run>
      <include name="smoke"/>
   </run>
</groups>
```

---

## Output

```
login only
```

---

# 🔵 7️⃣ Dynamic exclusion of tests

## Purpose
Skip tests at runtime

---

## Option 1

```java
@Test(enabled=false)
```

---

## Option 2

```java
throw new SkipException("Skip test");
```

---

# 🔵 8️⃣ Enable parallel execution

## Purpose
Faster execution

---

## XML

```xml
<suite parallel="methods" thread-count="3">
```

---

# 🔵 9️⃣ parallel = tests vs classes vs methods vs instances

## Behavior

| Mode | Parallelism |
|-----------|-----------------|
| tests | <test> blocks |
| classes | classes |
| methods | test methods |
| instances | object instances |

---

## Example

parallel="methods"

```
login()  → thread1
pay()    → thread2
order()  → thread3
```

---

# 🔵 🔟 threadCount working internally

## Concept
TestNG creates:

👉 **Fixed Thread Pool**

---

## Internally

```java
ExecutorService pool = Executors.newFixedThreadPool(threadCount);
```

Tasks submitted:

```
Runnable test methods
```

---

## Example

```xml
<suite parallel="methods" thread-count="2">
```

5 tests:

```
2 run
2 run
1 run
```

---

# 🔥 Interview Quick Lines

👉 suite = whole execution  
👉 test = logical grouping  
👉 Parameters for config  
👉 DataProvider for data  
👉 groups for selective run  
👉 parallel improves speed  
👉 threadCount controls concurrency  

---

Happy Learning 🚀
