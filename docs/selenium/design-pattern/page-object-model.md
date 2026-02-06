# ⭐ Step 1 — Page Object Model (POM) in Selenium Framework

---

# 🧠 Why did POM come into picture?

Early Selenium tests directly interacted with WebDriver inside test methods.

## ❌ Without POM

```java
@Test
public void loginTest() {
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("password")).sendKeys("123");
    driver.findElement(By.id("loginBtn")).click();
}
```

Looks fine for 1–2 tests…

But imagine:

- 200+ tests
- Same login steps repeated
- Locator changes

💥 Result → update 200 files manually

---

# 🚨 Problems Without POM

- ❌ Tight coupling between test & UI
- ❌ Duplicate code
- ❌ Hard maintenance
- ❌ Poor readability
- ❌ Not scalable

---

# 🎯 Core Idea of POM (1 line)

> Each web page = one Java class

Tests should NOT talk directly to Selenium.  
Tests should talk to **Page methods**.

---

# ✅ Big Idea

### Tests should NEVER do:

```java
driver.findElement()
```

### Tests should ALWAYS do:

```java
loginPage.login()
```

---

# 📦 Framework Structure

```
src
 ├── tests
 ├── pages
 └── base
```

---

# ✅ Step-by-Step Implementation

---

# 🟢 Step 1 — Create Page Class

## LoginPage.java

```java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    private By username = By.id("user");
    private By password = By.id("pass");
    private By loginBtn = By.id("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}
```

---

# 🟢 Step 2 — Write Test

## LoginTest.java

```java
@Test
public void loginTest() {

    LoginPage loginPage = new LoginPage(driver);

    loginPage.login("admin", "123");
}
```

---

# 🧠 Compare

## ❌ Before

```java
driver.findElement(By.id("user"))
driver.findElement(By.id("pass"))
driver.findElement(By.id("login"))
```

## ✅ After

```java
loginPage.login()
```

Cleaner + readable + maintainable

---

# 🎯 Benefits of POM

## ✅ Single Responsibility
Each class handles one page only

---

## ✅ No Duplication
Write steps once, reuse everywhere

---

## ✅ Easy Maintenance
Change locator once → works everywhere

---

## ✅ Readable Tests
Tests look like business flow

```
loginPage.login()
homePage.search()
cartPage.checkout()
```

---

## ✅ Scalable
Works for 1000+ tests

---

# ⭐ Real-World Enhancement (BasePage)

## BasePage.java

```java
public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
}
```

---

## LoginPage extends BasePage

```java
public class LoginPage extends BasePage {

    private By username = By.id("user");
    private By password = By.id("pass");
    private By loginBtn = By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }
}
```

---

# 🎯 Flow Diagram

```
Test → Page Object → Selenium
```

---

# 🧠 Interview Answer

POM separates UI locators and page actions from tests.  
It improves maintainability, readability, and reusability while reducing duplication.

---

# ✅ Simple Rule

### Never:
❌ driver.findElement() inside tests

### Always:
✅ page methods
