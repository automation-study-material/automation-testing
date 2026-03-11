# BDD Cucumber with Java – Deep Dive (0 → 4 Years Experience)

These notes are written from an **interview + real project perspective**. Every concept explains:

* **What it is**
* **Why it exists**
* **When to use it**
* **How it works internally**
* **Complete runnable code examples**

This is exactly the level expected from a **3–4 year Automation Engineer**.

---

## 1. What is BDD?

**BDD (Behavior Driven Development)** is a development approach where:

* Business users
* Developers
* Testers

collaborate using **common language**.

BDD focuses on **behavior**, not implementation.

### Why BDD was introduced

* Test cases were too technical
* Business couldn’t understand automation tests
* Gap between requirement and implementation

BDD solves this by using **Gherkin language**.

---

## 2. What is Cucumber?

**Cucumber** is a BDD tool that:

* Reads feature files written in Gherkin
* Maps steps to Java code (Step Definitions)
* Executes scenarios as automated tests

Cucumber itself does **not automate UI or API**.
It integrates with:

* Selenium
* REST Assured
* Playwright

---

## 3. Gherkin Language (Core of Cucumber)

### Keywords

* Feature
* Scenario
* Scenario Outline
* Given
* When
* Then
* And / But
* Background
* Examples
* DataTable

Gherkin is:

* Plain English
* Business readable
* Structured

---

## 4. Feature File Structure (Complete Example)

```gherkin
Feature: Login functionality

  Background:
    Given user launches application

  Scenario: Valid login
    When user enters username "admin"
    And user enters password "admin123"
    And user clicks login
    Then user should see homepage

  Scenario: Invalid login
    When user enters username "admin"
    And user enters password "wrong"
    And user clicks login
    Then error message should be displayed
```

### Explanation

* **Feature** → High-level business functionality
* **Background** → Common pre-condition
* **Scenario** → One test case

---

## 5. Step Definitions (Glue Between Feature & Code)

```java
public class LoginSteps {

    @Given("user launches application")
    public void launchApp() {
        System.out.println("Application launched");
    }

    @When("user enters username {string}")
    public void enterUsername(String username) {
        System.out.println("Username: " + username);
    }

    @When("user enters password {string}")
    public void enterPassword(String password) {
        System.out.println("Password: " + password);
    }

    @When("user clicks login")
    public void clickLogin() {
        System.out.println("Login clicked");
    }

    @Then("user should see homepage")
    public void verifyHome() {
        System.out.println("Homepage displayed");
    }
}
```

---

## 6. Scenario Outline (Data Driven Testing)

Used when **same scenario runs with multiple data sets**.

```gherkin
Scenario Outline: Login with multiple users
  When user enters username "<username>"
  And user enters password "<password>"
  And user clicks login
  Then login result should be "<result>"

Examples:
| username | password | result  |
| admin    | admin123 | success |
| admin    | wrong    | failure |
```

### Step Definition

```java
@Then("login result should be \"(.*)\"")
public void verifyResult(String result) {
    System.out.println("Result: " + result);
}
```

---

## 7. DataTable (Multiple Data in One Step)

Used when **structured data** is required.

### Feature File

```gherkin
Scenario: Create user
  When user enters user details
    | name | John |
    | role | QA   |
    | age  | 30   |
```

### Step Definition

```java
@When("user enters user details")
public void userDetails(DataTable table) {
    Map<String, String> data = table.asMap(String.class, String.class);
    System.out.println(data.get("name"));
}
```

---

## 8. Background (Pre-condition)

Runs **before every scenario** in the feature file.

### When to use

* Login
* Launch browser
* Setup test data

Avoid heavy logic in Background.

---

## 9. Hooks (@Before, @After)

Used for **setup and teardown**.

```java
public class Hooks {

    @Before
    public void setup() {
        System.out.println("Before scenario");
    }

    @After
    public void tearDown() {
        System.out.println("After scenario");
    }
}
```

---

## 10. Tags (Selective Execution)

