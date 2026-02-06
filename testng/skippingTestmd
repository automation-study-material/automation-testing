# 📘 TestNG Advanced Execution Guide (Complete with Full Code)

This guide covers:

✅ Dynamic Skip (SkipException) – full working code  
✅ How TestNG internally uses ExecutorService (thread pool)  
✅ How to exclude specific methods WITHOUT modifying XML structure  
✅ Purpose + Use cases + Full runnable examples + Outputs  

---

# 🔵 1️⃣ Dynamic Test Skipping using SkipException

## Purpose
Skip test dynamically at runtime based on condition.

## Full Working Code

```java
package tests;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class PaymentTest {

    @Test
    public void paymentGatewayTest() {

        boolean isGatewayDown = true;

        if (isGatewayDown) {
            throw new SkipException("Payment gateway is down → skipping test");
        }

        System.out.println("Payment processed");
    }
}
```

## Output
SKIPPED: Payment gateway is down → skipping test

---

# 🔵 2️⃣ How threadCount Works Internally

TestNG internally uses Java ThreadPool similar to:

```java
ExecutorService pool = Executors.newFixedThreadPool(threadCount);
```

## Simplified Internal Flow

```java
ExecutorService pool = Executors.newFixedThreadPool(2);

pool.submit(() -> testA());
pool.submit(() -> testB());
pool.submit(() -> testC());

pool.shutdown();
```

## TestNG Example

```xml
<suite parallel="methods" thread-count="2">
```

```java
@Test
public void testA() {
    System.out.println(Thread.currentThread().getId());
}

@Test
public void testB() {
    System.out.println(Thread.currentThread().getId());
}
```

---

# 🔵 3️⃣ Excluding Methods WITHOUT modifying class

## Option A

```java
@Test(enabled = false)
```

## Option B (Groups)

```java
@Test(groups = "slow")
```

XML:

```xml
<exclude name="slow"/>
```

## Option C (Method exclude)

```xml
<class name="tests.LoginTest">
    <methods>
        <exclude name="testPayment"/>
    </methods>
</class>
```

## Option D (Runtime)

```java
throw new SkipException("Skip test");
```

---

Happy Learning 🚀
