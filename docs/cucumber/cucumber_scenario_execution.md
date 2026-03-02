# 🚀 Cucumber Scenario Execution + Maven CLI Cheat Sheet

### (Java + TestNG + Cucumber Framework)

This guide combines:

-   Running specific scenarios
-   Tag-based execution
-   Scenario Outline behavior
-   Maven CLI commands
-   Reporting commands
-   Senior-level best practices

------------------------------------------------------------------------

# 📌 Golden Rule (Very Important)

If you are using **TestNG + Cucumber together**, ALWAYS include:

``` bash
-Dtest=runner.CucumberRunner
```

Otherwise Maven may execute: - ❌ All TestNG @Test methods - ❌ All
feature files

------------------------------------------------------------------------

# ✅ How To Run Specific Scenario

------------------------------------------------------------------------

## 1️⃣ Run Using Tags (Most Recommended)

### Feature Example

``` gherkin
Feature: Login Feature

@Smoke
Scenario: Valid Login
  Given User is on login page
  When User enters "admin" and "admin123"
  Then Login should be "success"

@Regression
Scenario: Invalid Login
  Given User is on login page
  When User enters "admin" and "wrong123"
  Then Login should be "failure"
```

### Runner Class Example

``` java
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepdefinitions",
    tags = "@Smoke"
)
```

✔ Clean
✔ Scalable
✔ CI/CD Friendly

------------------------------------------------------------------------

## 2️⃣ Run Scenario by Name

``` java
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepdefinitions",
    name = "Valid Login"
)
```

⚠ Not preferred in large frameworks

------------------------------------------------------------------------

## 3️⃣ Run Scenario by Line Number

``` java
@CucumberOptions(
    features = "src/test/resources/features/Login.feature:10",
    glue = "stepdefinitions"
)
```

✔ Useful for debugging

------------------------------------------------------------------------

## 4️⃣ Run from Maven Command Line

### Using Tag

``` bash
mvn test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="@Smoke"
```

### Using Scenario Name

``` bash
mvn test -Dtest=runner.CucumberRunner -Dcucumber.filter.name="Valid Login"
```

------------------------------------------------------------------------

## 5️⃣ Run from IDE

-   Right click on scenario
-   Click Run

------------------------------------------------------------------------

# 🎯 Scenario Outline Execution Behavior

If you tag Scenario Outline:

``` gherkin
@Smoke
Scenario Outline: Login test
```

👉 All example rows execute.

If you want to run only one row:

``` gherkin
Scenario Outline: Login test

  @Row1
  Examples:
    | username | password | status |
    | admin    | admin123 | success |
```

Then use:

``` java
tags = "@Row1"
```

------------------------------------------------------------------------

# 🚀 Cucumber + Maven CLI Cheat Sheet

------------------------------------------------------------------------

## Run all cucumber tests

``` bash
mvn clean test -Dtest=runner.CucumberRunner
```

------------------------------------------------------------------------

## Run single feature file

``` bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.features=src/test/resources/features/login.feature
```

------------------------------------------------------------------------

## Run multiple feature files

``` bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.features=login.feature,order.feature
```

------------------------------------------------------------------------

## Run feature folder

``` bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.features=src/test/resources/features/auth
```

------------------------------------------------------------------------

## Run specific scenario (line number)

``` bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.features=login.feature:25
```

------------------------------------------------------------------------

# ✅ Tag Based Execution

## Run only @smoke

``` bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="@smoke"
```

------------------------------------------------------------------------

## Run only @regression

``` bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="@regression"
```

------------------------------------------------------------------------

## Run BOTH tags (AND)

``` bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="@smoke and @regression"
```

------------------------------------------------------------------------

## Run either tag (OR)

``` bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="@smoke or @regression"
```

------------------------------------------------------------------------

## Exclude tag (NOT)

``` bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="not @slow"
```

------------------------------------------------------------------------

## Complex expression

``` bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="(@smoke or @sanity) and not @slow"
```

------------------------------------------------------------------------

# 📊 Reporting Configuration

Add in Runner:

``` java
@CucumberOptions(
    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber.json"
    }
)
```

Then run:

``` bash
mvn clean test -Dtest=runner.CucumberRunner
```

Reports generated inside:

target/

------------------------------------------------------------------------

# 🧠 Senior-Level Best Practices

✔ Always use Tags for execution control
✔ Use tag combinations for CI pipelines
✔ Keep Smoke suite small
✔ Separate Smoke / Regression / Sanity
✔ Avoid running by scenario name in CI
✔ Use line number only for debugging

------------------------------------------------------------------------

# 🏆 Interview-Level Final Answer

We can run a specific Cucumber scenario using tags, scenario name, line
number, or Maven command-line filters. Tags are the most recommended and
scalable approach, especially for CI/CD and enterprise-level automation
frameworks.

------------------------------------------------------------------------

# 🔥 Quick Revision Summary

-   🎯 Debug → Use line number
-   🚀 CI/CD → Use tags
-   🧪 Local quick run → Right-click in IDE
-   📦 TestNG + Cucumber → Always add -Dtest=runner.CucumberRunner
-   🏢 Enterprise → Maintain proper tag strategy