```gherkin
@smoke
Scenario: Valid login

@regression
Scenario: Invalid login
```

### Run using tags

```java
@CucumberOptions(tags = "@smoke")
```

---

## 11. Runner Class (IN DEPTH – VERY IMPORTANT)

```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepdefinitions",
    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber.json"
    },
    monochrome = true,
    dryRun = false,
    tags = "@smoke"
)
public class TestRunner {
}
```

### Meaning of Each Keyword

* **features** → Feature file location
* **glue** → Step definition package
* **plugin** → Reports
* **monochrome** → Readable console output
* **dryRun** → Validate step mapping without execution
* **tags** → Selective execution

---

## 12. Retry Failed Scenarios (Real Time)

Cucumber doesn’t support retry directly. We integrate with **TestNG**.

### Retry Analyzer

```java
public class Retry implements IRetryAnalyzer {
    int count = 0;
    int maxRetry = 2;

    public boolean retry(ITestResult result) {
        if (count < maxRetry) {
            count++;
            return true;
        }
        return false;
    }
}
```

---

## 13. Rerun Failed Scenarios

### plugin

```java
plugin = {"rerun:target/failed.txt"}
```

### Runner for Failed

```java
@CucumberOptions(features = "@target/failed.txt")
```

---

## 14. Parallel Execution (4 Years Interview Topic)

### Scenario Level Parallel – TestNG

```xml
<suite parallel="tests" thread-count="4">
```

### Feature Level Parallel

```java
@CucumberOptions(parallel = true)
```

---

## 15. Real-Time Framework Structure

```
src/test/java
 ├── runners
 ├── stepdefinitions
 ├── hooks
 ├── pages
 └── utils
```

---

## 16. Common Interview Questions (4 Years Level)

### Q1. Why Cucumber if we already have TestNG?

**Answer:** Business-readable tests, better collaboration.

### Q2. Difference between Scenario and Scenario Outline?

**Answer:** Outline supports data-driven testing.

### Q3. How do you rerun failed scenarios?

**Answer:** Using rerun plugin.

### Q4. How do you achieve parallel execution?

**Answer:** Using TestNG and runner configuration.

### Q5. How do you handle flaky tests?

**Answer:** Retry mechanism + root cause analysis.

---

## 17. When NOT to use Cucumber (Senior Insight)

* Highly technical flows
* Low business involvement
* Complex data-driven logic

---

## 18. Final Interview Tips

* Don’t say "Cucumber automates UI"
* Explain BDD philosophy
* Mention limitations
* Talk about real problems you solved

---

If you want next:

* Complete **Cucumber + Selenium framework**
* **Cucumber + API (REST Assured)** integration
* **Extent reports**
* **Jenkins + Cucumber pipeline**
* **Mock interview Q&A**

Review slowly and tell me what to expand.

---

# 19. Complete Cucumber + Selenium Framework (Print‑Statement Based for Understanding Flow)

Below framework is **real-project structured**, but Selenium actions are replaced with **print statements** so you clearly understand **execution flow**.

---

## 19.1 Framework Structure

```
src/test/java
 ├── runners
 │    └── TestRunner.java
 ├── stepdefinitions
 │    └── LoginSteps.java
 ├── hooks
 │    └── Hooks.java
 ├── utils
 │    └── DriverFactory.java
 └── pages
      └── LoginPage.java
```

---

## 20. End‑to‑End Login Scenario (Error Message – Implemented)

### Feature File

```gherkin
Feature: Login validation

  Background:
    Given browser is launched
    And application is opened

  Scenario: Invalid login
    When user enters username "admin"
    And user enters password "wrong"
    And user clicks login
    Then error message should be displayed
```

---

### Step Definition (With Print Flow)

