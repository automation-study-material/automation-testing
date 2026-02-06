# 📘 Extent Reports with TestNG — Complete Guide (From Scratch)

---

# 🔷 1️⃣ Concept — What is Extent Report?

Extent Reports is a rich HTML reporting library used with TestNG/Selenium that:

- Captures test execution
- Shows pass/fail/skip
- Attaches screenshots
- Displays charts & dashboards
- Works with CI/CD

Default TestNG reports are basic and lack screenshots and visualization, so Extent is preferred in industry.

---

# 🔷 2️⃣ Types of Reporters

| Reporter | Output | Use |
|-----------|------------|-----------|
| SparkReporter | HTML | Most common |
| AventReporter | JSON | CI integration |
| KlovReporter | MongoDB | Live dashboards |
| EmailReporter | Email | Notifications |

👉 Spark Reporter is used most frequently.

---

# 🔷 3️⃣ Core Classes

## ExtentReports (Engine)
- attachReporter()
- createTest()
- flush()

## ExtentTest (Single test entry)
- pass()
- fail()
- skip()
- info()
- addScreenCaptureFromPath()

## ExtentSparkReporter (UI)
- setTheme()
- setReportName()
- setDocumentTitle()

---

# 🔷 4️⃣ Step‑by‑Step Setup

## Dependency (pom.xml)

```xml
<dependency>
   <groupId>com.aventstack</groupId>
   <artifactId>extentreports</artifactId>
   <version>5.1.1</version>
</dependency>
```

---

## ExtentManager

```java
public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance(){

        if(extent == null){

            ExtentSparkReporter spark =
                new ExtentSparkReporter("target/extent-report.html");

            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Regression Suite");
            spark.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}
```

---

## Screenshot Utility

```java
public static String capture(String name) throws Exception {

    File src = ((TakesScreenshot)DriverFactory.getDriver())
            .getScreenshotAs(OutputType.FILE);

    new File("target/screenshots").mkdirs();

    String path = "target/screenshots/" + name + ".png";
    FileUtils.copyFile(src, new File(path));

    return "screenshots/" + name + ".png";
}
```

---

## Listener Integration

```java
public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onTestStart(ITestResult result){
        test.set(extent.createTest(result.getName()));
    }

    public void onTestSuccess(ITestResult result){
        test.get().pass("Passed");
    }

    public void onTestFailure(ITestResult result){
        String path = ScreenshotUtil.capture(result.getName());
        test.get().fail(result.getThrowable())
            .addScreenCaptureFromPath(path);
    }

    public void onTestSkipped(ITestResult result){
        test.get().skip("Skipped");
    }

    public void onFinish(ITestContext context){
        extent.flush();
    }
}
```

---

## Register Listener

### testng.xml

```xml
<listeners>
   <listener class-name="listeners.TestListener"/>
</listeners>
```

or

```java
@Listeners(TestListener.class)
```

---

## Sample Tests

```java
@Test public void loginPass(){}
@Test public void loginFail(){ Assert.fail(); }
@Test public void loginSkip(){ throw new SkipException("Skip"); }
@Test public void loginInfo(){ Assert.assertTrue(true); }
```

---

# 🔷 5️⃣ Execution Flow

Test Start → Listener → createTest → capture logs/screenshots → flush → HTML generated

---

# 🔷 6️⃣ Output

```
target/
   extent-report.html
   screenshots/
```

---

# 🔷 7️⃣ Interview Quick Lines

- flush() writes report to disk
- ThreadLocal makes parallel safe
- Spark generates HTML
- Listener integrates TestNG with Extent

---

Happy Automation 🚀
