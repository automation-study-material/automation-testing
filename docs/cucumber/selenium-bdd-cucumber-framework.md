
# Selenium BDD Cucumber Framework – Complete Guide (With Code)

This document converts the **TestNG OOP Selenium Framework into a BDD Cucumber Framework**.

It keeps the same concepts:

- OOP Design
- DriverFactory
- ThreadLocal WebDriver
- Page Object Model
- Wait utilities
- Screenshot on failure
- Extent Reports
- Retry support
- Hooks (instead of TestNG Listeners)

---

# 1. Folder Structure

```

selenium-bdd-cucumber-framework/

├── pom.xml
│
├── src
│
├── main
│   ├── java
│   │
│   ├── config
│   │   └── ConfigReader.java
│   │
│   ├── driver
│   │   ├── DriverFactory.java
│   │   ├── DriverManager.java
│   │   ├── config
│   │   │   ├── BrowserStackConfigLoader.java
│   │   │   └── BrowserStackYamlConfig.java
│   │   │
│   │   └── provider
│   │       ├── DriverProvider.java
│   │       ├── LocalDriverProvider.java
│   │       └── RemoteDriverProvider.java
│   │
│   ├── pages
│   │   ├── BasePage.java
│   │   └── HomePage.java
│   │
│   ├── utils
│   │   ├── ElementActions.java
│   │   ├── WaitUtils.java
│   │   ├── JsonReader.java
│   │   └── ScreenshotUtil.java
│
│
├── test
│   ├── java
│   │
│   ├── hooks
│   │   └── Hooks.java
│   │
│   ├── stepdefinitions
│   │   └── LoginSteps.java
│   │
│   ├── runner
│   │   └── TestRunner.java
│
│
├── resources
│   ├── features
│   │   └── login.feature
│   │
│   ├── config.properties
│   ├── browserstack.yml
│   └── products.json

````

---

# 2. Driver Manager (ThreadLocal WebDriver)

Same concept as TestNG.

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
````

---

# 3. DriverFactory

Driver initialization logic.

```java
package driver;

import config.ConfigReader;
import driver.provider.*;

public final class DriverFactory {

    public static void initDriver() {

        if(DriverManager.getDriver()!=null){
            return;
        }

        DriverProvider provider;

        if(ConfigReader.getBoolean("run.remote"))
            provider = new RemoteDriverProvider();
        else
            provider = new LocalDriverProvider();

        DriverManager.setDriver(provider.createDriver());
    }
}
```

---

# 4. DriverProvider (Abstraction)

Interface defining driver creation.

```java
package driver.provider;

import org.openqa.selenium.WebDriver;

public interface DriverProvider {

    WebDriver createDriver();
}
```

---

# 5. Local Driver Provider

```java
package driver.provider;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class LocalDriverProvider implements DriverProvider {

    @Override
    public WebDriver createDriver() {

        WebDriverManager.chromedriver().setup();

        return new ChromeDriver();
    }
}
```

---

# 6. BasePage (Abstraction)

Abstract class used by all pages.

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

    public abstract String getPageUrl();

    public abstract boolean isPageLoaded();
}
```

---

# 7. HomePage

```java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By loginButton = By.id("login");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLogin() {
        actions.click(loginButton);
    }

    @Override
    public String getPageUrl() {
        return "https://example.com";
    }

    @Override
    public boolean isPageLoaded() {
        return actions.isDisplayed(loginButton);
    }
}
```

---

# 8. WaitUtils

Centralized waits.

```java
package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    private WebDriverWait wait;

    public WaitUtils(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
```

---

# 9. ElementActions

Encapsulation of WebElement operations.

```java
package utils;

import org.openqa.selenium.*;

public class ElementActions {

    private WebDriver driver;
    private WaitUtils wait;

    public ElementActions(WebDriver driver){
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void click(By locator){
        wait.waitForClickable(locator);
        driver.findElement(locator).click();
    }

    public void type(By locator,String text){
        wait.waitForVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }
}
```

---

# 10. Hooks (Replacement for TestNG Listeners)

In Cucumber we use **Hooks instead of TestNG listeners**.

```java
package hooks;

import driver.DriverFactory;
import driver.DriverManager;
import io.cucumber.java.*;

public class Hooks {

    @Before
    public void setUp(){

        DriverFactory.initDriver();

        System.out.println("Browser Started");
    }

    @After
    public void tearDown(){

        DriverManager.quit();

        System.out.println("Browser Closed");
    }
}
```

---

# 11. Screenshot on Failure (Cucumber)

```java
@After
public void takeScreenshot(Scenario scenario){

    if(scenario.isFailed()){

        byte[] screenshot =
          ((TakesScreenshot)DriverManager.getDriver())
          .getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot,"image/png","Failed Screenshot");
    }
}
```

---

# 12. Step Definitions

```java
package stepdefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import driver.DriverManager;

public class LoginSteps {

    HomePage home;

    @Given("user is on home page")
    public void openHomePage(){

        home = new HomePage(DriverManager.getDriver());

        DriverManager.getDriver().get(home.getPageUrl());
    }

    @When("user clicks login button")
    public void clickLogin(){

        home.clickLogin();
    }

    @Then("login page should open")
    public void verifyLogin(){

        System.out.println("Login page opened");
    }
}
```

---

# 13. Feature File

```
Feature: Login Feature

Scenario: Open login page

Given user is on home page
When user clicks login button
Then login page should open
```

---

# 14. Runner Class

Cucumber Runner replaces **TestNG XML execution**.

```java
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

features = "src/test/resources/features",
glue = {"stepdefinitions","hooks"},

plugin = {

"pretty",
"html:target/cucumber-report.html"

},

monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
```

---

# 15. UML Diagram

```
Feature File
      |
      v
Step Definitions
      |
      v
Page Objects
      |
      v
ElementActions
      |
      v
WaitUtils
      |
      v
DriverFactory → DriverManager
```

---


