
# 🚀 Selenium Config Override Guide (Enterprise Ready)

---

# 🧠 Architecture (Selenium Perspective)

```text
config.properties (defaults)
        ↓
CLI -D overrides
        ↓
ConfigManager (priority logic)
        ↓
DriverFactory (create WebDriver)
        ↓
Hooks (@Before / @After)
        ↓
Tests
```

---

# ✅ Step 1 — config.properties (Default values)

📁 src/test/resources/config.properties

```properties
browser=chrome
url=https://google.com
headless=false
timeout=10
env=qa
```

These are fallback defaults.

---

# ✅ Step 2 — ConfigManager (Override Logic)

## 🔥 ConfigManager.java

```java
package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties prop = new Properties();

    // load config file once
    static {
        try {
            prop.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (Exception e) {
            System.out.println("config.properties not found");
        }
    }

    // CLI > config
    public static String get(String key) {
        String cli = System.getProperty(key);

        if (cli != null && !cli.isEmpty()) {
            return cli;
        }

        return prop.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }
}

```

---

# 🧠 Override Logic Explained

```java
System.getProperty(key, prop.getProperty(key));
```

Priority:

```
CLI (-D)  → highest
config file → fallback
hardcoded → last
```

---

# ✅ Step 3 — DriverFactory

```java
package factory;

import utils.ConfigManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = ConfigManager.get("browser");
        boolean headless = ConfigManager.getBoolean("headless");
        int timeout = ConfigManager.getInt("timeout");

        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                if (headless) options.addArguments("--headless=new");
                driver.set(new ChromeDriver(options));
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}
```

---

# ✅ Step 4 — Hooks

```java
import factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
```

---

# ✅ Step 5 — Use in Steps

```java
DriverFactory.getDriver().get(ConfigManager.get("url"));
```

---

# 🚀 Parallel Execution Section

## Why ThreadLocal?

Each thread gets its own browser instance.

```
Thread 1 → Chrome
Thread 2 → Chrome
Thread 3 → Chrome
```

No sharing → No flaky tests.

## Maven Parallel Config

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-surefire-plugin</artifactId>
  <configuration>
    <parallel>methods</parallel>
    <threadCount>3</threadCount>
  </configuration>
</plugin>
```

Run:

```bash
mvn test -Dbrowser=chrome
```

---

# 🚀 Environment Based Config Switching

## Files

```
config-qa.properties
config-prod.properties
```

## Load dynamically

```java
String env = System.getProperty("env", "qa");
FileInputStream fis = new FileInputStream("config-" + env + ".properties");
```

Run:

```bash
mvn test -Denv=prod
```

---

# 🚀 Jenkins Parameterized Pipeline

Pipeline:

```bash
mvn clean test -Dbrowser=${browser} -Denv=${env}
```

Jenkins → CLI → Framework automatically

---

# 📁 Full Framework Template (Recommended Structure)

```
src
 ├─ main
 ├─ test
 │   ├─ factory
 │   │     └─ DriverFactory.java
 │   ├─ utils
 │   │     └─ ConfigManager.java
 │   ├─ hooks
 │   │     └─ Hooks.java
 │   ├─ stepdefinitions
 │   ├─ runners
 │   └─ resources
 │         ├─ config.properties
 │         ├─ config-qa.properties
 │         └─ config-prod.properties
```

---

# 🎯 Final Cheat Sheet

| Task | Command |
|-----|--------|
| Default run | mvn test |
| Override browser | mvn test -Dbrowser=firefox |
| Override many | mvn test -Dbrowser=chrome -Dheadless=true |
| Prod env | mvn test -Denv=prod |

---

# 🏆 Final Rule

```
CLI overrides everything
config.properties provides defaults
DriverFactory consumes final values
```

Production Ready ✔
