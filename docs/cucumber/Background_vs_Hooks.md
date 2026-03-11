
# 1️⃣ Where to Create Hooks Class

Hooks class is created inside the **step definition package** (or a hooks package).

Typical structure:

```text
src/test/java
 ├── runner
 │     TestRunner.java
 │
 ├── stepdefinitions
 │     LoginStepDefinition.java
 │
 ├── hooks
 │     Hooks.java
 │
src/test/resources
 └── features
       login.feature
```

Important point:

✔ Hooks are automatically detected **if the package is included in `glue` in Runner class**.

---

# 2️⃣ Feature File

`src/test/resources/features/login.feature`

```gherkin
Feature: Login functionality

Background:
  Given user launches browser
  And user navigates to login page

Scenario: Successful login
  When user enters username "admin"
  And user enters password "admin123"
  Then login should be successful

Scenario: Failed login
  When user enters username "admin"
  And user enters password "wrong"
  Then login should fail
```

---

# 3️⃣ Step Definition Class

`src/test/java/stepdefinitions/LoginStepDefinition.java`

```java
import io.cucumber.java.en.*;

public class LoginStepDefinition {

    String username;
    String password;

    @Given("user launches browser")
    public void launch_browser() {
        System.out.println("Browser launched");
    }

    @Given("user navigates to login page")
    public void navigate_login_page() {
        System.out.println("Navigated to login page");
    }

    @When("user enters username {string}")
    public void enter_username(String username) {
        this.username = username;
        System.out.println("Entered username: " + username);
    }

    @When("user enters password {string}")
    public void enter_password(String password) {
        this.password = password;
        System.out.println("Entered password: " + password);
    }

    @Then("login should be successful")
    public void login_success() {
        if(username.equals("admin") && password.equals("admin123")) {
            System.out.println("Login Successful");
        }
    }

    @Then("login should fail")
    public void login_fail() {
        if(!password.equals("admin123")) {
            System.out.println("Login Failed");
        }
    }
}
```

---

# 4️⃣ Hooks Class

`src/test/java/hooks/Hooks.java`

```java
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void beforeScenario() {
        System.out.println("Before Hook → Setup browser");
    }

    @After
    public void afterScenario() {
        System.out.println("After Hook → Close browser");
    }
}
```

Purpose:

✔ Setup environment
✔ Launch browser
✔ Cleanup after test

---

# 5️⃣ Runner Class

`src/test/java/runner/TestRunner.java`

```java
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions","hooks"},
        plugin = {"pretty","html:target/cucumber-report.html"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
```

Important part:

```java
glue = {"stepdefinitions","hooks"}
```

This tells Cucumber to scan:

✔ Step Definitions
✔ Hooks

---

# 6️⃣ Execution Order

For **each scenario**, execution order is:

```
Before Hook
Background Steps
Scenario Steps
After Hook
```

---

# 7️⃣ Execution Output

### Scenario 1

```
Before Hook → Setup browser

Browser launched
Navigated to login page

Entered username: admin
Entered password: admin123

Login Successful

After Hook → Close browser
```

---

### Scenario 2

```
Before Hook → Setup browser

Browser launched
Navigated to login page

Entered username: admin
Entered password: wrong

Login Failed

After Hook → Close browser
```

---

# 8️⃣ Execution Flow

```
Scenario 1
---------
Before Hook
Background
Scenario Steps
After Hook

Scenario 2
---------
Before Hook
Background
Scenario Steps
After Hook
```

Hooks run **before and after every scenario**.

---

# 9️⃣ Short Interview Answer

**Where do we create Hooks in Cucumber?**

Hooks are created in a separate class (usually `Hooks.java`) inside the **step definition or hooks package**.

They are mapped automatically using the **glue option in the Runner class**.

Example:

```java
glue = {"stepdefinitions","hooks"}
```

---

✅ Since you are preparing **BDD + Cucumber topics**, the **next very important interview topic is:**

**Scenario Context / Sharing data between Step Definitions**

This is asked in **almost every Selenium + Cucumber interview for 3–5 years experience**, and many candidates struggle with it.
