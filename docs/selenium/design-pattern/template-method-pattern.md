# ⭐ Step 4 — Template Method Pattern (BaseTest) in Selenium Framework

---

# 🧠 Why did Template Method come into picture?

Let’s see a common beginner mistake.

## ❌ Without BaseTest

Every test class repeats setup and teardown.

```java
public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
```

Now imagine:

- 50 test classes
- Same setup/teardown copied everywhere
- Want to add logging or config

💥 You must update 50 files manually.

---

# 🚨 Problems Without Template Method

- ❌ Duplicate setup code
- ❌ Hard maintenance
- ❌ Inconsistent configuration
- ❌ Poor scalability
- ❌ Violation of DRY principle

---

# 🎯 Core Idea of Template Method (1 line)

> Define test execution flow once in a parent class and reuse it everywhere.

We create:

👉 One BaseTest  
👉 All tests extend it

---

# ✅ Step-by-Step Implementation

## BaseTest.java

```java
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {

        String browser = System.getProperty("browser", "chrome");

        DriverFactory.initDriver(browser);

        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {

        DriverManager.quitDriver();
    }
}
```

---

## LoginTest.java

```java
public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());

        loginPage.login("admin", "123");
    }
}
```

---

# 🎯 Benefits

- ✅ Setup written once
- ✅ Clean tests
- ✅ Easy maintenance
- ✅ Consistent lifecycle
- ✅ Highly scalable

---

# 🎯 Flow

TestNG → BaseTest.setup() → Test → BaseTest.teardown()

---

# 🧠 Interview Answer

Template Method defines a fixed execution flow in a parent class.  
All tests inherit it to reuse setup and teardown logic, keeping tests clean and maintainable.

---

# ✅ Rule

Never setup driver inside each test. Always extend BaseTest.
