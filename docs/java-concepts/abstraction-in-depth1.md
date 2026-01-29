# Abstraction in Java (Abstract Class – From Scratch to Interview Ready)

---

## 🔷 What is Abstraction?

**Abstraction** is the process of hiding implementation details and exposing only essential behavior.

> Focuses on **what an object does**, not **how it does it**.

### Real‑world example
- Driving a car: You use steering, brake, accelerator
- You don’t care how the engine or gearbox works

---

## 🔷 How Java Supports Abstraction

Java supports abstraction using:
1. **Abstract Classes**
2. **Interfaces**

This document focuses on **Abstract Classes**.

---

## 🔷 What is an Abstract Class?

```java
abstract class Vehicle {
    abstract void start();   // abstract method
    void stop() {             // concrete method
        System.out.println("Vehicle stopped");
    }
}
```

### Key characteristics
- Declared using `abstract` keyword
- **Cannot be instantiated**
- Can contain:
  - Abstract methods
  - Concrete methods
  - Variables
  - Constructors

---

## 🔷 Why Do We Need Abstract Classes?

Without abstraction:

```java
class Car {
    void start() {
        System.out.println("Car starts with key");
    }
}

class Bike {
    void start() {
        System.out.println("Bike starts with kick");
    }
}
```

Problems:
- No common contract
- No guarantee that all vehicles implement `start()`

With abstraction:

```java
abstract class Vehicle {
    abstract void start();
}
```

---

## 🔷 Abstract Method

```java
abstract void start();
```

- Has no body
- Ends with semicolon
- Must be implemented by child class

---

## 🔷 Implementing Abstract Class

```java
class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts with key");
    }
}

class Bike extends Vehicle {
    @Override
    void start() {
        System.out.println("Bike starts with kick");
    }
}
```

---

## 🔷 Object Creation with Abstract Class

❌ Not allowed:
```java
Vehicle v = new Vehicle(); // Compile-time error
```

✔️ Allowed:
```java
Vehicle v = new Car();
v.start();
```

This enables **runtime polymorphism**.

---

## 🔷 Backend / JVM Working (Very Important)

```java
Vehicle v = new Car();
v.start();
```

### Compile Time
- Compiler checks reference type (`Vehicle`)
- Ensures `start()` exists

### Runtime
- JVM checks actual object (`Car`)
- Calls `Car.start()` using **dynamic method dispatch**

➡️ This is **late binding**

---

## 🔷 Abstract Class Constructor (Important Concept)

### Abstract classes **DO have constructors**

```java
abstract class Vehicle {
    Vehicle() {
        System.out.println("Vehicle constructor");
    }
}
```

```java
class Car extends Vehicle {
    Car() {
        System.out.println("Car constructor");
    }
}
```

```java
Vehicle v = new Car();
```

### Output
```
Vehicle constructor
Car constructor
```

### Explanation
- Abstract class constructor runs when child object is created
- Used to initialize common state

---

## 🔷 Parameterized Constructor in Abstract Class

```java
abstract class Vehicle {
    int speed;
    Vehicle(int speed) {
        this.speed = speed;
    }
}
```

```java
class Car extends Vehicle {
    Car() {
        super(120);
    }
}
```

---

## 🔷 Variables in Abstract Class

```java
abstract class Vehicle {
    int speed = 60;
}
```

- Variables are inherited by child classes

---

## 🔷 Can Abstract Class Have main()?

✔️ Yes

```java
abstract class Test {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

---

## 🔷 Static Methods in Abstract Class

✔️ Allowed  
❌ Static methods cannot be abstract

Reason: Static methods cannot be overridden.

---

## 🔷 Abstract Class vs Interface (Quick Comparison)

| Feature | Abstract Class | Interface |
|------|---------------|-----------|
| Multiple inheritance | ❌ No | ✔️ Yes |
| Constructor | ✔️ Yes | ❌ No |
| Methods | Abstract + concrete | Abstract, default, static |
| Variables | Any type | public static final |
| Speed | Faster | Slightly slower |

---

## 🔷 When to Use Abstract Class?

Use abstract class when:
- Classes are closely related
- You want base implementation
- You want shared code

Examples:
- Vehicle
- Bank
- Employee

---

## 🔷 Real‑Time Example (Bank)

```java
abstract class Bank {
    abstract double getInterestRate();
    void display() {
        System.out.println("Welcome to Bank");
    }
}
```

```java
class SBI extends Bank {
    double getInterestRate() {
        return 6.5;
    }
}

class HDFC extends Bank {
    double getInterestRate() {
        return 7.0;
    }
}
```

---

## 🔷 Common Interview Questions

### 1. Why can’t we create object of abstract class?
Because it may contain unimplemented methods.

---

### 2. Can abstract class have zero abstract methods?
✔️ Yes (used to prevent instantiation)

---

### 3. Can abstract class have constructor?
✔️ Yes

---

### 4. Can abstract class implement interface?
✔️ Yes

---

### 5. What if child doesn’t implement abstract method?
Compile‑time error (unless child is abstract)

---

### 6. Can constructor be abstract?
❌ No

---

### 7. Can abstract class be final?
❌ No

---

### 8. Can we override non‑abstract methods?
✔️ Yes

---

## 🔷 Common Interview Traps

```java
abstract class A {
    abstract void m1();
}

class B extends A {
}
```

❌ Compile‑time error  
✔️ Fix: Make class `B` abstract or implement `m1()`

---

## 🔷 One‑Line Interview Definition

> Abstraction is the process of hiding implementation details and exposing only essential functionality using abstract classes or interfaces.

---

## ✅ End of Notes
