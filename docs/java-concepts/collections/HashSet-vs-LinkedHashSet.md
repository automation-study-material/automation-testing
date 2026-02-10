# Set, HashSet and LinkedHashSet – Deep Dive

---

## ✅ Step 1 — Why do we even need Set if ArrayList already exists?

Before jumping into classes, understand the **problem Set solves**.

---

## ❌ Problem with ArrayList

```java
List<String> list = new ArrayList<>();

list.add("ACC123");
list.add("ACC123"); // duplicate allowed ❌
```

### Issues

* ❌ Duplicates allowed
* ❌ Manual duplicate checking required
* ❌ Slow searching → **O(n)**

---

## ✅ What Set guarantees

A **Set** provides:

* ✔ No duplicates
* ✔ Fast lookup
* ✔ Mathematical set behavior
* ✔ Useful for unique data

```java
Set<String> set = new HashSet<>();

set.add("ACC123");
set.add("ACC123"); // ignored automatically ✅
```

---

## ✅ Concept Summary

| Feature      | List         | Set           |
| ------------ | ------------ | ------------- |
| Duplicates   | Allowed      | ❌ Not allowed |
| Order        | Insertion    | Depends       |
| Search speed | Slow         | Faster        |
| Use case     | Ordered data | Unique data   |

---

## ✅ Step 2 — Why TWO implementations?

Java designers optimized for **different needs**.

Sometimes we need:

1️⃣ **Fastest performance** → `HashSet`
2️⃣ **Order + uniqueness** → `LinkedHashSet`

So Java provides both.

---

## ✅ HashSet Concept

### Definition

**Unordered + Unique + Fast**

### Example

```java
Set<String> set = new HashSet<>();
set.add("A");
set.add("B");
set.add("C");

System.out.println(set);
```

**Output**

```
[B, A, C]  // random order
```

---

## ✅ HashSet Internal Working (Deep Explanation)

### 🔹 What really happens when you do:

```java
Set<String> set = new HashSet<>();
set.add("ACC123");
```

Internally, `HashSet` uses `HashMap`:

```java
HashMap<E, Object> map;
```

* Elements are stored as **keys**
* Values are **dummy objects**

---

## 🧠 Step-by-Step Internal Flow

---

### ✅ Step 1 — `hashCode()` is generated

```java
"ACC123".hashCode();
```

Example:

```
hashCode = 12345678
```

**Purpose**

* Convert object → integer
* Decide storage location

---

### ✅ Step 2 — Bucket index is calculated

HashMap has an internal **bucket array**.

Default size:

```
16 buckets
```

Formula:

```java
index = hashCode % arraySize;
```

Example:

```
12345678 % 16 = 14
```

➡ Stored in `bucket[14]`

---

### ✅ Step 3 — Stored in bucket

Java checks:

👉 Is `bucket[14]` empty?

**Case 1: Empty**

```
bucket[14] → "ACC123"
```

**Case 2: Collision**

```
bucket[14] → [ACC120, ACC121]
```

Java adds it using collision handling.

**Internally**

* Java 7 → LinkedList
* Java 8+ → LinkedList → Tree (if many collisions)

---

### ✅ Step 4 — Duplicate check using `equals()`

Java compares:

```java
existingElement.equals(newElement);
```

Example:

```java
"ACC123".equals("ACC123") → true
```

* ✅ `true` → Duplicate → **NOT added**
* ❌ `false` → Unique → **Added**

⚠️ **IMPORTANT RULE**

> HashSet uses **both `hashCode()` and `equals()`**

---

## 🔁 Summary Flow (Interview Gold)

```
add(element)
   ↓
hashCode()
   ↓
bucket index calculation
   ↓
check bucket
   ↓
equals() comparison
   ↓
add OR ignore
```

---

## ⚠️ Why BOTH `hashCode()` and `equals()` are needed?

Different objects may have **same hashCode**:

```text
"ABC"
"CBA"
```

➡ Same bucket

So Java uses:

* `hashCode()` → bucket
* `equals()` → actual equality

---

## 🧪 Custom Object Example (Very Important)

```java
class Account {
    String accNo;
}
```

If you **don’t override**:

```java
equals()
hashCode()
```

```java
set.add(new Account("A1"));
set.add(new Account("A1"));
```

