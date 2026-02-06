# 📘 TestNG Guide — invocationCount, threadPoolSize & Data-Driven Testing

---

# 🔹 Overview

In TestNG, we often need to:

✅ Run the same test multiple times  
✅ Run tests concurrently (parallel)  
✅ Run tests with different datasets  

TestNG provides:

- invocationCount → repeat test N times
- threadPoolSize → run those repeats in parallel
- DataProvider → run test with different data

Each serves a different purpose.

---

---

# 🔵 1️⃣ invocationCount

## ✅ Concept
Repeats the SAME test multiple times.

👉 Think: **loop execution**

---

## Example

```java
@Test(invocationCount = 3)
public void testLoginAPI() {
    System.out.println("Running login API test");
}
```

### Execution

```
Run
Run
Run
```

---

## Use Cases
- stress testing
- retry logic
- idempotency testing
- repeated API calls

---

---

# 🔵 2️⃣ threadPoolSize

## ✅ Concept
Runs invocations in **parallel threads** (must be used with invocationCount).

---

## Example

```java
@Test(invocationCount = 5, threadPoolSize = 2)
public void testPaymentAPI() {
    System.out.println(Thread.currentThread().getId());
}
```

### Execution (parallel)

```
Thread 11
Thread 12
Thread 11
Thread 12
Thread 11
```

---

## Use Cases
- concurrency testing
- simulate multiple users
- performance testing

---

⚠ Selenium Note:
Use ThreadLocal<WebDriver> for thread safety.

---

---

# 🔵 3️⃣ DataProvider — Run Test with Different Data

## ✅ Concept
Runs same test multiple times with **different inputs**.

👉 Think: **parameterized testing**

---

## Basic Example

```java
@DataProvider
public Object[][] users() {
    return new Object[][]{
        {"user1", "pass1"},
        {"user2", "pass2"}
    };
}

@Test(dataProvider = "users")
public void loginTest(String user, String pass) {
    System.out.println(user);
}
```

### Execution

```
user1
user2
```

---

---

# 🔥 NEW — Cross Package DataProvider (Real Framework Use Case)

---

## ✅ Scenario

We have:

```
xyz package → DataProvider class
bny.erp package → Test class
```

We want to reuse common test data across packages.

---

## 📦 Package Structure

```
src/test/java
   ├─ xyz
   │     └─ TestDataProvider.java
   ├─ bny/erp
   │     └─ ERPLoginTest.java
```

---

## Step 1 — Create DataProvider in xyz package

### xyz/TestDataProvider.java

```java
package xyz;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "erpUsers")
    public static Object[][] erpUsers() {
        return new Object[][]{
            {"admin", "admin123"},
            {"manager", "manager123"},
            {"user", "user123"}
        };
    }
}
```

---

## Step 2 — Use in another package/class

### bny/erp/ERPLoginTest.java

```java
package bny.erp;

import org.testng.annotations.Test;
import xyz.TestDataProvider;

public class ERPLoginTest {

    @Test(dataProvider = "erpUsers", dataProviderClass = TestDataProvider.class)
    public void loginERP(String username, String password) {
        System.out.println(username + " -> " + password);
    }
}
```

---

## ✅ Important

When DataProvider is in DIFFERENT class/package:

You MUST use:

```
dataProviderClass = TestDataProvider.class
```

Otherwise TestNG cannot find it.

---

## 🔥 Execution Flow

TestNG internally:

1. Finds test method
2. Looks for provider in specified class
3. Calls erpUsers()
4. Creates 3 test invocations

---

## Execution Output

```
admin -> admin123
manager -> manager123
user -> user123
```

---

## ✅ Real Use Cases

- shared test data library
- common login credentials
- API payload sets
- reusable across multiple modules
- framework centralization

---

---

# 🔵 Parallel DataProvider

```java
@DataProvider(name="erpUsers", parallel=true)
```

Runs each dataset in parallel.

---

---

# 🔵 Quick Comparison

| Requirement | Solution |
|------------|-----------|
Repeat same test | invocationCount |
Repeat in parallel | invocationCount + threadPoolSize |
Different inputs | DataProvider |
Cross package reuse | dataProviderClass |
Parallel different inputs | DataProvider(parallel=true) |

---

---

# 🔵 Best Practices

✅ Keep DataProviders in separate utility package  
✅ Make them reusable  
✅ Prefer DataProvider over invocationCount for data testing  
✅ Use parallel=true for faster execution  

---

---

# 🔵 Interview One-Liners

👉 invocationCount repeats test  
👉 threadPoolSize runs repeats in parallel  
👉 DataProvider runs same test with different data  
👉 dataProviderClass allows cross-class/package reuse  

---

---

Happy Learning 🚀
