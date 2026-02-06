# 🚀 Cucumber + Maven CLI Cheat Sheet

### (Java + TestNG + Cucumber Framework)

---

# 📌 Golden Rule (Important for your project)

Since you have **TestNG + Cucumber together**, ALWAYS include:

```bash
-Dtest=runner.CucumberRunner
```

Otherwise Maven runs:
❌ all TestNG @Test
❌ all features

---

---

# ✅ Basic Commands

## Run all cucumber tests

```bash
mvn clean test -Dtest=runner.CucumberRunner
```

---

## Run single feature file

```bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.features=src/test/resources/features/login.feature
```

---

## Run multiple feature files

```bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.features=login.feature,order.feature
```

---

## Run feature folder

```bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.features=src/test/resources/features/auth
```

---

## Run specific scenario (line number)

```bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.features=login.feature:25
```

---

---

# ✅ Tag Based Execution

## Run only @smoke

```bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="@smoke"
```

---

## Run only @regression

```bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="@regression"
```

---

## Run BOTH tags (AND)

```bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="@smoke and @regression"
```

---

## Run either tag (OR)

```bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="@smoke or @regression"
```

---

## Exclude tag (NOT)

```bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="not @slow"
```

---

## Complex expressions

```bash
mvn clean test -Dtest=runner.CucumberRunner -Dcucumber.filter.tags="(@smoke or @sanity) and not @slow"
```

---

---

# ✅ Reports

## Pretty console + HTML

```bash
mvn clea
```