❌ Duplicates allowed!

### Correct Way

```java
@Override
public int hashCode() {
    return accNo.hashCode();
}

@Override
public boolean equals(Object obj) {
    Account other = (Account) obj;
    return this.accNo.equals(other.accNo);
}
```

---

## 🏦 Banking Selenium Example (Real World)

### Prevent duplicate transaction IDs

```java
Set<String> txnIds = new HashSet<>();

txnIds.add("TXN1001");
txnIds.add("TXN1001"); // ignored automatically
```

Why it works:

* `hashCode()` → bucket
* `equals()` → duplicate detection

---

## ⏱️ Time Complexity

| Operation  | Time                  |
| ---------- | --------------------- |
| add        | O(1)                  |
| remove     | O(1)                  |
| contains   | O(1)                  |
| Worst case | O(n) (hash collision) |

---

## 🎯 Interview One-Liner

> “HashSet internally uses HashMap.
> On add, it generates hashCode, calculates bucket index, checks duplicates using equals, and stores the element if unique.”

---

## ✅ LinkedHashSet Concept

### Definition

**Insertion Order + Unique**

### Example

```java
Set<String> set = new LinkedHashSet<>();
set.add("A");
set.add("B");
set.add("C");

System.out.println(set);
```

**Output**

```
[A, B, C]
```

---

## ✅ LinkedHashSet Internals

Uses:

* HashMap
* Doubly Linked List

Internally:

```
LinkedHashMap
```

Structure:

```
Hash Table  → Fast lookup
Linked List → Maintains order
```

Diagram:

```
A <-> B <-> C
```

✔ Order maintained
❌ Slightly slower
❌ Extra memory

---

## ✅ Real-Time Selenium / Banking Examples

### ⭐ Example 1 — Unique Window Handles (HashSet)

```java
Set<String> handles = driver.getWindowHandles();
```

* Unique
* Order doesn’t matter

---

### ⭐ Example 2 — Unique Login Users

```java
Set<String> users = new HashSet<>();
users.add("cust001");
users.add("cust001");
```

✔ No duplicate login

---

### ⭐ Example 3 — Transaction IDs (LinkedHashSet)

```java
Set<String> txnIds = new LinkedHashSet<>();
```

✔ Unique
✔ Order preserved for reports

---

### ⭐ Example 4 — Dropdown Validation

```java
Set<String> actual = new HashSet<>(optionsFromUI);
Set<String> expected = new HashSet<>(expectedOptions);

assert actual.equals(expected);
```

---

## ✅ Common Set Methods

```java
set.add("A");
set.remove("A");
set.contains("A");
set.size();
set.isEmpty();
set.clear();

for(String s : set) {
    System.out.println(s);
}
```

---

## ✅ Full Example Code

```java
import java.util.*;

public class SetDemo {
    public static void main(String[] args) {

        Set<String> hashSet = new HashSet<>();
        hashSet.add("Java");
        hashSet.add("Python");
        hashSet.add("Java");

        System.out.println("HashSet: " + hashSet);

        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Java");
        linkedSet.add("Python");
        linkedSet.add("Java");

        System.out.println("LinkedHashSet: " + linkedSet);
    }
}
```

**Output**

```
HashSet: [Python, Java]
LinkedHashSet: [Java, Python]
```

---

## ✅ HashSet vs LinkedHashSet

| Feature          | HashSet        | LinkedHashSet       |
| ---------------- | -------------- | ------------------- |
| Order            | ❌ No           | ✅ Yes               |
| Speed            | Fastest        | Slightly slower     |
| Memory           | Low            | Higher              |
| Structure        | HashMap        | LinkedHashMap       |
| Use case         | Lookup         | Ordered unique      |
| Selenium example | Window handles | Transaction history |

---

## ✅ Interview Questions

**Q1. Why Set over List?**
To avoid duplicates

**Q2. Why HashSet faster?**
Hashing → O(1)

**Q3. Why LinkedHashSet slower?**
Extra linked list

**Q4. Does Set allow null?**
Yes (one null)

**Q5. Internal DS?**
HashMap vs LinkedHashMap

---

## ✅ Quick Rule to Remember

👉 Fastest + unique → **HashSet**
👉 Order + unique → **LinkedHashSet**
👉 Sorted data → **TreeSet**

---
