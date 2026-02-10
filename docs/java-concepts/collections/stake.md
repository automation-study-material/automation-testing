# Stack vs Queue in Java Collections

---

# 📌 Stack (LIFO)

## Concept

Stack follows:

LIFO → Last In First Out

Example:

* Plates stack
* Browser back
* Undo/Redo

---

## Diagram (LIFO)

```
push(A)
push(B)
push(C)

Stack:

| C |  ← pop()
| B |
| A |
-----
```

After pop() → C removed first

---

## Internal Working

Stack extends Vector:

```
Stack → Vector → Object[]
```

Internally:

Object[] elementData
int size

### push()

elementData[size++] = item

### pop()

return elementData[--size]

Time Complexity → O(1)

---

## Methods

### push()

```java
stack.push("A");
```

### pop()

```java
stack.pop();
```

### peek()

```java
stack.peek();
```

### empty()

```java
stack.empty();
```

### search()

```java
stack.search("A");
```

---

## Example Code

```java
Stack<String> stack = new Stack<>();

stack.push("Java");
stack.push("Python");
stack.push("Go");

System.out.println(stack.peek());
System.out.println(stack.pop());
System.out.println(stack.empty());
```

---

## Selenium Real-time Use Cases

### 1. Window Handling

```java
Stack<String> windows = new Stack<>();

windows.push(driver.getWindowHandle());

driver.switchTo().window(windows.pop());
```

### 2. Navigation History

```java
Stack<String> pages = new Stack<>();
pages.push("Login");
pages.push("Home");
pages.pop();
```

### 3. Undo Steps

```java
Stack<Runnable> undo = new Stack<>();
undo.push(() -> driver.close());
undo.pop().run();
```

---

---

# 📌 Queue (FIFO)

## Concept

FIFO → First In First Out

Example:

* Ticket queue
* Printer queue
* Call center queue

---

## Diagram (FIFO)

```
offer(A)
offer(B)
offer(C)

Front → A  B  C ← Rear

poll() removes A first
```

---

## Internal Working

Usually implemented by:

* LinkedList
* ArrayDeque
* PriorityQueue

Uses:

* head pointer
* tail pointer

Time Complexity → O(1)

---

## Methods

### offer()

```java
queue.offer("A");
```

### poll()

```java
queue.poll();
```

### peek()

```java
queue.peek();
```

### isEmpty()

```java
queue.isEmpty();
```

---

## Example Code

```java
Queue<String> queue = new LinkedList<>();

queue.offer("Java");
queue.offer("Python");
queue.offer("Go");

System.out.println(queue.poll());
System.out.println(queue.peek());
```

---

## Selenium Real-time Use Cases

### 1. Test Execution Queue

```java
Queue<String> tests = new LinkedList<>();
tests.offer("LoginTest");
tests.offer("PaymentTest");
```

### 2. API Requests Queue

```java
Queue<Request> apiQueue = new LinkedList<>();
```

### 3. Parallel job scheduling

---

---

# 🚀 Stack vs Queue Comparison

## Visual Comparison

```
STACK (LIFO)               QUEUE (FIFO)

   | C |  ← pop()            Front → A B C ← Rear
   | B |                     poll() removes A
   | A |
```

---

## Table Comparison

| Feature        | Stack               | Queue                        |
| -------------- | ------------------- | ---------------------------- |
| Order          | LIFO                | FIFO                         |
| Add            | push()              | offer()                      |
| Remove         | pop()               | poll()                       |
| Peek           | peek()              | peek()                       |
| Real Use       | Undo, Back, History | Scheduling, Buffer, Requests |
| Implementation | Vector              | LinkedList/ArrayDeque        |
| Thread Safe    | Yes (Stack)         | No (LinkedList)              |
| Recommended    | ArrayDeque          | ArrayDeque                   |

---

---

# ⚡ Modern Recommendation (Interview Important)

❌ Stack (legacy)
❌ Vector

✅ Use ArrayDeque

## Stack style

```java
Deque<String> stack = new ArrayDeque<>();
stack.push("A");
stack.pop();
```

## Queue style

```java
Deque<String> queue = new ArrayDeque<>();
queue.offer("A");
queue.poll();
```

---

---

# 🎯 Interview Questions

### Q1 What is Stack?

LIFO data structure

### Q2 What is Queue?

FIFO data structure

### Q3 Difference?

Stack → last first
Queue → first first

### Q4 Why Stack is slower?

Because it extends Vector (synchronized)

### Q5 Which is better?

ArrayDeque

### Q6 Real Selenium usage?

* Window handles (Stack)
* Test execution order (Queue)

### Q7 peek vs pop?

peek → only read
pop → remove + read

---

---

# ✅ Quick Cheatsheet

## Stack

```java
push()
pop()
peek()
empty()
```

## Queue

```java
offer()
poll()
peek()
isEmpty()
```

---

# ✅ Summary

Use Stack → history/backtracking
Use Queue → scheduling/order processing
Prefer ArrayDeque in modern Java

---

END
