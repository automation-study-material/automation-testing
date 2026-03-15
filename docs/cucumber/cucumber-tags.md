
# Cucumber Tags + Hooks + Parallel – Crystal Clear Guide (with Execution Order & Output)

This guide explains everything with **small feature examples + exact execution output** so you can visually understand behavior.

---
# ✅ Tag Example
```java
@smoke
Feature: Login

  Scenario: Valid login

  @regression
  Scenario: Invalid login
```
Run
```text
tags = "@smoke"
```

Output
```text
Internally feature level tag applied to scenario
Scenario: Valid login
Scenario: Invalid login
```
# ✅ Hook + Tag Combined Examples (Clear + Practical)

## Feature

```gherkin
@smoke
Feature: Login

  Scenario: Login test
    Given user opens app
```

---

## Hook

```java
@Before("@smoke")
public void smokeSetup() {
    System.out.println("Smoke setup");
}
```

---

## ✅ Execution Order

```
Smoke setup
Given user opens app
```

👉 Runs ONLY for @smoke scenarios

---

------------------------------------------------------------
# ✅ Multiple Tag Hook Example
------------------------------------------------------------

## Hook

```java
@Before("@smoke and not @api")
public void smokeOnlyUI() {
    System.out.println("Only UI smoke test");
}
```

## Feature

```gherkin
@smoke @ui
Scenario: UI smoke

@smoke @api
Scenario: API smoke
```

## Execution

```
Only UI smoke test   ✔ for UI
(no hook)            ❌ for API
```

👉 Hook runs only when BOTH conditions match

---

------------------------------------------------------------
# ✅ Combined Order + Tag (Very Important)
------------------------------------------------------------

## Hooks


Your code is related to **BDD Cucumber Hooks** in **Java + Selenium**.
`@Before` hooks run **before every scenario** execution.

Let’s understand step-by-step.

---

# 1️⃣ Your Hook Code

```java
@Before(order = 1)
public void globalSetup() {
    System.out.println("Global setup");
}

@Before(value = "@smoke", order = 2)
public void smokeSetup() {
    System.out.println("Smoke setup");
}
```

## Explanation

### Hook 1

```java
@Before(order = 1)
```

**Meaning**

1. This hook runs **before every scenario**.
2. `order = 1` means it will run **first**.

Method:

```java
public void globalSetup() {
    System.out.println("Global setup");
}
```

Example real usage:

* Launch browser
* Load configuration
* Setup test data

---

### Hook 2

```java
@Before(value = "@smoke", order = 2)
```

**Meaning**

1. This hook runs **only for scenarios tagged with `@smoke`**
2. `order = 2` means it runs **after order 1**

Method:

```java
public void smokeSetup() {
    System.out.println("Smoke setup");
}
```

Example usage:

* Setup smoke test environment
* Load smoke specific test data

---

# 2️⃣ Feature File Example

```
Feature: Login functionality

@smoke
Scenario: Login with valid credentials
Given user open login page
When user enter username
And user enter password
Then user should login successfully
```

---

# 3️⃣ Execution Flow

Since scenario has `@smoke` tag:

Execution will be:

```
Global setup
Smoke setup
Scenario steps
```

Step-by-step:

1️⃣ `@Before(order = 1)` → Runs first

```
Global setup
```

2️⃣ `@Before(value = "@smoke", order = 2)` → Runs second

```
Smoke setup
```

3️⃣ Scenario Steps execute

```
Given user open login page
When user enter username
Then user click login button
```

---

# 4️⃣ Feature File With Multiple Scenarios

Example:

```
Feature: Login functionality

@smoke
Scenario: Login with valid credentials
Given user open login page
When user enter username
Then user click login button

@regression
Scenario: Login with invalid password
Given user open login page
When user enter wrong password
Then error message should display

Scenario: Forgot password
Given user open login page
When user click forgot password
Then reset password page should open
```

---

# 5️⃣ Execution Behavior

| Scenario                     | Hooks Executed |
| ---------------------------- | -------------- |
| Login with valid credentials | Global + Smoke |
| Login with invalid password  | Only Global    |
| Forgot password              | Only Global    |

---

# 6️⃣ Console Output

Execution order:

```
Scenario 1
Global setup
Smoke setup
Scenario steps

Scenario 2
Global setup
Scenario steps

Scenario 3
Global setup
Scenario steps
```

---

# 7️⃣ Important Cucumber Hook Rules

1️⃣ `@Before` → runs **before scenario**

2️⃣ `@After` → runs **after scenario**

3️⃣ `order` → controls **execution sequence**

4️⃣ `value="@tag"` → hook runs **only for tagged scenarios**

