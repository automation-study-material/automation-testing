# 📘 TestNG Dependency Guide — dependsOnMethods vs dependsOnGroups

---

# 🔹 Overview

TestNG provides **two main dependency mechanisms**:

- dependsOnMethods → method level dependency
- dependsOnGroups → group level dependency

They look similar but behave VERY differently internally.

Understanding this is critical for **framework design + interviews + stable automation**.

---

# 🔵 dependsOnMethods

## ✅ Concept
Creates **hard dependency between methods**.
Child runs ONLY if parent PASSES.

method → method

---

## ✅ Example (Same Class)

```java
public class OrderTest {

    @Test
    public void login() {}

    @Test(dependsOnMethods = "login")
    public void placeOrder() {}
}
```

---

## Behavior

If parent fails → dependent is SKIPPED

---

## ❌ Limitation

Does NOT work across classes.

Reason:
TestNG searches only inside SAME class when resolving dependsOnMethods.

---

## Use when
Small flows inside the same class only.

---

---

# 🔵 dependsOnGroups

## ✅ Concept
Creates dependency on GROUPS, not methods.
Child runs only after ALL tests in group pass.

method → group

---

## ⭐ Important Rule

👉 **Dependent runs only after ALL group tests finish**

---

## Why it works across classes?

TestNG builds a global group map internally:

GroupName → List of all methods in that group

So it can resolve dependencies across any class.

---

## ✅ Cross-Class Example

LoginTest

```java
@Test(groups = "cleanup")
public void cleanup() {}
```

OrderTest

```java
@Test(dependsOnGroups = "cleanup")
public void placeOrder() {}
```

Execution:
cleanup → placeOrder

---

## Multiple methods in group

All must pass before dependent runs.

---

## Failure behavior

Any failure in group → dependent skipped.

---

---

# 🔵 Internal Working (Simplified)

1. Parse testng.xml
2. Scan classes using reflection
3. Collect annotations
4. Build dependency graph (DAG)
5. Topological sort
6. Execute

---

# 🔵 Comparison Table

| Feature | dependsOnMethods | dependsOnGroups |
|---------|------------------|-----------------|
Scope | method | group |
Cross-class | ❌ | ✅ |
Target | single method | many methods |
Recommended | limited | ✅ best |

---

# 🔵 Best Practices

Avoid heavy test-to-test dependencies.
Prefer:
- independent tests
- setup/cleanup in Before/After methods
- groups for logical flows

---

# 🔵 Interview Lines

dependsOnMethods works only within same class.
dependsOnGroups works globally across classes.
For cross-class dependency always prefer dependsOnGroups.

---

Happy Learning 🚀
