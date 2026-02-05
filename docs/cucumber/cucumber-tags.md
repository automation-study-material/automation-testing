
# Cucumber Tags + Hooks + Parallel – Crystal Clear Guide (with Execution Order & Output)

This guide explains everything with **small feature examples + exact execution output** so you can visually understand behavior.

---

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

---

## Feature

```gherkin
@smoke
Scenario: Login
```

---

## ✅ Actual Execution

```
Global setup
Smoke setup
Scenario steps
```

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
@CucumberOptions(tags="@smoke")
public class SmokeRunner {}
```

Run:

```
mvn test -Dtest=SmokeRunner
```

Runs → only smoke tests

---

## RegressionRunner

```java
@CucumberOptions(tags="@regression")
public class RegressionRunner {}
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
