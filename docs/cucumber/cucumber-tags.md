
# Cucumber Tags – Complete Practical Guide (Beginner → Advanced)

---

# ✅ Golden Rule (remember forever)

## Cucumber filters **SCENARIOS**, not feature files

Even if tag is on **Feature → it gets copied to all scenarios automatically**.

---

# 🟢 Example 1 — Tag at Feature level

```gherkin
@smoke
Feature: Login

  Scenario: Valid login
  Scenario: Invalid login
  Scenario: Forgot password
```

Runner:

```java
tags = "@smoke"
```

Internally:

```
@smoke Valid login
@smoke Invalid login
@smoke Forgot password
```

✅ All run

---

# 🟢 Example 2 — Tag at Scenario level

```gherkin
Feature: Login

  @smoke
  Scenario: Valid login

  Scenario: Invalid login
```

Runner:

```java
tags = "@smoke"
```

Execution:

```
✔ Valid login
❌ Invalid login
```

---

# 🟢 Example 3 — Mixed

```gherkin
@smoke
Feature: Login

  Scenario: Valid login

  @regression
  Scenario: Invalid login
```

Runner → `@regression`

```
❌ Valid login
✔ Invalid login
```

---

# 🟢 Example 4 — Multiple tag expression

Runner:

```java
tags = "@smoke and @regression"
```

Both tags must exist.

---

# 🟢 Example 5 — Scenario Outline

```gherkin
@smoke
Scenario Outline: login
Examples:
 | user |
 | A |
 | B |
```

Internally:

```
@smoke Scenario A
@smoke Scenario B
```

---

------------------------------------------------------------
# ✅ Hook + Tag Combined Examples (VERY IMPORTANT)
------------------------------------------------------------

## Hooks can also be filtered using tags

### Feature

```gherkin
@smoke
Scenario: Login test
```

### Hook

```java
@Before("@smoke")
public void smokeSetup() {
    System.out.println("Smoke setup");
}
```

Runs only for:
```
@smoke scenarios
```

---

## Multiple tag hook

```java
@Before("@smoke and not @api")
```

Meaning:
```
Run only smoke but NOT api tests
```

---

## Combined order + tag

```java
@Before(order = 1)
public void globalSetup(){}

@Before(value = "@smoke", order = 2)
public void smokeSetup(){}
```

Execution:

```
globalSetup
smokeSetup
Scenario
```

---

------------------------------------------------------------
# ✅ Parallel + Tags
------------------------------------------------------------

## Enable parallel

```java
@DataProvider(parallel = true)
```

OR

```xml
<parallel>methods</parallel>
<threadCount>4</threadCount>
```

---

## Example

Feature:

```gherkin
@smoke Scenario A
@smoke Scenario B
@smoke Scenario C
```

Runner:

```java
tags="@smoke"
```

### Execution (parallel)

```
Thread1 → A
Thread2 → B
Thread3 → C
```

⚠ Order NOT guaranteed

---

## Best Practice with parallel

✔ Avoid shared static variables  
✔ Avoid scenario dependency  
✔ Use ThreadLocal driver  
✔ Use independent test data  

---

------------------------------------------------------------
# ✅ Multiple Runner Strategy (Industry Standard)
------------------------------------------------------------

## SmokeRunner

```java
@CucumberOptions(tags="@smoke")
public class SmokeRunner {}
```

## RegressionRunner

```java
@CucumberOptions(tags="@regression")
public class RegressionRunner {}
```

## FullSuiteRunner

```java
@CucumberOptions(tags="not @wip")
public class FullSuiteRunner {}
```

Benefits:

✔ Separate pipelines  
✔ Faster execution  
✔ Easy CI integration  
✔ Clean control  

---

------------------------------------------------------------
# ✅ Interview Q&A Section
------------------------------------------------------------

### Q1. Do tags work at feature level or scenario level?
👉 Scenario level. Feature tags are inherited.

---

### Q2. Can we run multiple tags?
👉 Yes

```
@smoke and @regression
@smoke or @api
not @slow
```

---

### Q3. What happens if no tag is provided?
👉 All scenarios run

---

### Q4. Do tags affect execution order?
👉 No, only filtering

---

### Q5. Can hooks use tags?
👉 Yes

```java
@Before("@smoke")
```

---

### Q6. Does parallel maintain order?
👉 No, order becomes random

---

### Q7. Best tagging strategy?
👉
Feature → module  
Scenario → test type  

---

------------------------------------------------------------
# ✅ 1-Line Memory Trick
------------------------------------------------------------

👉 **Tags filter scenarios only. Feature tags are automatically inherited. Hooks can also use tags. Parallel removes order guarantee.**
