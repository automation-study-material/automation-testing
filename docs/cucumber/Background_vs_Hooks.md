
# Cucumber Background and Hooks – Interview Notes

These notes cover:

- Background in Cucumber
- Hooks in Cucumber
- Feature file example
- Step Definitions
- Hooks implementation
- Runner configuration
- Execution order
- Console output
- Differences
- Interview answers

---

# 1️⃣ Background in Cucumber

## Definition

`Background` is used to run **common steps before every scenario in a feature file**.

Instead of repeating steps in each scenario, we define them once in **Background**.

## Key Points

1. Runs **before every scenario** in the feature file
2. Defined inside the **Feature file**
3. Used for **common preconditions**
4. Improves **readability and avoids duplication**

---

# 2️⃣ Hooks in Cucumber

Hooks allow execution of code **before or after scenarios**.

They are used for **test setup and cleanup**.

## Types of Hooks

| Hook | Purpose |
|-----|--------|
| `@Before` | Runs before each scenario |
| `@After` | Runs after each scenario |
| `@BeforeStep` | Runs before every step |
| `@AfterStep` | Runs after every step |

Hooks are defined in **Java classes inside the step definition or hooks package**.

---

# 3️⃣ Project Structure

Typical Selenium + Cucumber project structure:

```

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

Hooks are automatically detected **if the package is included in the Runner class glue option**.

---

# 4️⃣ Feature File

`src/test/resources/features/login.feature`

```gherkin
Feature: Login functionality

Background:
  Given user launches the browser
  And user navigates to login page

Scenario: Successful login
  When user enters username "admin"
  And user enters password "admin123"
  Then login should be successful

Scenario: Failed login
  When user enters username "admin"
  And user enters password "wrong"
  Then login should fail
````

---

# 5️⃣ Step Definition Class

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

# 6️⃣ Hooks Class

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

Purpose of Hooks:

* Setup environment
* Launch browser
* Close browser after test

---

# 7️⃣ Runner Class

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

Important configuration:

```
glue = {"stepdefinitions","hooks"}
```

This tells Cucumber to scan:

* Step Definitions
* Hooks classes

---

# 8️⃣ Execution Order

For each scenario execution order is:

```
Before Hook
Background Steps
Scenario Steps
After Hook
```

---

# 9️⃣ Console Output After Execution

## Scenario 1 (Successful Login)

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

## Scenario 2 (Failed Login)

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

# 🔟 Execution Flow

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

Background runs **before every scenario**.

---

# 1️⃣1️⃣ Difference Between Background and Hooks

| Feature    | Background           | Hooks                  |
| ---------- | -------------------- | ---------------------- |
| Location   | Feature file         | Java class             |
| Visibility | Visible to business  | Hidden implementation  |
| Purpose    | Common test steps    | Setup & teardown       |
| Execution  | Before each scenario | Before/After scenarios |

---

# 1️⃣2️⃣ Short Interview Answers

## What is Background in Cucumber?

Background is used to define common steps that run before every scenario in a feature file.

---

## What are Hooks in Cucumber?

Hooks are methods annotated with `@Before` and `@After` that execute setup and cleanup code before or after each scenario.

---

## Where do we create Hooks in Cucumber?

Hooks are created in a separate Java class (usually `Hooks.java`) inside the **stepdefinitions or hooks package**.

They are mapped automatically using the **glue option in the Runner class**.

Example:

```java
glue = {"stepdefinitions","hooks"}
```

---

# 1️⃣3️⃣ Important Advanced Cucumber Topics

Commonly asked in **3–5 years Selenium Automation interviews**:

* Step Definition Ambiguity
* Custom Parameter Types
* DataTableType Mapping
* Parallel Execution with Cucumber + TestNG
* Scenario Context / Dependency Injection

---

```

If you want, I can also give you a **very powerful single-page Cucumber cheat sheet (.md)** covering:

- Background  
- Hooks  
- Scenario Outline  
- DataTable  
- Regex matching  
- Step Definition mapping  

This **one sheet is enough for most Selenium + Cucumber interviews.**
```
