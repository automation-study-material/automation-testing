# 📘 TestNG Core Concepts — Detailed Answers

---

# 1️⃣ Explain TestNG Architecture. Why is it better than JUnit?

## ✅ Concept

TestNG is a **testing framework built on top of Java Reflection + Annotations + XML configuration**.

It works like this internally:

- Reads `testng.xml`
- Scans classes using Reflection
- Finds annotations (@Test, @BeforeMethod, etc.)
- Builds execution plan
- Executes methods in order
- Generates reports

---

## ✅ Architecture Flow

```
testng.xml
     ↓
Suite Parser
     ↓
Annotation Scanner (Reflection)
     ↓
Dependency Resolver
     ↓
Thread Pool Manager
     ↓
Test Executor
     ↓
Listeners / Reports
```

---

## ✅ Why TestNG is better than JUnit?

| Feature | TestNG | JUnit |
|---------|-----------|---------|
| Parallel execution | ✅ Native | ❌ Limited |
| testng.xml | ✅ Yes | ❌ No |
| Dependency management | ✅ Yes | ❌ No |
| Groups | ✅ Yes | ❌ No |
| DataProvider | ✅ Powerful | Limited |
| Retry mechanism | ✅ Built-in | Manual |
| Suite-level config | ✅ Yes | ❌ No |

---

## ✅ Interview Line

👉 **“TestNG is more suitable for large automation frameworks due to parallelism, grouping, dependency control and XML-driven execution.”**

---

---

# 2️⃣ What is Lifecycle of TestNG Annotations?

## ✅ Concept

TestNG runs methods in a **hierarchical execution order**:

```
Suite → Test → Class → Method
```

Each level controls setup/cleanup scope.

---

## ✅ Execution Order

```
@BeforeSuite
   @BeforeTest
      @BeforeClass
         @BeforeMethod
            @Test
         @AfterMethod
      @AfterClass
   @AfterTest
@AfterSuite
```

---

## ✅ Example

```java
@BeforeSuite
public void startSuite(){}

@BeforeClass
public void setupClass(){}

@BeforeMethod
public void setup(){}

@Test
public void testLogin(){}

@AfterMethod
public void cleanup(){}
```

---

## ✅ Memory Trick

👉 **S → T → C → M → Test → M → C → T → S**

---

## ✅ Practical Meaning

| Annotation | Scope | Use Case |
|-------------|-----------|----------------|
| BeforeSuite | Whole suite | Reports, DB connection |
| BeforeTest | Per <test> block | Browser launch |
| BeforeClass | Per class | Page objects setup |
| BeforeMethod | Per test | Login, reset data |
| AfterMethod | Per test | Cleanup |
| AfterSuite | End of suite | Close reports |

---

# 🎯 Quick Summary

- TestNG uses reflection + annotations + XML
- Lifecycle is hierarchical
- More powerful than JUnit
- Best for large automation frameworks
- Supports parallelism, grouping, dependencies, data-driven testing

---

Happy Learning 🚀
