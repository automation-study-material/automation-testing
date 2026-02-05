
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
👉 Before ↑ order  
👉 After ↓ order  
