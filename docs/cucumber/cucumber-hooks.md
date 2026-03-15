
# Cucumber Hooks – Execution Table + Parallel Behavior Guide

This guide explains:

✅ Hook execution with different tag combinations (table format)  
✅ Hook behavior in parallel execution  
✅ Clear examples + outputs  

---

# ✅ Sample Hooks Used

```java
@Before(order = 1)
public void global() {
    System.out.println("GLOBAL");
}

@Before(value = "@smoke", order = 2)
public void smoke() {
    System.out.println("SMOKE");
}

@Before(value = "@sanity", order = 3)
public void sanity() {
    System.out.println("SANITY");
}
```

---

# ✅ Rule Reminder

Before hooks:
👉 Ascending order

After hooks:
👉 Descending order

Hooks without tag:
👉 Run for ALL scenarios

---

------------------------------------------------------------
# ✅ Hook Execution Table (Very Important)
------------------------------------------------------------

## Feature

```gherkin
@smoke @positive
Scenario: A

@sanity
Scenario: B

@positive
Scenario: C
```

---

## Execution Matrix

| Scenario | Tags | Hooks Executed | Order |
|----------|-----------|-----------------------|----------------|
| A | @smoke @positive | global + smoke | GLOBAL → SMOKE |
| B | @sanity | global + sanity | GLOBAL → SANITY |
| C | @positive | global only | GLOBAL |
| D | no tag | global only | GLOBAL |

---

## Console Output Examples




### Scenario A

```
GLOBAL
SMOKE
Scenario steps
```

### Scenario B

```
GLOBAL
SANITY
Scenario steps
```

### Scenario C

```
GLOBAL
Scenario steps
```

---

------------------------------------------------------------
# ✅ Hook + Parallel Behavior (CRITICAL)
------------------------------------------------------------

Enable parallel:

```java
@DataProvider(parallel = true)
```

OR

```xml
<parallel>methods</parallel>
<threadCount>3</threadCount>
```

---

## Example Feature

```gherkin
Scenario: A
Scenario: B
Scenario: C
```

---

## Hook

```java
@Before
public void before() {
    System.out.println(Thread.currentThread().getName());
}
```

---

## Execution (parallel)

```
Thread-1
Thread-2
Thread-3
```

👉 Hooks run independently for each scenario

---

------------------------------------------------------------
# ✅ Combined Example (Tags + Hooks + Parallel)
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

------------------------------------------------------------
# ✅ Interview Quick Answers
------------------------------------------------------------

Q: Do hooks run for every scenario?
👉 Only hooks without tag

Q: Does parallel maintain order?
👉 No

Q: Do hooks run per thread?
👉 Yes

---

# ✅ Memory Trick

👉 Runner filters scenarios  
👉 Hooks filter themselves  
👉 Before ↑  
👉 After ↓  
👉 Parallel = random order across scenarios  

## Hooks without tag always executed.
