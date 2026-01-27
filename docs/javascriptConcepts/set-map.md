# Sets & Maps in JavaScript (From Scratch)

---

## 1. Introduction

JavaScript provides two powerful ES6 data structures:
- **Set** → stores unique values
- **Map** → stores key–value pairs with flexible key types

They are commonly used in **frontend development**, **React apps**, and **interview questions**.

---

## 2. Set in JavaScript

### 2.1 What is a Set?
A **Set** is a collection of **unique values**.  
Duplicate values are automatically ignored.

```js
const mySet = new Set();
```

---

### 2.2 Key Characteristics of Set
- Stores **only unique values**
- Maintains **insertion order**
- No index-based access
- Can store any data type

---

### 2.3 Creating a Set

```js
const numbers = new Set([1, 2, 3, 3, 4]);
console.log(numbers); // Set(4) {1, 2, 3, 4}
```

---

### 2.4 Common Set Methods

| Method | Description |
|------|------------|
| `add(value)` | Adds a value |
| `delete(value)` | Removes a value |
| `has(value)` | Checks existence |
| `size` | Number of elements |
| `clear()` | Removes all elements |

```js
const set = new Set();
set.add(10);
set.add(20);
set.add(10);

console.log(set.has(20)); // true
console.log(set.size);    // 2
```

---

### 2.5 Iterating a Set

```js
for (let value of set) {
  console.log(value);
}
```

---

### 2.6 Real-World Use Cases of Set

#### Remove duplicates from array
```js
const arr = [1, 2, 2, 3, 4, 4];
const uniqueArr = [...new Set(arr)];
```

#### Track unique user actions
```js
const visitedPages = new Set();
visitedPages.add("home");
visitedPages.add("profile");
```

---

## 3. Map in JavaScript

### 3.1 What is a Map?
A **Map** stores data in **key–value pairs**, where **keys can be any type**.

```js
const myMap = new Map();
```

---

### 3.2 Why Use Map Instead of Object?

| Feature | Map | Object |
|------|-----|--------|
| Key types | Any type | String/Symbol |
| Order | Preserved | Not guaranteed |
| Size | `map.size` | Manual |
| Iteration | Easy | Complex |

---

### 3.3 Creating a Map

```js
const userMap = new Map();
userMap.set("name", "Nitin");
userMap.set("age", 28);
```

---

### 3.4 Common Map Methods

| Method | Description |
|------|------------|
| `set(key, value)` | Add entry |
| `get(key)` | Read value |
| `has(key)` | Check existence |
| `delete(key)` | Remove entry |
| `size` | Number of entries |
| `clear()` | Remove all entries |

```js
console.log(userMap.get("name")); // Nitin
```

---

### 3.5 Using Objects as Keys

```js
const objKey = { id: 1 };
const map = new Map();

map.set(objKey, "User Data");
console.log(map.get(objKey)); // User Data
```

---

### 3.6 Iterating a Map

```js
for (let [key, value] of map) {
  console.log(key, value);
}
```

---

### 3.7 Real-World Use Cases of Map

#### Frequency Counter
```js
const arr = ["a", "b", "a", "c"];
const freqMap = new Map();

for (let item of arr) {
  freqMap.set(item, (freqMap.get(item) || 0) + 1);
}
```

#### Caching API responses
```js
const cache = new Map();

function getData(key, value) {
  if (!cache.has(key)) {
    cache.set(key, value);
  }
  return cache.get(key);
}
```

---

## 4. Set vs Map vs Object vs Array

| Feature | Set | Map | Object | Array |
|------|----|----|------|------|
| Stores | Unique values | Key–value | Key–value | Indexed |
| Duplicates | ❌ | ✅ | ✅ | ✅ |
| Access | Value | Key | Key | Index |
| Order | Yes | Yes | No | Yes |

---

## 5. Interview Tips

- Use **Set** when uniqueness is required
- Use **Map** for frequent add/remove operations
- Avoid Objects for heavy iteration & performance-critical logic

---

## 6. Summary

- **Set** → unique values
- **Map** → flexible key–value pairs
- Both are ES6 features and widely used in modern frontend apps

---
