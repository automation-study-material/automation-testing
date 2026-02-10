# 🚀 Wrapper Classes in Java – Complete Notes

---

# ✅ What are Wrapper Classes?

## Definition

**Wrapper classes** are Java classes that convert **primitive data types into objects**.

They “wrap” a primitive value inside an object.

---

## Primitive → Wrapper Mapping

| Primitive | Wrapper Class |
| --------- | ------------- |
| byte      | Byte          |
| short     | Short         |
| int       | Integer       |
| long      | Long          |
| float     | Float         |
| double    | Double        |
| char      | Character     |
| boolean   | Boolean       |

---

---

# 🔴 Why Do We Need Wrapper Classes?

This is the **most important question**.

> ❓ *If primitives already exist, why wrapper classes?*

Because **many Java features work only with objects**, not primitives.

---

---

# ✅ Reasons for Using Wrapper Classes

---

## 🔹 1️⃣ Collections Work Only with Objects (Most Important)

### ❌ Invalid (Primitive not allowed)

```java
ArrayList<int> list = new ArrayList<>(); // compile-time error
```

### ✅ Valid (Wrapper)

```java
ArrayList<Integer> list = new ArrayList<>();
list.add(10);
```

👉 Collections store **object references**, not primitive values.

---

---

## 🔹 2️⃣ Generics Support Only Objects

```java
Map<String, Integer> map = new HashMap<>();
List<Double> prices = new ArrayList<>();
```

Primitives cannot be used with generics.

---

---

## 🔹 3️⃣ Support for `null` Values

### Primitive (Not allowed)

```java
int a = null; // ❌ error
```

### Wrapper (Allowed)

```java
Integer a = null; // ✅
```

Very useful in:

* Database values
* API responses
* Optional fields

---

---

## 🔹 4️⃣ Utility Methods Provided

Wrapper classes provide many **useful methods**.

### Examples

```java
Integer.parseInt("100");
Double.parseDouble("10.5");
Boolean.parseBoolean("true");
```

Primitives cannot do this.

---

---

## 🔹 5️⃣ Object-Oriented Features

Wrapper classes:

* Are objects
* Have methods
* Can be passed as references
* Can be used in frameworks

Primitives:

* Store only values
* No methods

---

---

# ✅ Autoboxing and Unboxing

---

## 🔹 Autoboxing

Automatically converts **primitive → wrapper**.

```java
int x = 10;
Integer obj = x;   // autoboxing
```

Internally:

```java
Integer obj = Integer.valueOf(10);
```

---

---

## 🔹 Unboxing

Automatically converts **wrapper → primitive**.

```java
Integer obj = 20;
int y = obj;   // unboxing
```

Internally:

```java
int y = obj.intValue();
```

---

---

## 🔹 Example Code

```java
public class WrapperDemo {
    public static void main(String[] args) {

        int a = 5;

        // Autoboxing
        Integer obj = a;

        // Unboxing
        int b = obj;

        System.out.println(obj + " " + b);
    }
}
```

---

---

# ✅ Real-Time Usage Examples

---

## 🟢 Example 1: Collections

```java
List<Integer> marks = new ArrayList<>();
marks.add(90);
marks.add(85);
```

---

## 🟢 Example 2: Selenium / Test Data

```java
Map<String, Integer> userAge = new HashMap<>();
userAge.put("Nitin", 28);
```

---

## 🟢 Example 3: API / JSON POJO

```java
private Integer age;
```

Why not `int`?
👉 API may return `null`.

---

---

## 🟢 Example 4: Database Values

```java
Integer salary = resultSet.getInt("salary");
```

Database fields can be null.

---

---

# ✅ Common Wrapper Utility Methods

---

## Integer

```java
Integer.parseInt("123");
Integer.valueOf(10);
Integer.max(5, 10);
```

---

## Double

```java
Double.parseDouble("99.5");
```

---

## Boolean

```java
Boolean.parseBoolean("true");
```

---

---

# 🔥 Primitive vs Wrapper (Interview Table)

| Feature       | Primitive | Wrapper |
| ------------- | --------- | ------- |
| Data type     | Value     | Object  |
| Speed         | Faster    | Slower  |
| Memory        | Less      | More    |
| Supports null | ❌         | ✅       |
| Methods       | ❌         | ✅       |
| Collections   | ❌         | ✅       |
| Generics      | ❌         | ✅       |

---

---

# ❓ Why Not Always Use Wrapper Classes?

Because wrapper classes:

* Consume more memory
* Are slower than primitives
* Create unnecessary objects

---

---

# ✅ When to Use What?

---

## ✔ Use Primitive When:

* Simple calculations
* Performance is critical
* Local variables

```java
int sum = a + b;
```

---

## ✔ Use Wrapper When:

* Working with collections
* Using generics
* Handling null values
* Reading DB / API data
* Using utility methods

```java
Integer count = null;
```

---

---

# ✅ Interview Questions & Answers

---

### Q1. Why are wrapper classes needed?

Collections and generics work only with objects.

---

### Q2. What is autoboxing?

Automatic conversion of primitive to wrapper.

---

### Q3. Difference between `int` and `Integer`?

`int` is primitive, `Integer` is an object.

---

### Q4. Can wrapper classes be null?

Yes.

---

### Q5. Which is faster – primitive or wrapper?

Primitive.

---

---

# 🧠 Easy Memory Trick

```
Primitive → Fast
Wrapper   → Flexible
```

---

---

# 🎯 Interview One-Liner

> “Wrapper classes allow primitive data types to be used as objects so they can work with collections, generics, and APIs. They also provide utility methods and support null values, which primitives cannot.”

---

END
