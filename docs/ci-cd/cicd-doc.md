# 🚀 CI/CD for Automation Testing

## Java + Selenium + TestNG + Cucumber + Jenkins + Kubernetes

---

# 📌 Goal of CI/CD in Automation

### In one line

> Automatically run tests whenever code changes and give fast feedback.

---

Without CI/CD:

```
Manual testing → slow → late bugs → risky releases
```

With CI/CD:

```
Commit → Auto build → Auto deploy → Auto test → Report
```

---

---

# 🧠 Core Idea (Golden Rule)

```
Application builds & deploys
Automation tests validate
```

❌ Tests do NOT deploy app
✅ Tests only verify

---

---

# 🏗 Repo Strategy (Industry Standard)

Always keep **2 separate repos**

```
application-repo   → developers
automation-repo   → QA/Automation
```

---

## Responsibilities

### Application Repo

* Build jar
* Build Docker image
* Push to Artifactory
* Deploy to K8s

### Automation Repo

* Selenium tests
* Cucumber features
* Run tests
* Generate reports

---

---

# 🔁 High Level Flow (Big Picture)

```
Developer Commit
       ↓
Build App
       ↓
Docker Image
       ↓
Deploy to QA (K8s)
       ↓
Trigger Automation
       ↓
Run Tests
       ↓
Reports (Slack/Email)
```

---

---

# 🧩 Complete CI/CD Pipeline Diagram

```
                ┌──────────────┐
                │  Developer   │
                └──────┬───────┘
                       ↓
                ┌──────────────┐
                │   Build App  │
                └──────┬───────┘
                       ↓
                ┌──────────────┐
                │ Docker Image │
                └──────┬───────┘
                       ↓
                ┌──────────────┐
                │ Deploy to QA │
                └──────┬───────┘
                       ↓
                ┌──────────────┐
                │ Run Tests    │
                └──────┬───────┘
                       ↓
                ┌──────────────┐
                │ Reports      │
                └──────────────┘
```

---

---

# 🧪 Test Execution Strategy (VERY IMPORTANT)

Never run all tests always ❌

Instead split suites:

---

## ✅ Smoke Tests

Purpose → basic health
Time → 2–5 mins

Examples:

* login
* post
* logout

Run:

```
Every PR / commit
```

Command:

```
-Dcucumber.filter.tags=@smoke
```

---

## ✅ Regression Tests

Purpose → old + new features
Time → 20–40 mins

Run:

```
After deploy to QA
```

Command:

```
-Dcucumber.filter.tags=@regression
```

---

## ✅ Full Suite

Purpose → everything
Time → 1–2 hours

Run:

```
Nightly
```

Command:

```
mvn test
```

---

---

# 🕒 When Each Suite Runs

```
Commit/PR  → Smoke
Deploy QA  → Regression
Nightly    → Full
```

---

---

# 🧠 Tag Example (Cucumber)

```
@smoke
@regression
@slow
```

Example:

```gherkin
@smoke @regression
Scenario: Login user
```

---

---

# 🧰 Jenkins Pipeline Structure

We create **3 jobs**

```
automation-smoke
automation-regression
automation-full
```

---

---

# 🔹 Smoke Pipeline

Trigger:

```
Pull request
```

Command:

```
mvn clean test -Dtest=CucumberRunner -Dcucumber.filter.tags=@smoke
```

---

---

# 🔹 Regression Pipeline

Trigger:

```
After deployment success
```

Command:

```
mvn clean test -Dtest=CucumberRunner -Dcucumber.filter.tags=@regression
```

---

---

# 🔹 Nightly Pipeline

Trigger:

```
cron 2 AM
```

Command:

```
mvn clean test -Dtest=CucumberRunner
```

---

---

# 🔁 How Automation is Triggered After Deploy?

## Best method (Industry)

Application Jenkinsfile:

```groovy
stage('Deploy QA') {
   sh 'kubectl apply -f deployment.yaml'
}

stage('Trigger Automation') {
   build job: 'automation-regression'
}
```

So:

```
Deploy success → start tests
```

---

---

# 📊 Reports in Jenkins (IMPORTANT)

## Problem

Pods die → reports disappear

## Solution (recommended)

### Archive Artifacts

```groovy
archiveArtifacts artifacts: 'target/**/*'
```

### Publish HTML

```groovy
publishHTML(...)
```

### Result

```
Jenkins UI → clickable reports
```

No volumes needed.

---

---

# 🐳 Docker Usage in Automation

We use Docker for:

✔ test runner
✔ selenium grid

NOT for:

❌ deploying app

---

---

# 🧠 Sprint Planning Strategy

Example 12 sprints:

| Sprint | Work                      |
| ------ | ------------------------- |
| 1–2    | framework setup           |
| 3–10   | features + tests parallel |
| 11     | regression hardening      |
| 12     | release                   |

---

## Each Sprint Flow

```
Write scenarios
   ↓
Dev builds feature
   ↓
QA automates
   ↓
Add to regression
```

---

---

# 🧠 Best Practices

## Always

✔ separate repos
✔ tag tests
✔ run small suite frequently
✔ run full nightly
✔ generate reports
✔ trigger after deploy

## Never

❌ run all tests on every commit
❌ mix app + test repo
❌ deploy from QA repo
❌ depend on IDE

---

---

# 🎯 Commands Cheat Sheet

## Run smoke

```
mvn clean test -Dtest=CucumberRunner -Dcucumber.filter.tags=@smoke
```

## Run regression

```
mvn clean test -Dtest=CucumberRunner -Dcucumber.filter.tags=@regression
```

## Run specific feature

```
-Dcucumber.features=login.feature
```

## Run scenario

```
login.feature:25
```

## Dry run

```
-Dcucumber.execution.dry-run=true
```

---

---

# 🧠 Memory Tricks

```
App produces artifacts
Tests consume artifacts
```

```
Fast → smoke
Medium → regression
Slow → full
```

```
Deploy → then Test
```

---

---

# 🎉 Final Summary

CI/CD for automation means:

```
Code change
   ↓
Auto build
   ↓
Auto deploy
   ↓
Auto test
   ↓
Auto report
```

Fully automatic.
No manual testing required.

---

---

# ✅ You are now ready to

✔ Design enterprise pipelines
✔ Configure Jenkins
✔ Plan sprints
✔ Structure repos
✔ Implement CI/CD for automation

---

End of Guide 🚀
