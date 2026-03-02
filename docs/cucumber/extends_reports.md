Excellent question 👍
This is where many people get confused.

In **Cucumber BDD + Extent Adapter**, you usually **do NOT manually create ExtentTest logs** like normal TestNG projects.

Because 👉 **Cucumber Adapter automatically captures:**

* Feature
* Scenario
* Steps
* Status (Pass/Fail/Skip)
* Tags
* Screenshots (if attached via `Scenario.attach()`)

---

# 🎯 Important Concept

There are 2 ways to use Extent:

1️⃣ **Without Cucumber Adapter (Manual logging)**
2️⃣ **With Cucumber Adapter (Recommended for BDD)**

Since you're using BDD → Use Adapter approach.

---

# ✅ How Logging Works in Cucumber + Extent Adapter

You DO NOT write:

```java
ExtentReports extent = new ExtentReports();
ExtentTest test = extent.createTest("Test");
test.pass("Step Passed");
```

❌ That is for TestNG only.

---

# ✅ Instead — Logging Happens Automatically

Your Step:

```java
@When("User enters {string} and {string}")
public void user_enters_credentials(String username, String password) {

    driver.findElement(By.id("user")).sendKeys(username);
    driver.findElement(By.id("pass")).sendKeys(password);
}
```

If step passes → Extent marks it GREEN
If assertion fails → Extent marks it RED

No extra logging required.

---

# ✅ Where You Actually Add Extent Configuration

### 1️⃣ In Runner

```java
plugin = {
    "pretty",
    "json:target/cucumber.json",
    "tech.grasshopper.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
```

---

### 2️⃣ In extent.properties

```
src/test/resources/extent.properties
```

```properties
extent.reporter.spark.start=true
extent.reporter.spark.out=target/ExtentReport.html
```

---

# ✅ How To Add Custom Logs Inside Steps

If you want to log extra details (optional):

```java
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

@When("User enters credentials")
public void user_enters_credentials() {

    ExtentCucumberAdapter.addTestStepLog("Entering username and password");

    driver.findElement(By.id("user")).sendKeys("admin");
}
```

✔ This will appear as additional log line in report.

---

# ✅ How To Attach Screenshot (Most Important)

Inside Hooks:

```java
@After
public void tearDown(Scenario scenario) {

    if (scenario.isFailed()) {

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", "Failure Screenshot");
    }

    driver.quit();
}
```

✔ Screenshot automatically appears in Extent report.

---

# 🏆 Clean Enterprise Structure

```
src/test/java
   ├── runner
   ├── stepdefinitions
   ├── hooks
src/test/resources
   ├── features
   ├── extent.properties
   ├── spark-config.xml
```

---

# 🔥 Advanced: If You Want Manual Extent Control

If you don’t use adapter, then:

* Create ExtentManager class
* Use ThreadLocal
* Use TestNG Listener
* Manually create tests & flush reports

But for BDD → Adapter is best.

---

# 🎯 Interview-Level Answer

> In Cucumber BDD with Extent Adapter, we do not manually create ExtentTest instances. Logging is automatically handled based on step execution status. Custom logs can be added using ExtentCucumberAdapter.addTestStepLog(), and screenshots can be attached using Scenario.attach() inside hooks.

---

# 🚀 Senior Tip

Never mix:

* Manual ExtentReports
* Extent Cucumber Adapter

Choose one approach.

---
