
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

```java
@Before(order = 1)
public void global(){}

@Before("@smoke", order = 2)
public void smoke(){}
```

## Feature

```gherkin
@smoke Scenario A
Scenario B
@smoke Scenario C
```

## Execution (parallel)

```
Thread-1 → GLOBAL → SMOKE → A
Thread-2 → GLOBAL → B
Thread-3 → GLOBAL → SMOKE → C
```

Only smoke scenarios trigger smoke hook

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
