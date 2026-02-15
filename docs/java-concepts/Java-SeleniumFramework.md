
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

selenium-oops-framework/ 
├── pom.xml
├── testng.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── config     
│   │   │   │   └── ConfigReader.java // Read Config.properties file and override default properties
│   │   │   ├── driver
│   │   │   │   ├── [DriverFactory.java](#b-driver-factory-provide-driver-instance-bases-on-cloud-or-local-provider)
│   │   │   │   ├── DriverManager.java
│   │   │   │   ├── config
│   │   │   │   │   ├── BrowserStackConfigLoader.java
│   │   │   │   │   └── BrowserStackYamlConfig.java
│   │   │   │   └── provider
│   │   │   │       ├── DriverProvider.java
│   │   │   │       ├── LocalDriverProvider.java
│   │   │   │       └── RemoteDriverProvider.java
│   │   │   ├── pages
│   │   │   │   ├── BasePage.java
│   │   │   │   └── HomePage.java
│   │   │   ├── utils
│   │   │   │   ├── ElementActions.java
│   │   │   │   ├── WaitUtils.java
│   │   │   │   └── JsonReader.java
│   │   │   └── orderflow
│   │   │       └── ProductOrderData.java
│   │   └── resources
│   │       ├── config.properties
│   │       ├── browserstack.yml
│   │       └── products.json
│   └── test
│       └── java
│           ├── base
│           │   └── BaseTest.java
│           └── tests
│               └── GoogleTest.java


## 2. Driver Factory -> DriverManager + DriverFactory

### A. Driver Manager: Its Create WebDriver Instance.
```java
package driver;
import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager(){}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver drv) {
        driver.set(drv);
    }

    public static void quit() {
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }
}
```
### B. Driver Factory: Provide driver instance bases on Cloud or Local provider
```java
package driver;
import config.ConfigReader;
import driver.provider.*;

public final class DriverFactory {

	public static void initDriver() {
		
		if (DriverManager.getDriver()!=null) {
			return;
		}
		DriverProvider provider;
		if (ConfigReader.getBoolean("run.remote"))
			provider = new RemoteDriverProvider();
		else
			provider = new LocalDriverProvider();
		DriverManager.setDriver(provider.createDriver());
	}
}
```

## 3. DriverProvider -  Abstraction => Interface + Overriding

### A. Interface: Its provide Webdriver creation instance based on Driver provider

```java
package driver.provider;

import org.openqa.selenium.WebDriver;

public interface DriverProvider {

	WebDriver createDriver();
}
```
### B. Local WebDriver ceration
```java
package driver.provider;
import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.edge.*;

public class LocalDriverProvider implements DriverProvider {

    @Override
    public WebDriver createDriver() {

        String browser = ConfigReader.get("browser").toLowerCase();
        boolean headless = ConfigReader.getBoolean("headless");

        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chrome = new ChromeOptions();
                if(headless) chrome.addArguments("--headless=new");
                return new ChromeDriver(chrome);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefox = new FirefoxOptions();
                if(headless) firefox.addArguments("-headless");
                return new FirefoxDriver(firefox);

            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }
}

```
### C. Cloud WebDriver ceration
```java
package driver.provider;

import driver.config.BrowserStackConfigLoader;
import driver.config.BrowserStackYamlConfig;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class RemoteDriverProvider implements DriverProvider {

    @Override
    public WebDriver createDriver() {

        BrowserStackYamlConfig cfg = BrowserStackConfigLoader.get();

        MutableCapabilities caps =
                new MutableCapabilities(cfg.getCapabilities());

        MutableCapabilities opts =
                new MutableCapabilities(cfg.getOptions());

        opts.setCapability("userName", cfg.getBrowserstack().getUser());
        opts.setCapability("accessKey", cfg.getBrowserstack().getKey());

        caps.setCapability("bstack:options", opts);

        try {
            return new RemoteWebDriver(
                    new URL(cfg.getBrowserstack().getHub()),
                    caps
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
```
## 4. BasePage - Abstraction - Abstract class + Overriding

```java
package pages;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public abstract class BasePage {

    protected WebDriver driver;
    protected ElementActions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }

  =================================
   implemented in Pages class
  ==================================
    public abstract String getPageUrl();  
    public abstract boolean isPageLoaded();
    public abstract boolean isCorrectpageTitle();
    public abstract boolean isCorrectPageUrl();
}
```
## 5. Home Page
```
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import utils.ElementActions;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
        super(driver);
    }

	private static final String PRODUCT = "//*[text()='%s']";
	
	
	private By getProductName(String name) {
	    return By.xpath(String.format(PRODUCT, name));
	}

    public void selectProduct(String productName) {
        actions.click(getProductName(productName));
    }

    public boolean isProductVisible(String name) {
        return actions.isDisplayed(getProductName(name));
    }

	@Override
	public boolean isPageLoaded() {
		
		return false;
	}

	@Override
	public boolean isCorrectpageTitle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCorrectPageUrl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPageUrl() {
		String urlString="";
		if (ConfigReader.getBoolean("prod")) {
			System.out.println("PROD URL");
			urlString="https://demoblaze.com/";
		}else {
			System.out.println("STAGE URL");
			urlString="https://demoblaze.com/";
		}
		return urlString;
	}
}
```
## 6. ElementActions
```java
package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {

    private WebDriver driver;
    private WaitUtils wait;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    // =========================
    // Basic Actions
    // =========================

    public void click(By locator) {
        wait.waitForClickable(locator);
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        wait.waitForVisible(locator);
        WebElement el = driver.findElement(locator);
        el.clear();
        el.sendKeys(text);
    }

    public void clear(By locator) {
        wait.waitForVisible(locator);
        driver.findElement(locator).clear();
    }

    // =========================
    // Getters
    // =========================

    public String getText(By locator) {
        wait.waitForVisible(locator);
        return driver.findElement(locator).getText();
    }

    public String getAttribute(By locator, String attr) {
        return driver.findElement(locator).getAttribute(attr);
    }

    // =========================
    // State checks
    // =========================

    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public boolean isEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    public boolean isSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }

    // =========================
    // Checkbox helpers
    // =========================

    public void check(By locator) {
        if (!isSelected(locator)) {
            click(locator);
        }
    }

    public void uncheck(By locator) {
        if (isSelected(locator)) {
            click(locator);
        }
    }

    // =========================
    // Dropdown
    // =========================

    public void selectByText(By locator, String text) {
        wait.waitForVisible(locator);
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }

    public void selectByValue(By locator, String value) {
        new Select(driver.findElement(locator)).selectByValue(value);
    }

    public void selectByIndex(By locator, int index) {
        new Select(driver.findElement(locator)).selectByIndex(index);
    }

    // =========================
    // Mouse Actions
    // =========================

    public void hover(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }

    public void doubleClick(By locator) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(locator)).perform();
    }

    public void rightClick(By locator) {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(locator)).perform();
    }

    // =========================
    // Scroll
    // =========================

    public void scrollIntoView(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", el);
    }

    // =========================
    // JavaScript click (fallback)
    // =========================

    public void jsClick(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", el);
    }

    // =========================
    // File Upload
    // =========================

    public void uploadFile(By locator, String path) {
        driver.findElement(locator).sendKeys(path);
    }

    // =========================
    // Generic find
    // =========================

    public WebElement find(By locator) {
        wait.waitForPresence(locator);
        return driver.findElement(locator);
    } 
}
```


## 7. WaitUtils.java (Centralized Waits)

```java
package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final int DEFAULT_TIMEOUT = 10;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    // =========================
    // Element waits
    // =========================

    public void waitForVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForTextToBePresent(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void waitForAttributeContains(By locator, String attribute, String value) {
        wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    // =========================
    // Page waits
    // =========================

    public void waitForTitleContains(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    public void waitForUrlContains(String partialUrl) {
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    // =========================
    // Alert & Frame waits
    // =========================

    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForFrameAndSwitch(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    // =========================
    // Custom timeout method
    // =========================

    public void waitForVisible(By locator, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

```


## 8. RetryAnalyzer.java

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

## 9. TestListener.java (Listener + Screenshot + Report)

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


## 12. LoginTest.java

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

## 13. UML Diagram (Text)

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
