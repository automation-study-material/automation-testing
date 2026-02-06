# ⭐ Singleton Pattern in Selenium Framework

---

# 🧠 Why do we need Singleton?

## Problem (Without Singleton)

If every test creates its own driver like this:

```java
WebDriver driver = new ChromeDriver();
```

Problems:

- Multiple browsers open unexpectedly
- Memory waste
- Session conflicts
- Hard to manage lifecycle
- Driver created in many places

When the framework grows (100+ tests), this becomes chaos.

---

# 🎯 Core Idea of Singleton (1 line)

> Allow ONLY ONE instance of a class in the entire framework.

For Selenium:

👉 Only ONE WebDriver per execution (or per thread).

---

# ✅ Basic Singleton Structure

## DriverManager.java

```java
public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {}

    public static WebDriver getDriver() {

        if (driver == null) {
            driver = new ChromeDriver();
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
```

---

## Usage

```java
WebDriver driver = DriverManager.getDriver();
```

---

# ✅ What Singleton Solves

- ✅ Single driver instance
- ✅ Centralized control
- ✅ Easy lifecycle management
- ✅ Memory efficient
- ✅ Avoid duplicate drivers

---

# ⚠️ But Wait… What About Parallel Execution?

Good question 👍

If you run parallel tests and still use the above Singleton:

❌ All threads share SAME driver  
❌ Tests overwrite each other  
❌ Random failures  

So classic Singleton is NOT enough.

---

# ⭐ Modern Solution → Singleton + ThreadLocal

In real Selenium frameworks, we combine:

👉 Singleton (one instance manager)  
👉 ThreadLocal (one driver per thread)

---

# 🧠 Why ThreadLocal?

## Problem

Parallel tests:

Thread 1 → Chrome  
Thread 2 → Firefox  

If driver is global:

```
driver = Chrome
driver = Firefox
```

Both threads fight for same object.

---

## ThreadLocal Concept

> Each thread gets its own copy of variable

So:

Thread 1 → Driver A  
Thread 2 → Driver B  
Thread 3 → Driver C  

Perfect isolation.

---

# ✅ Real-World Singleton + ThreadLocal (Industry Standard)

## DriverManager.java

```java
public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}
```

---

## DriverFactory.java

```java
public class DriverFactory {

    public static void initDriver(String browser) {

        WebDriver driver;

        switch(browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                driver = new ChromeDriver();
        }

        DriverManager.setDriver(driver);
    }
}
```

---

## BaseTest.java

```java
@BeforeMethod
public void setup() {
    DriverFactory.initDriver("chrome");
}

@AfterMethod
public void tearDown() {
    DriverManager.quitDriver();
}
```

---

# 🎯 Now What Happens?

If threadCount = 3:

```
Thread 1 → Chrome
Thread 2 → Chrome
Thread 3 → Chrome
```

Each has separate driver.

✅ Safe parallel execution.

---

# 🧠 So Why Still Call It Singleton?

Great confusion point 👍

### Answer:

We are NOT making WebDriver Singleton.

We are making:

👉 DriverManager Singleton

Meaning:

- Only ONE manager class
- Centralized access point
- But drivers stored per thread

So:

```
Singleton manager
    ↓
ThreadLocal drivers
```

---

# ✅ Difference Summary

| Feature | Singleton Only | ThreadLocal Only | Singleton + ThreadLocal (Best) |
|---------|----------------|-----------------|--------------------------------|
| Single control point | ❌ | ❌ | ✅ |
| Parallel safe | ❌ | ✅ | ✅ |
| Central lifecycle | ❌ | ❌ | ✅ |
| Industry usage | ❌ | ❌ | ⭐⭐⭐⭐⭐ |

---

# 🎯 Interview Answer

If interviewer asks:

👉 Why use Singleton when ThreadLocal exists?

You say:

> Singleton gives centralized driver management, while ThreadLocal provides thread safety.  
> Together they allow one driver per thread with controlled lifecycle.  
> This is the industry-standard approach for parallel Selenium frameworks.

---

# ✅ Simple Rule

### Never:
❌ new ChromeDriver() inside tests

### Always:
✅ DriverManager.getDriver()

---

# 🚀 Final Takeaway

Use:

Singleton → Manage  
ThreadLocal → Isolate  
Factory → Create  

These 3 together build a professional driver architecture.
