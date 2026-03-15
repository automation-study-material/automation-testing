**Step Definition Ambiguity** in Cucumber means that **one step written in the feature file matches more than one step definition method in the code**, so Cucumber becomes **confused about which method to execute**.

---

# 1️⃣ Definition

**Step Definition Ambiguity occurs when multiple step definitions match the same step in a feature file.**

Because of this, Cucumber throws an **Ambiguous Step Definitions error**.

---

# 2️⃣ Example of Ambiguity

### Feature File

```gherkin
Scenario: Login test
Given user enters username
```

---

### Step Definition 1

```java
@Given("user enters username")
public void enterUsername() {
    System.out.println("Enter username");
}
```

---

### Step Definition 2

```java
@Given("user enters (.*)")
public void enterValue(String value) {
    System.out.println("Enter value");
}
```

---

### Problem

The step:

```
Given user enters username
```

matches **both step definitions**.

So Cucumber cannot decide which method to run.

---

### Error Example

```text
AmbiguousStepDefinitionsException:
Multiple step definitions match:
```

---

# 3️⃣ How to Fix Step Ambiguity

### Method 1 — Make Step Definitions More Specific

❌ Ambiguous

```java
@Given("user enters (.*)")
```

✔ Correct

```java
@Given("user enters username")
```

---

### Method 2 — Use Better Regex

```java
@Given("user enters username (.*)")
```

---

### Method 3 — Avoid Duplicate Steps

Remove duplicate or overlapping step definitions.

---

# 4️⃣ Best Practice

Steps should be **unique and clearly defined**.

Example:

```java
@Given("user enters valid username")
```

instead of

```java
@Given("user enters (.*)")
```

---

# 5️⃣ Interview Answer (Short)

**Step Definition Ambiguity occurs when a single step in a Cucumber feature file matches multiple step definition methods. This creates confusion for Cucumber about which method to execute, resulting in an Ambiguous Step Definition error. This issue can be resolved by making step definitions more specific and avoiding overlapping patterns.**

---


