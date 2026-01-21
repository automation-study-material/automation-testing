# ArrayList – In‑Depth Interview Notes

This document explains **ArrayList** as a **data structure**, covering **internal working, performance, shifting behavior, and when to use it**, at an interview‑ready level.

---

## 1. What is ArrayList?

`ArrayList` is a **resizable (dynamic) array implementation** of the `List` interface.

* Stores elements in **contiguous memory**
* Backed internally by an **Object[] array**
* Allows **duplicate elements**
* Maintains **insertion order**
* Provides **index‑based access**

---

## 2. Internal Structure

Internally, ArrayList looks like this:

```java
public class ArrayList<E> {
    transient Object[] elementData; // internal array
    private int size;               // number of elements
}
```

* `elementData` stores **references to objects**, not actual objects
* Each slot holds a **reference (4 or 8 bytes depending on JVM)**

### Logical View

```
Index:   0     1     2     3
Array:  A     B     C     D
```

---

## 3. Capacity vs Size

* **Size** → Number of elements actually stored
* **Capacity** → Length of internal array

```java
ArrayList<Integer> list = new ArrayList<>();
```

* Initial capacity = **10** (created lazily)
* Size starts from **0**

---

## 4. How ArrayList Grows (Resizing)

When the internal array becomes full:

```java
newCapacity = oldCapacity + (oldCapacity >> 1); // 1.5x growth
```

### What happens during resize?

1. New larger array is created
2. Old elements are copied using `System.arraycopy()`
3. Old array becomes eligible for GC

⛔ **Resize is costly** because it copies all existing references

---

## 5. Insertion in ArrayList (Shifting Explained)

### Example

```java
list.add(1, "X");
```

### Before insertion

```
Index:  0   1   2   3
        A   B   C   D
```

### After insertion

```
Index:  0   1   2   3   4
        A   X   B   C   D
```

### What actually shifts?

⚠️ **Not raw memory bytes**

✔ Java shifts **object references** inside the `Object[]`

### Internal operation

```java
System.arraycopy(
    elementData,   // source
    index,         // start position
    elementData,   // destination
    index + 1,     // shift right
    size - index   // number of references
);
```

📌 This is an **O(n)** operation

---

## 6. Removal in ArrayList (Left Shift)

### Example

```java
list.remove(1);
```

### Before removal

```
A   B   C   D
```

### After removal

```
A   C   D
```

### Internal behavior

```java
System.arraycopy(
    elementData,
    index + 1,
    elementData,
    index,
    size - index - 1
);

elementData[--size] = null; // avoid memory leak
```

✔ Last reference is set to `null` to help **Garbage Collection**

---

## 7. Why Shifting Affects Performance

### Cost factors

* Multiple reference moves
* CPU cache invalidation
* Larger array → more shifting
* Frequent insert/remove → high CPU usage

### Worst case example

```java
for (int i = 0; i < 100000; i++) {
    list.add(0, i); // worst case
}
```

📉 Time complexity becomes **O(n²)**

---

## 8. Resize + Shift = Double Cost

Worst scenario during insertion:

1. Array is full → resize (copy all elements)
2. Insert at index → shift elements again

📌 Two expensive operations in one call

---

## 9. Time Complexity Summary

| Operation     | Complexity | Reason              |
| ------------- | ---------- | ------------------- |
| get(index)    | O(1)       | Direct index access |
| add(e)        | O(1)*      | Amortized           |
| add(index, e) | O(n)       | Shifting            |
| remove(index) | O(n)       | Shifting            |
| contains()    | O(n)       | Linear search       |

---

## 10. Commonly Used ArrayList Methods

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");
list.add("Python");
list.add(1, "Go");

list.get(0);        // Java
list.set(1, "Rust");
list.remove(0);

list.contains("Java");
list.size();
list.isEmpty();
```

---

## 11. System.arraycopy() – Important Notes

```java
public static native void arraycopy(...);
```

* Implemented in **JVM (C/C++)**, not Java
* Uses optimized native memory copy
* Much faster than manual loops
* Still **O(n)**

❌ Cannot view Java source
✔ Can observe behavior via benchmarks

---

## 12. Memory & Cache Behavior

### Advantages

* Contiguous memory
* Cache‑friendly
* Very fast read operations

### Disadvantages

* Costly shifting
* Resize overhead

---

## 13. When to Use ArrayList

✔ Read‑heavy operations
✔ Frequent `get(index)` calls
✔ Append‑only scenarios
✔ Configuration or static data

❌ Avoid when:

* Frequent insert/delete in middle
* Large dynamic modifications

---

## 14. ArrayList vs LinkedList (Quick View)

| Feature        | ArrayList     | LinkedList         |
| -------------- | ------------- | ------------------ |
| Internal DS    | Dynamic Array | Doubly Linked List |
| Memory         | Less          | More (prev/next)   |
| get(index)     | O(1)          | O(n)               |
| Insert middle  | O(n) (shift)  | O(1)*              |
| Cache friendly | Yes           | No                 |

---

## 15. Interview‑Ready Explanation (Use This)

> *ArrayList internally uses a dynamic Object array. When we insert or remove an element at a specific index, the subsequent elements must be shifted using System.arraycopy. Although only object references are moved, this still causes O(n) time complexity and impacts performance for large lists with frequent modifications. However, ArrayList offers excellent read performance due to contiguous memory layout.*

---

## 16. Key Takeaways

✔ Backed by `Object[]`
✔ Shifts **references**, not raw bytes
✔ Insert/remove in middle is expensive
✔ Best choice for read‑heavy use cases
✔ Default List implementation in real projects

---

**End of Notes**
