
# Cucumber Tag Inheritance + Hooks Execution (Crystal Clear Guide)

---

# 🔥 The Core Concept (MOST IMPORTANT)

## 👉 Feature tags are inherited by ALL scenarios

This is the key you’re missing.

---

# ✅ Your Feature

```gherkin
@smoke @login
Feature: Login functionality
```

### This means:

👉 EVERY scenario inside automatically gets:

```
@smoke
@login
```

---

# ✅ Your Scenario

```gherkin
@positive
Scenario Outline: Valid login
```

---

# ✅ Cucumber internally merges tags

### What you wrote:
```
@positive
```

### What Cucumber sees internally:
```
@smoke @login @positive
```

👉 Feature tags + Scenario tags = Combined tags

---

# ✅ Step-by-step what happens

## Runner

```java
tags = "@positive"
```

---

## Step 1 → Filter scenarios

Cucumber checks:

```
Which scenarios contain @positive?
```

Your scenario contains:

```
@smoke @login @positive
```

### Result:
```
✅ Scenario selected
```

---

## Step 2 → Hooks execution

Now Cucumber checks which hooks apply.

---

### Hook 1

```java
@Before(order=1)
```

No tag → runs always

```
✅ runs
```

---

### Hook 2

```java
@Before("@smoke", order=2)
```

Scenario has @smoke (inherited)

```
✅ runs
```

---

# ✅ Final execution order

(Remember: Before hooks run in ascending order)

```
Before Hook - Before Scenario Order-1
Before Hook - Smoke setup order-2
Background steps
Scenario steps
```

---

# 🔥 Visual Diagram (Very Clear)

## Your Feature

```
Feature tags:  @smoke @login
Scenario tags: @positive
```

## Combined internally

```
@smoke @login @positive
```

---

# Hook check table

| Hook | Condition | Result |
|------|-----------|---------|
| before() | no tag | ✅ |
| smokeOnly() | @smoke | ✅ |

---

# ✅ Proof Trick (Try this)

Remove @smoke from feature:

```gherkin
Feature: Login functionality
```

Now scenario only has:

```
@positive
```

Run again.

👉 smoke hook will NOT run.

---

# ✅ Final Rule (Memorize this)

## Runner tags
👉 filter scenarios

## Feature tags
👉 inherited by scenarios

## Hook tags
👉 match against final scenario tags

---

# ✅ Interview One-liner

👉  
**Feature tags are inherited by all scenarios. So even if we run @positive, the scenario still has @smoke, causing @Before("@smoke") hooks to execute.**

---

# ✅ Memory Trick

👉 Runner filters scenarios  
👉 Feature tags auto-attach  
👉 Hooks self-filter  
👉 Before ↑ order  (ascending order)
👉 After ↓ order  (descending order)

# Code

## Feature File

```feature
@smoke @login
Feature: Login functionality

  Background:
    Given application is launched

  @datatable
  Scenario: Create multiple users using DataTable
    When I create users
      | name  | role |company|
      | Ram   | admin|Adobe|
      | Shyam | user |Global Logic|
    Then users should be created
```
## Hooks
```java

package hooks;

import io.cucumber.java.*;

public class Hooks {

    @Before (order = 1) 
    public void before() {
        System.out.println("Before Hook - Before Scenario Order-1");
    }

    @Before(value="@smoke",order=2) 
    public void smokeOnly() {
        System.out.println("Before Hook - Smoke setup order-2");
    }
    
    @Before(value="@sanity",order=3)
    public void sanityOnely() {
        System.out.println("Before Hook - Smoke setup order-3");
    }
    
    @After (value="@sanity",order=3)
    public void afterOrderThree() {
        System.out.println("After Scenario order-3");
    }
    
    @After (order=1)
    public void afterOrderone() {
        System.out.println("After Scenario order-1");
    }
    
    @After(value = "@sanity or @datatable", order = 2)
    public void afterOrderTwo() {
        System.out.println("After Scenario order-2");
    }
}
```

## Runner Class
```java

package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps","hooks"},
        plugin = {
        		"pretty",      // step-by-step readable
                "summary",     // final summary
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "rerun:target/failed.txt"
                },
        tags = "@datatable",
        monochrome = true 
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
```

### Note:
- When we call tags from Runner class, Runner class will check for what features have tag same as passed in runner class.
- Example in runner class there is `@datatable`tag, It can see in feature file where tag matches in out feature file it matches to `Create multiple users using DataTable` scenario.
- This scenario hold already some tag which defined at feature level. these are `@smoke @login & @datatable` Now It looks for hooks which matches to this tag and trigger hooks.
