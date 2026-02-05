
# 🚀 Cucumber + TestNG Parallel Execution – Cheat Sheet

This guide covers:

✅ Feature level parallel  
✅ Scenario level parallel  
✅ Surefire configs  
✅ Runner setup  
✅ Thread basics (Java)  
✅ How to PROVE tests are really parallel  
✅ Interview quick answers  

---

# 🔥 Big Picture

There are **2 types of parallel execution**:

| Level | What runs parallel |
|-----------|-------------------|
| Feature level | Feature files |
| Scenario level | Scenarios |

---

------------------------------------------------------------
# ✅ 1️⃣ Feature Level Parallel
------------------------------------------------------------

## Example

```
login.feature
payment.feature
search.feature
```

### Goal

```
Thread-1 → login.feature
Thread-2 → payment.feature
Thread-3 → search.feature
```

---

## pom.xml

```xml
<parallel>classes</parallel>
<threadCount>3</threadCount>
```

---

## How it works

TestNG treats:

```
each feature → class
```

So classes run parallel.

---

------------------------------------------------------------
# ✅ 2️⃣ Scenario Level Parallel (Most Used)
------------------------------------------------------------

## Example

```gherkin
Feature: Login

Scenario: A
Scenario: B
Scenario: C
```

### Goal

```
Thread-1 → A
Thread-2 → B
Thread-3 → C
```

---

## Runner

```java
@Override
@DataProvider(parallel = true)
public Object[][] scenarios() {
    return super.scenarios();
}
```

---

## pom.xml

```xml
<parallel>methods</parallel>
<threadCount>3</threadCount>
```

---

## How it works

TestNG treats:

```
each scenario → method
```

So methods run parallel.

---

------------------------------------------------------------
# ✅ Feature vs Scenario vs Both
------------------------------------------------------------

| Mode | Value | Runs parallel |
|---------|-----------|----------------|
| Feature | classes | feature files |
| Scenario | methods | scenarios |
| Both | classesAndMethods | both |

---

------------------------------------------------------------
# ✅ Complete Runner Template
------------------------------------------------------------

```java
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps","hooks"},
    plugin = {"pretty","summary"},
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

---

------------------------------------------------------------
# 🔥 How to PROVE it's really parallel (Thread logging)
------------------------------------------------------------

## Step Definition Example

```java
@Given("application is launched")
public void launch() {
    System.out.println(
        "Thread: " + Thread.currentThread().getName()
    );
}
```

---

## Output Example

```
Thread: TestNG-PoolService-0
Thread: TestNG-PoolService-1
Thread: TestNG-PoolService-2
```

👉 Different thread names = parallel execution

---

------------------------------------------------------------
# ✅ Java Thread Basics (Simple Understanding)
------------------------------------------------------------

## Simple Thread Demo

```java
public class ThreadDemo {

    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
```

### Output

```
Thread-0
Thread-1
Thread-2
```

👉 Multiple threads running simultaneously

---

## Sleep Demo (to visualize parallel)

```java
Runnable task = () -> {
    try {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(3000);
    } catch (Exception e) {}
};
```

If parallel → all finish in ~3s  
If sequential → 9s

---

------------------------------------------------------------
# ✅ Best Practice Rules (VERY IMPORTANT)
------------------------------------------------------------

## ❌ Avoid

- static variables
- shared WebDriver
- shared data
- scenario dependency

## ✅ Use

- ThreadLocal driver
- independent scenarios
- separate test data
- stateless hooks

---

------------------------------------------------------------
# ✅ ThreadLocal WebDriver Example (Selenium)
------------------------------------------------------------

```java
public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver d) {
        driver.set(d);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
```

Each thread gets its own driver.

---

------------------------------------------------------------
# ✅ Execution Timeline Comparison
------------------------------------------------------------

## Sequential

```
A → B → C
Time = 9s
```

## Parallel

```
A B C together
Time = 3s
```

---

------------------------------------------------------------
# ✅ Interview Quick Answers
------------------------------------------------------------

Q: Can Cucumber run features parallel?
👉 Yes using classes

Q: Can scenarios run parallel?
👉 Yes using methods

Q: How verify parallel?
👉 Print Thread.currentThread().getName()

Q: Most used mode?
👉 Scenario level

Q: Biggest risk?
👉 Shared state

---

------------------------------------------------------------
# ✅ Memory Trick
------------------------------------------------------------

classes → features  
methods → scenarios  
Thread name different → parallel confirmed  
ThreadLocal → safe driver  