---

# 8️⃣ Real Selenium Example

```java
@Before(order = 1)
public void setupDriver() {
    driver = new ChromeDriver();
}

@Before(value="@smoke", order=2)
public void maximizeBrowser() {
    driver.manage().window().maximize();
}
```

Execution for smoke test:

```
Driver setup
Browser maximize
Scenario steps
```

---

✅ Since you are **teaching Selenium + Cucumber candidates**, I can also show a **perfect interview explanation of Hooks + Before + After + Background with real framework example**.

---

👉 Rule:
Before → ascending order

---

------------------------------------------------------------
# ✅ Parallel + Tags (with clear output)
------------------------------------------------------------

## Enable parallel

### Runner

```java
@Override
@DataProvider(parallel = true)
public Object[][] scenarios() {
    return super.scenarios();
}
```

OR

### pom.xml

```xml
<parallel>methods</parallel>
<threadCount>3</threadCount>
```

---

## Feature

```gherkin
@smoke Scenario: A
@smoke Scenario: B
@smoke Scenario: C
```

---

## Runner

```java
tags="@smoke"
```

---

## ✅ Execution (parallel)

```
Thread-1 → Scenario A
Thread-2 → Scenario B
Thread-3 → Scenario C
```

⚠ Order NOT guaranteed

Sometimes:

```
C → A → B
```
or any order

---

------------------------------------------------------------
# ✅ Parallel + Hook Execution Example
------------------------------------------------------------

## Hook

```java
@Before
public void before() {
    System.out.println(Thread.currentThread().getName());
}
```

---

## Output

```
Thread-1
Thread-2
Thread-3
```

👉 Shows scenarios running simultaneously

---

------------------------------------------------------------
# ✅ Multiple Runner Strategy (with calling examples)
------------------------------------------------------------

## SmokeRunner

```java
package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

    features = "src/test/resources/features",   // path of feature files
    
    glue = {"stepDefinitions", "hooks"},        // step definition & hook package
    
    plugin = {
            "pretty",
            "html:target/cucumber-reports/cucumber.html",
            "json:target/cucumber-reports/cucumber.json",
            "junit:target/cucumber-reports/cucumber.xml"
    },
    
    tags = "@smoke",                            // run only smoke tests
    
    monochrome = true,                          // cleaner console output
    
    dryRun = false                              // true = check step mapping only
)

public class SmokeRunner {

}
```

Run:

```
mvn test -Dtest=SmokeRunner
```

Runs → only smoke tests

---

## RegressionRunner

```java
package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

    features = "src/test/resources/features",
    
    glue = {"stepDefinitions", "hooks"},
    
    plugin = {
            "pretty",
            "html:target/cucumber-reports/cucumber.html",
            "json:target/cucumber-reports/cucumber.json"
    },
    
    tags = "@regression",
    
    monochrome = true,
    
    dryRun = false
)

public class RegressionRunner {

}
```

Runs → only regression tests

---

## FullSuiteRunner

```java
@CucumberOptions(tags="not @wip")
public class FullSuiteRunner {}
```

Runs → everything except work-in-progress

---

## Benefits

✔ Separate execution  
✔ Faster CI  
✔ Easy debugging  
✔ No manual tag change  

---

------------------------------------------------------------
# ✅ Full Execution Timeline Example
------------------------------------------------------------

## Hooks

```java
@Before(order = 1)  globalSetup
@Before(order = 2)  smokeSetup
@After(order = 2)   smokeCleanup
@After(order = 1)   globalCleanup
```

## Scenario

```gherkin
@smoke
Scenario: Test
```

---

## ✅ Actual Flow

```
globalSetup
smokeSetup
Scenario steps
smokeCleanup
globalCleanup
```

---

👉 After hooks run in reverse order

---

------------------------------------------------------------
# ✅ Interview Q&A Section (Very Common)
------------------------------------------------------------

### Q1. Do tags run features or scenarios?
👉 Scenarios only

---

### Q2. Does feature tag apply to scenarios?
👉 Yes (inherited)

---

### Q3. Does parallel maintain order?
👉 No

---

### Q4. Can hooks use tags?
👉 Yes

```java
@Before("@smoke")
```

---

### Q5. Order of hooks?
👉 Before → ascending  
👉 After → descending

---

### Q6. Best practice with parallel?
👉 ThreadLocal, no shared state

---

------------------------------------------------------------
# ✅ Memory Trick
------------------------------------------------------------

👉 Tags filter scenarios  
👉 Hooks respect tags  
👉 Parallel breaks order  
👉 Before ↑ After ↓
