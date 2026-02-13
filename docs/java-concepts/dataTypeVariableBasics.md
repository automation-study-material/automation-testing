# Java Basics – Data Types, Variables & Operators

This document covers **core Java fundamentals** required for **software testing & automation**.

---

## 1️⃣ Data Types in Java

Java is a **statically typed** language, meaning variables must have a declared data type.

---

### 🔹 Primitive Data Types || Ascending Order (small → large)

| Order | Type    | Size    | Example                     | Usage                    |
|-------|---------|----------|-----------------------------|----------------------------|
| 1 | `boolean` | 1 bit  | `boolean result = true;` | Pass/Fail conditions |
| 2 | `char`    | 2 bytes | `char grade = 'A';`      | Single characters |
| 3 | `int`     | 4 bytes | `int age = 25;`          | Status codes, counts |
| 4 | `double`  | 8 bytes | `double price = 99.99;`  | Decimal values |

---

### 🔹 Non-Primitive Data Type

#### `String`
- Used to store text
- Most commonly used in testing

```java
String message = "Login Successful";
```

**Common testing usage:**
- UI text validation
- API response validation
- Error message comparison

---

## 2️⃣ Variables in Java

A variable stores data that can change during program execution.

### 🔹 Syntax
```java
dataType variableName = value;
```

### 🔹 Example
```java
int expectedResult = 200;
boolean isDisplayed = true;
```

---

### 🔹 Variable Naming Rules
✅ Must start with a letter, `_` or `$`  
✅ Cannot start with a number  
✅ Cannot use Java keywords  
✅ Case-sensitive  

❌ Invalid
```java
int 1value;
int class;
```

✅ Valid
```java
int value1;
int totalCount;
```

---

## 3️⃣ Operators in Java

Operators perform operations on variables and values.

---

### 🔹 Arithmetic Operators

| Operator | Description | Example |
|--------|-------------|--------|
| `+` | Addition | `a + b` |
| `-` | Subtraction | `a - b` |
| `*` | Multiplication | `a * b` |
| `/` | Division | `a / b` |
| `%` | Modulus | `a % b` |


✅ Java Code Examples for `/` and `%`

| Operator | Purpose | Java Code | Output |
|------------|------------|-------------------------------|-----------|
| `/` | Integer Division | `System.out.println(10 / 3);` | 3 |
| `/` | Exact Division | `System.out.println(10 / 2);` | 5 |
| `/` | Double Division | `System.out.println(10.0 / 3);` | 3.3333333333333335 |
| `%` | Remainder | `System.out.println(10 % 3);` | 1 |
| `%` | Even/Odd Check | `System.out.println(8 % 2);` | 0 |
| `%` | No Remainder | `System.out.println(15 % 5);` | 0 |

---

### 🔹 Relational Operators

Used for **comparison**, very important in validations.

| Operator | Meaning |
|--------|--------|
| `==` | Equal to |
| `!=` | Not equal |
| `>` | Greater than |
| `<` | Less than |
| `>=` | Greater than or equal |
| `<=` | Less than or equal |

```java
if (actual == expected) {
    System.out.println("Test Passed");
}
```

---

### 🔹 Logical Operators

Used to combine multiple conditions.

| Operator | Meaning | Example |
|----------|----------|------------|
| && | AND | (a > 5 && b < 10) |
| || | OR | (a > 5 || b < 10) |
| !  | NOT | !(a > 5) |


```java
if (isLoggedIn && isDashboardVisible) {
    System.out.println("Login Test Passed");
}
```

---

## 4️⃣ Type Casting in Java

Type casting is converting one data type into another.

```text
double
↓
float
↓
long
↓
int
↓
short
↓
byte
```

### 🔹 Implicit Casting (Widening)
Automatic conversion from smaller to larger type.

```java
int a = 10;
double b = a;
```

---

### 🔹 Explicit Casting (Narrowing)
Manual conversion from larger to smaller type.

```java
double x = 10.5;
int y = (int) x;
```

---

## 🧪 Testing Perspective Summary

| Concept | Usage in Testing |
|------|------------------|
| Data Types | Store expected & actual values |
| Variables | Hold test data |
| Operators | Validations & conditions |
| Type Casting | Handle API & UI data |

---

## ✅ Interview Tip
> **90% of automation logic is built using these basics.  
Strong fundamentals = strong framework understanding.**

---
