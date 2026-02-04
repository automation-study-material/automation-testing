
# Selenium OOP Framework – Complete Guide (With Code)

This document contains **the full framework exactly matching the ZIP**, including:
- Folder structure
- All Java classes
- Extent Reports
- RetryAnalyzer
- Screenshot on failure
- Wait utilities
- Listener
- UML diagram

You can **download this `.md` file and keep it as notes or documentation**.

---

## 1. Folder Structure

```text
selenium-oops-framework/
│
├── src/main/java/
│   ├── base/
│   │   ├── BaseTest.java
│   │   └── BasePage.java
│   │
│   ├── driver/
│   │   └── DriverFactory.java
│   │
│   ├── interfaces/
│   │   └── BrowserActions.java
│   │
│   ├── pages/
│   │   └── LoginPage.java
│   │
│   ├── utils/
│   │   ├── ElementActions.java
│   │   ├── WaitUtils.java
│   │   └── ScreenshotUtil.java
│   │
│   ├── listeners/
│   │   ├── TestListener.java
│   │   └── RetryAnalyzer.java
│   │
│   └── reporting/
│       └── ExtentManager.java
│
├── src/test/java/
│   └── tests/
│       └── LoginTest.java
│
└── docs/
    └── README.md
```

---

## 2. DriverFactory.java (Encapsulation + ThreadLocal)

```java
package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private DriverFactory() {}

    public static WebDriver getDriver() {
        if (tlDriver.get() == null) {
            tlDriver.set(new ChromeDriver());
        }
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
```

---

## 3. BrowserActions.java (Interface – Abstraction)

```java
package interfaces;

public interface BrowserActions {
    void openUrl(String url);
    void refresh();
    void close();
}
```

---

## 4. BaseTest.java (Interface Implementation)

```java
package base;

import driver.DriverFactory;
import interfaces.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements BrowserActions {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void close() {
        DriverFactory.quitDriver();
    }

    @AfterMethod
    public void tearDown() {
        close();
    }
}
```

---

## 5. WaitUtils.java (Centralized Waits)

```java
package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisible(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
```

---

## 6. ElementActions.java (Composition + Polymorphism)

```java
package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementActions {

    private WebDriver driver;
    private WaitUtils wait;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void click(By locator) {
        wait.waitForVisible(locator);
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        wait.waitForVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }
}
```

---

## 7. BasePage.java (Abstract Class)

```java
package base;

import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public abstract class BasePage {

    protected WebDriver driver;
    protected ElementActions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }

    public abstract boolean isPageLoaded();
}
```

---

## 8. LoginPage.java (Inheritance + Overriding)

```java
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass) {
        actions.type(username, user);
        actions.type(password, pass);
        actions.click(loginBtn);
    }

    @Override
    public boolean isPageLoaded() {
        return driver.getTitle().contains("Login");
    }
}
```

---

## 9. RetryAnalyzer.java

```java
package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 2;

    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        }
        return false;
    }
}
```

---

## 10. ScreenshotUtil.java

```java
package utils;

import driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtil {

    public static String takeScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.FILE);

            String path = "target/screenshots/" + testName + ".png";
            File dest = new File(path);
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}
```

---

## 11. ExtentManager.java

```java
package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {
        if (extent == null) {
            ExtentSparkReporter reporter =
                new ExtentSparkReporter("target/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
```

---

## 12. TestListener.java (Listener + Screenshot + Report)

```java
package listeners;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onTestStart(ITestResult result) {
        test.set(ExtentManager.getReport().createTest(result.getName()));
    }

    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtil.takeScreenshot(result.getName());
        test.get().fail(result.getThrowable());
        if (path != null) {
            test.get().addScreenCaptureFromPath(path);
        }
    }

    public void onFinish(org.testng.ITestContext context) {
        ExtentManager.getReport().flush();
    }
}
```

---

## 13. LoginTest.java

```java
package tests;

import base.BaseTest;
import listeners.RetryAnalyzer;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validLoginTest() {
        openUrl("https://example.com/login");
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.isPageLoaded());
        lp.login("admin", "password");
    }
}
```

---

## 14. UML Diagram (Text)

```text
LoginTest
   |
   v
BaseTest ----> DriverFactory
   |
   v
BasePage <---- LoginPage
   |
   v
ElementActions
   |
   v
WaitUtils
```

---

## 15. Interview Summary

> This Selenium framework uses OOP principles including encapsulation, abstraction, inheritance, polymorphism, and composition. It supports parallel execution using ThreadLocal WebDriver, centralized waits, retry logic, screenshot capture on failure, and Extent Reports via TestNG listeners.
