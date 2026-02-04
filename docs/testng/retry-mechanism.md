# 🔁 TestNG Retry Mechanism (Test Level & Global Level)

This document explains **how to use retry mechanism in TestNG** in a **simple, interview‑friendly, and practical way**.

You will learn:

* Retry at **Test Method Level**
* Retry at **Global Level (All Tests)**
* When and why to use each approach

---

## 🧠 What is Retry Mechanism?

Retry mechanism allows **failed test cases** to run again automatically before being marked as FAILED.

Common use cases:

* Flaky Selenium tests
* Temporary network / API issues
* Unstable test environments

---

## 🧩 Core Component – RetryAnalyzer

This class contains the retry logic. It is **mandatory** for both approaches.

```java
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY = 2; // retry 2 times

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY) {
            retryCount++;
            System.out.println("Retrying test: " + result.getName() +
                    " | Retry count: " + retryCount);
            return true;
        }
        return false;
    }
}
```

📌 **Total runs = 1 initial + 2 retries = 3 executions**

---

# ✅ Approach 1: Retry at Test Method Level

### 📌 When to Use

* Only **few tests** are flaky
* You want **full control per test**
* Small test suite

---

### 🔹 How It Works

RetryAnalyzer is attached **directly to the test method** using `@Test` annotation.

---

### 🔹 Snippet Code

```java
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginTest() {
        System.out.println("Executing loginTest");
        Assert.assertTrue(false); // force failure
    }
}
```

---

### 🔄 Execution Flow

1. Test runs
2. Test fails ❌
3. RetryAnalyzer.retry() is called
4. Test retries until MAX_RETRY is reached

---

### ✅ Pros

* Very simple
* Easy to understand

### ❌ Cons

* Must add retry to **every test method**
* Not scalable for large frameworks

---

# 🌍 Approach 2: Retry at Global Level (All Tests)

### 📌 When to Use

* Large automation framework
* Many tests
* Want **centralized retry logic**

👉 **This is industry best practice**

---

## 🔹 Step 1: Create RetryListener

This listener dynamically attaches RetryAnalyzer **only when a test fails**.

```java
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RetryListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getMethod().getRetryAnalyzer() == null) {
            result.getMethod().setRetryAnalyzer(new RetryAnalyzer());
        }
    }

    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
}
```

---

## 🔹 Step 2: Register Listener in testng.xml

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="Retry Suite">

    <listeners>
        <listener class-name="RetryListener"/>
    </listeners>

    <test name="All Tests">
        <classes>
            <class name="LoginTest"/>
            <class name="PaymentTest"/>
        </classes>
    </test>

</suite>
```

---

## 🔹 Sample Test (No Retry Annotation Needed!)

```java
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTest {

    @Test
    public void paymentTest() {
        System.out.println("Executing paymentTest");
        Assert.assertEquals(500, 200); // force failure
    }
}
```

📌 Retry happens **automatically** when test fails.

---

### 🔄 Execution Flow (Global Level)

1. Test executes
2. Test fails ❌
3. `onTestFailure()` listener is triggered
4. RetryAnalyzer is attached dynamically
5. Test is retried

---

### ✅ Pros

* No duplicate annotations
* Clean test code
* Scales well

### ❌ Cons

* Slightly complex to understand initially

---

# 🆚 Test Level vs Global Level Comparison

| Feature        | Test Level      | Global Level   |
| -------------- | --------------- | -------------- |
| Configuration  | Per test method | One-time setup |
| Scalability    | ❌ Poor          | ✅ Excellent    |
| Maintenance    | ❌ High          | ✅ Low          |
| Industry Usage | ❌ Rare          | ✅ Very common  |

---

## ⚠️ Important Notes (Interview Points ⭐)

* Retry works **only for FAILED tests**
* Retry does **NOT** work for PASSED tests
* Retry count should be small (1–2)
* Do NOT use retry to hide real bugs

---

## 🎯 Interview One‑Liner

> "Using IRetryAnalyzer with ITestListener, we can apply retry logic globally so failed TestNG tests are automatically re‑executed without annotating each test method."

---

✅ **End of Document**

You can now download or reuse this `.md` file directly.
