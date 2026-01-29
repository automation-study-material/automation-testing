# Abstraction in Java (Abstract Class & Interface – Complete Interview Guide)

---

## 🔷 What is Abstraction?

**Abstraction** is the process of hiding implementation details and exposing only essential behavior.

> It focuses on **what an object does**, not **how it does it**.

---

## 🔷 How Java Supports Abstraction

Java provides abstraction using:
1. **Abstract Classes**
2. **Interfaces**

---

## 🔷 Abstract Class – Core Concept

```java
abstract class Vehicle {
    abstract void start();   // abstract method

    void stop() {            // concrete method
        System.out.println("Vehicle stopped");
    }
}
```

### Key Points
- Cannot be instantiated
- Can contain abstract + concrete methods
- Can have variables and constructors

---

## 🔷 Abstract Class Constructor (Important)

Abstract classes **DO have constructors**.

```java
abstract class Vehicle {
    Vehicle() {
        System.out.println("Vehicle constructor");
    }
}

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

👉 Constructor is used to initialize **common state**.

---

## 🔷 JVM / Backend Working (Must-Know)

```java
Vehicle v = new Car();
v.start();
```

### Compile Time
- Reference type (`Vehicle`) is checked
- Method existence verified

### Runtime
- JVM identifies actual object (`Car`)
- Calls overridden method using **Dynamic Method Dispatch**

➡️ This is **Runtime Polymorphism**

---

## 🔷 Abstraction + Method Overriding

### Concept
Overriding enables abstraction by forcing subclasses to provide specific behavior.

```java
abstract class Shape {
    abstract void draw();
}
```

```java
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}
```

```java
Shape s = new Circle();
s.draw(); // Drawing Circle
```

### Interview Line
> Abstraction is implemented using method overriding at runtime.

---

## 🔷 Abstraction + Method Overloading (Important Difference)

### Overloading happens at **compile time**
- Same method name
- Different parameters

```java
abstract class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

👉 Overloading **does NOT achieve abstraction**
- It is **compile-time polymorphism**
- Method selection based on reference type

---

## 🔷 Abstract Class vs Interface (Deep Comparison)

| Feature | Abstract Class | Interface |
|------|---------------|----------|
| Keyword | abstract class | interface |
| Multiple inheritance | ❌ No | ✔️ Yes |
| Constructors | ✔️ Yes | ❌ No |
| Variables | Any type | public static final |
| Methods | Abstract + concrete | Abstract, default, static |
| State | ✔️ Can maintain | ❌ Cannot |
| Use case | Base class with code | Pure contract |

---

## 🔷 How Interface Achieves Abstraction

```java
interface Payment {
    void pay();
}
```

```java
class UpiPayment implements Payment {
    public void pay() {
        System.out.println("Paying via UPI");
    }
}
```

```java
Payment p = new UpiPayment();
p.pay();
```

👉 Interface provides **100% abstraction** (before Java 8)

---

## 🔷 Abstract Class Implementing Interface

```java
interface Flyable {
    void fly();
}
```

```java
abstract class Bird implements Flyable {
    // may skip implementation
}
```

```java
class Sparrow extends Bird {
    public void fly() {
        System.out.println("Sparrow flying");
    }
}
```

---

## 🔷 Real-Time Interview Questions (With Theory + Code)

---

### Q1. Why can’t abstract class be instantiated?

**Theory:**  
Because it may contain unimplemented methods.

```java
abstract class A {
    abstract void m1();
}
```

```java
A a = new A(); // Compile-time error
```

---

### Q2. Can abstract class have zero abstract methods?

✔️ Yes – used to prevent instantiation.

```java
abstract class Utility {
    void log() {
        System.out.println("Logging");
    }
}
```

---

### Q3. Can constructor be abstract?

❌ No – constructors cannot be overridden.

---

### Q4. What happens if child does not implement abstract method?

❌ Compile-time error (unless child is abstract).

```java
abstract class A {
    abstract void m1();
}

class B extends A { } // Error
```

---

### Q5. Can abstract class have static methods?

✔️ Yes  
❌ Static methods cannot be abstract.

---

### Q6. Difference between abstraction and encapsulation?

| Abstraction | Encapsulation |
|-----------|---------------|
| Hides implementation | Hides data |
| Achieved using abstract/interface | Achieved using private fields |
| Design level | Implementation level |

---

### Q7. Which is preferred in real projects – interface or abstract class?

**Answer:**
- Use **interface** for APIs and contracts
- Use **abstract class** for base implementations

(Spring heavily uses interfaces)

---

### Q8. Is abstraction compile-time or runtime?

✔️ Runtime  
(Abstract methods are resolved at runtime using overriding)

---

## 🔷 Common Interview Traps

### Trap 1
```java
abstract class A {
    abstract void m1();
}

class B extends A {
}
```
❌ Compile error  
✔️ Fix: Implement method or make class abstract

---

### Trap 2
```java
abstract class Test {
    abstract static void run(); // ❌ Invalid
}
```

---

## 🔷 One-Line Interview Definitions

- **Abstraction:** Hiding implementation details and exposing behavior
- **Abstract Class:** Partial abstraction with base implementation
- **Interface:** Full abstraction and contract definition

---

## ✅ End of Complete Abstraction Notes
