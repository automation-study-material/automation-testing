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

---

## ✅ Concept

`invocationCount` repeats the SAME test multiple times.

👉 Think: **loop execution**

---

## 🔹 Syntax

```java
@Test(invocationCount = 3)
```

---

## 🔹 Use Cases

- retry logic testing
- stress testing
- idempotency check
- repeated API calls
- load simulation

---

## 🔹 Example

```java
@Test(invocationCount = 3)
public void testLoginAPI() {
    System.out.println("Running login API test");
}
```

---

## 🔹 Execution

```
Running login API test
Running login API test
Running login API test
```

---

## ⚠ Important

- Same data each time
- Sequential by default

---

---

# 🔵 2️⃣ threadPoolSize

---

## ✅ Concept

Runs multiple invocations in **parallel threads**.

👉 Works only with invocationCount

---

## 🔹 Syntax

```java
@Test(invocationCount = 5, threadPoolSize = 2)
```

---

## 🔹 Purpose

- speed up execution
- concurrency testing
- simulate multiple users
- API load testing

---

## 🔹 Example

```java
@Test(invocationCount = 5, threadPoolSize = 2)
public void testPaymentAPI() {
    System.out.println("Thread: " + Thread.currentThread().getId());
}
```

---

## 🔹 Possible Output

```
Thread 11
Thread 12
Thread 11
Thread 12
Thread 11
```

👉 Only 2 threads run concurrently

---

## 🔹 How it works internally

TestNG:

1. Creates thread pool
2. Submits tasks
3. Executes in parallel
4. Waits for completion

---

## ⚠ Selenium Warning

If using WebDriver:

❌ Shared driver causes crashes  
✅ Use ThreadLocal<WebDriver>

---

---

# 🔵 invocationCount + threadPoolSize Together

---

## Example (Load testing scenario)

```java
@Test(invocationCount = 10, threadPoolSize = 5)
public void testSearchAPI() {
    callSearchService();
}
```

Meaning:

- run 10 times
- 5 threads at same time

---

---

# 🔵 3️⃣ Running Same Test With Different Data

---

# ✅ Best Practice → DataProvider

---

## Concept

Runs same test multiple times with **different inputs**.

👉 Think: **parameterized tests**

---

## 🔹 Syntax

```java
@DataProvider
```

---

## 🔹 Example

```java
@DataProvider(name = "users")
public Object[][] usersData() {
    return new Object[][]{
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"}
    };
}

@Test(dataProvider = "users")
public void loginTest(String username, String password) {
    System.out.println(username + " " + password);
}
```

---

## 🔹 Execution

```
user1 pass1
user2 pass2
user3 pass3
```

---

## 🔹 Purpose

- data-driven testing
- multiple inputs
- edge cases
- functional validation

---

---

# 🔵 Parallel DataProvider

---

## Example

```java
@DataProvider(name="users", parallel=true)
```

Runs each dataset in parallel threads

---

---

# 🔵 Real Use Cases Comparison

| Requirement | Solution |
|------------|-----------|
Run same test many times | invocationCount |
Run same test in parallel | invocationCount + threadPoolSize |
Run test with different data | DataProvider |
Parallel different data | DataProvider(parallel=true) |
Load testing | invocationCount + threadPoolSize |
Functional validation | DataProvider |

---

---

# 🔵 Best Practices

## Prefer

✅ DataProvider for test data  
✅ invocationCount for stress/load  
✅ threadPoolSize for concurrency  

## Avoid

❌ using invocationCount for different inputs  
❌ sharing WebDriver in parallel tests  

---

---

# 🔵 Interview One-Liners

👉 invocationCount repeats the same test multiple times  
👉 threadPoolSize runs those invocations in parallel  
👉 DataProvider is used for running the same test with different data  
👉 For real frameworks DataProvider is preferred for functional testing  

---

---

# 🎯 Quick Summary

invocationCount → repeat  
threadPoolSize → parallel  
DataProvider → different inputs  

---

Happy Learning 🚀