```java
public class LoginSteps {

    @Given("browser is launched")
    public void launchBrowser() {
        System.out.println("[BACKGROUND] Browser launched");
    }

    @Given("application is opened")
    public void openApp() {
        System.out.println("[BACKGROUND] Application opened");
    }

    @When("user enters username \"(.*)\"")
    public void enterUsername(String user) {
        System.out.println("[STEP] Enter username: " + user);
    }

    @When("user enters password \"(.*)\"")
    public void enterPassword(String pass) {
        System.out.println("[STEP] Enter password: " + pass);
    }

    @When("user clicks login")
    public void clickLogin() {
        System.out.println("[STEP] Click login button");
    }

    @Then("error message should be displayed")
    public void errorMessage() {
        System.out.println("[ASSERTION] Error message displayed ❌");
    }
}
```

---

### Execution Output (Console Flow)

```
[BACKGROUND] Browser launched
[BACKGROUND] Application opened
[STEP] Enter username: admin
[STEP] Enter password: wrong
[STEP] Click login button
[ASSERTION] Error message displayed ❌
```

---

# 21. DataTable – Complete Scenario + Background + Output

### Feature File

```gherkin
Feature: User creation

  Background:
    Given admin is logged in

  Scenario: Create user with details
    When admin enters user details
      | name | John |
      | role | QA   |
      | age  | 30   |
    Then user should be created
```

---

### Step Definition

```java
@Given("admin is logged in")
public void adminLogin() {
    System.out.println("[BACKGROUND] Admin logged in");
}

@When("admin enters user details")
public void enterDetails(DataTable table) {
    Map<String, String> data = table.asMap(String.class, String.class);
    System.out.println("[STEP] Name: " + data.get("name"));
    System.out.println("[STEP] Role: " + data.get("role"));
    System.out.println("[STEP] Age: " + data.get("age"));
}

@Then("user should be created")
public void verifyUser() {
    System.out.println("[ASSERTION] User created successfully ✅");
}
```

---

### Output

```
[BACKGROUND] Admin logged in
[STEP] Name: John
[STEP] Role: QA
[STEP] Age: 30
[ASSERTION] User created successfully ✅
```

---

# 22. Hooks – Execution Order Explained (Very Important)

```java
public class Hooks {

    @Before
    public void beforeScenario() {
        System.out.println("[HOOK] Before Scenario");
    }

    @After
    public void afterScenario() {
        System.out.println("[HOOK] After Scenario");
    }
}
```

### Execution Order

```
[HOOK] Before Scenario
[BACKGROUND] ...
[STEP] ...
[ASSERTION] ...
[HOOK] After Scenario
```

---

# 23. Tags – Skip, Multiple Tags, Combination

### Feature File

```gherkin
@smoke @login
Scenario: Valid login

@regression @skip
Scenario: Invalid login
```

---

### Runner Examples

#### Run Single Tag

```java
tags = "@smoke"
```

#### Run Multiple Tags (OR)

```java
tags = "@smoke or @regression"
```

#### Run Multiple Tags (AND)

```java
tags = "@smoke and @login"
```

#### Skip Tag

```java
tags = "not @skip"
```

---

# 24. Extent Reports with Cucumber (Conceptual)

```java
plugin = {
  "pretty",
  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
```

Output:

* Step wise report
* Pass / Fail status
* Screenshot hooks (UI projects)

---

# 25. Jenkins + Cucumber Pipeline (Real‑Time)

```groovy
pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps { git 'repo-url' }
    }
    stage('Run Tests') {
      steps { sh 'mvn clean test' }
    }
  }
}
```

---

# 26. Mock Interview Q&A (4 Years – Real)

### Q1. Explain Cucumber execution flow

**Answer:** Hooks → Background → Scenario Steps → Assertions → After Hooks

### Q2. How do you debug step failures?

**Answer:** Enable logs, dryRun, rerun failed scenarios.

### Q3. How do you skip scenarios?

**Answer:** Using tags with `not` operator.

### Q4. Why use Cucumber over TestNG?

**Answer:** Business readability and collaboration.

---

# 27. Final Senior Tips

* Don’t overuse Cucumber
* Keep steps reusable
* Avoid logic in feature files
* Use Background carefully

---
