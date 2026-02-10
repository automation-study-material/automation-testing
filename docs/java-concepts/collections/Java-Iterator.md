# Java Iterator Concepts – Complete Notes

---

# ✅ 1️⃣ Iterator vs ListIterator

## 🔹 Iterator

### Concept

Iterator is used to **traverse elements only in forward direction**.

### Works with

* List
* Set
* Queue
* All collections

---

### Methods

```java
hasNext()
next()
remove()
```

---

### Example

```java
Iterator<String> it = list.iterator();

while(it.hasNext()){
    System.out.println(it.next());
}
```

---

### Limitations

❌ Only forward
❌ Cannot add element
❌ Cannot replace element

---

---

# 🔹 ListIterator

## Concept

Special iterator for **List only**, supports:

✔ forward
✔ backward
✔ add
✔ update

---

### Works with

* List only (ArrayList, LinkedList)

---

### Methods

```java
hasNext()
next()
hasPrevious()
previous()
add()
set()
remove()
```

---

### Example

```java
ListIterator<String> it = list.listIterator();

while(it.hasNext()){
    System.out.println(it.next());
}

while(it.hasPrevious()){
    System.out.println(it.previous());
}
```

---

---

## 🔥 Difference Table (Very important for interview)

| Feature        | Iterator        | ListIterator       |
| -------------- | --------------- | ------------------ |
| Direction      | Forward only    | Forward + Backward |
| Works on       | All collections | List only          |
| Add element    | ❌               | ✅                  |
| Update element | ❌               | ✅                  |
| Replace        | ❌               | ✅                  |
| Index info     | ❌               | ✅                  |

---

---

# ✅ 2️⃣ Fail-Fast vs Fail-Safe Iterator

This is a **VERY COMMON interview question**.

---

# 🔴 Fail-Fast Iterator

## Concept

If collection is modified during iteration → **throws exception immediately**

---

## Behavior

```
ConcurrentModificationException
```

---

## Used by

* ArrayList
* HashSet
* HashMap
* LinkedList

---

## Example

```java
for(String s : list){
    list.remove(s); // ❌ crash
}
```

---

## Why?

Because iterator detects:

```
modCount changed
```

---

---

# 🟢 Fail-Safe Iterator

## Concept

Works on **copy of collection**, so modification is safe.

---

## Behavior

✔ No exception
✔ Works on snapshot

---

## Used by

* CopyOnWriteArrayList
* ConcurrentHashMap

---

## Example

```java
CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

for(String s : list){
    list.remove(s); // ✅ safe
}
```

---

---

## 🔥 Difference Table

| Feature           | Fail-Fast | Fail-Safe |
| ----------------- | --------- | --------- |
| Exception         | Yes       | No        |
| Works on          | original  | copy      |
| Safe modification | ❌         | ✅         |
| Performance       | fast      | slower    |
| Memory            | low       | high      |

---

---

# ✅ 3️⃣ forEach vs Iterator

---

# 🔹 forEach Loop

### Concept

Simple and readable way to loop.

---

### Example

```java
for(String s : list){
    System.out.println(s);
}
```

---

### Pros

✔ simple
✔ clean
✔ less code

---

### Cons

❌ cannot remove safely
❌ less control

---

---

# 🔹 Iterator

### Concept

Manual control over iteration.

---

### Example

```java
Iterator<String> it = list.iterator();

while(it.hasNext()){
    String s = it.next();
}
```

---

### Pros

✔ safe remove
✔ more control
✔ good for complex logic

---

### Cons

❌ more code

---

---

## 🔥 Difference Table

| Feature       | forEach   | Iterator |
| ------------- | --------- | -------- |
| Syntax        | simple    | verbose  |
| Remove safely | ❌         | ✅        |
| Control       | less      | more     |
| Direction     | forward   | depends  |
| Best for      | read-only | modify   |

---

---

# ✅ Real Selenium Framework Usage

---

## Window handles (Set → Iterator needed)

```java
Iterator<String> it = driver.getWindowHandles().iterator();
```

---

## Remove failed tests safely

```java
Iterator<String> it = failedTests.iterator();
it.remove();
```

---

## Simple read logs

```java
for(String log : logs)
```

---

---

# ✅ Interview Quick Answers

---

### Q: Difference between Iterator and ListIterator?

ListIterator supports bidirectional traversal and add/set methods.

---

### Q: What is fail-fast iterator?

Throws ConcurrentModificationException when modified during iteration.

---

### Q: What is fail-safe?

Works on copy, allows modification safely.

---

### Q: forEach vs Iterator?

forEach for read-only, Iterator for modification.

---

---

# ✅ Memory Tricks

```
Iterator → forward only
ListIterator → both ways

Fail-fast → fast but strict
Fail-safe → safe but heavy

forEach → simple read
Iterator → safe modify
```

---

---

# ✅ Final Summary

Use:

✔ forEach → read
✔ Iterator → remove
✔ ListIterator → modify list
✔ Fail-safe → concurrent apps

---

END
