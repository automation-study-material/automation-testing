# ⭐ Step 3 — Factory Pattern (DriverFactory) in Selenium Framework

---

# 🧠 Why did Factory come into picture?

Let’s first see the common beginner approach.

## ❌ Without Factory

```java
WebDriver driver = new ChromeDriver();
```

Problem?

If tomorrow you want Firefox:

```java
WebDriver driver = new FirefoxDriver();
```

Now imagine:

- 150 test classes
- Chrome hardcoded everywhere
- Need cross-browser testing

💥 You must update 150 files manually.

---

# 🎯 Core Idea of Factory (1 line)

> Move object creation logic into one central place.

Instead of tests creating drivers… Factory creates drivers.

---

# ✅ DriverFactory Example

```java
public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                driver = new ChromeDriver();
        }

        return driver;
    }
}
```

---

# ✅ Usage

```java
WebDriver driver = DriverFactory.createDriver("chrome");
```

---

# ⭐ Professional Version (Factory + Singleton + ThreadLocal)

```java
public class DriverFactory {

    public static void initDriver(String browser) {

        WebDriver driver;

        switch (browser.toLowerCase()) {

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

# ✅ Flow

Test → BaseTest → DriverFactory → DriverManager → ThreadLocal

---

# ✅ Rule

Never create drivers directly in tests. Always use DriverFactory.
