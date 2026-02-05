
# Cucumber dryRun vs strict – Complete Cheat Sheet + Lifecycle Guide

This document covers:

✅ dryRun vs strict (clear comparison)  
✅ pending vs undefined vs skipped differences  
✅ full execution lifecycle diagram  
✅ interview-ready notes  

---

# ✅ dryRun vs strict – Quick Cheat Sheet

## Core Idea

- dryRun → validation only
- strict → execution + fail on problems

---

## Comparison Table

| Feature | dryRun | strict |
|-----------|-------------|-------------|
| Executes steps | ❌ No | ✅ Yes |
| Executes hooks | ❌ No | ✅ Yes |
| Validates step mapping | ✅ Yes | ✅ Yes |
| Generates snippets | ✅ Yes | ❌ No |
| Fails build for missing steps | ❌ No | ✅ Yes |
| Speed | ⚡ Very fast | 🐢 Normal |
| Use case | Development | CI/CD |

---

## Example

### Runner (dry run)

```java
@CucumberOptions(dryRun = true)
```

Output:
```
Undefined step found
Snippet generated
Execution stopped
```

---

### Runner (strict / default behavior)

```java
@CucumberOptions(dryRun = false)
```

Output:
```
Hooks executed
Steps executed
Build FAILED if step missing
```

---

# ✅ Important Note (Cucumber 7+)

strict mode is ENABLED by default.

So:

❌ strict = true (not needed anymore)  
✅ only control dryRun  

---

------------------------------------------------------------
# ✅ pending vs undefined vs skipped – Differences
------------------------------------------------------------

## 1️⃣ Undefined

Meaning → Step not implemented at all  
Result → Snippet generated  
Status → FAIL

---

## 2️⃣ Pending

Meaning → Step exists but not completed  

```java
throw new PendingException();
```

Status → FAIL

---

## 3️⃣ Skipped

Meaning → Previous step failed so remaining skipped  
Status → SKIPPED

---

## Comparison Table

| Type | Cause | Executes? | Result |
|----------|------------|-----------|-----------|
| Undefined | No step def | No | Fail |
| Pending | Incomplete step | Stops | Fail |
| Skipped | Earlier failure | No | Skipped |

---

------------------------------------------------------------
# ✅ Execution Lifecycle Diagram
------------------------------------------------------------

## Normal Execution

```
Runner
  ↓
Before hooks
  ↓
Background
  ↓
Scenario steps
  ↓
After hooks
  ↓
Report
```

---

## dryRun Mode

```
Runner
  ↓
Parse features
  ↓
Match steps
  ↓
STOP
```

---

## Failure Flow

```
Before
Step PASS
Step FAIL
Remaining steps SKIPPED
After hooks still run
```

---

------------------------------------------------------------
# ✅ Interview Quick Answers
------------------------------------------------------------

Q: dryRun purpose?
👉 Validate only

Q: strict purpose?
👉 Fail build on issues

Q: Hooks executed in dryRun?
👉 No

Q: Hooks executed normally?
👉 Yes

---

------------------------------------------------------------
# ✅ Memory Trick
------------------------------------------------------------

dryRun → Check only  
strict → Run + fail  
Undefined → missing  
Pending → incomplete  
Skipped → blocked  
Hooks → always run After  
