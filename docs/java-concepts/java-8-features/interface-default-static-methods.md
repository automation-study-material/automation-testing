# Java 8 -- Default Methods and Static Methods in Interfaces

Before Java 8, interfaces were very limited. Java 8 introduced:

-   ✅ Default Methods in Interfaces
-   ✅ Static Methods in Interfaces

Let's understand from scratch.

------------------------------------------------------------------------

## 🔹 1️⃣ Before Java 8 -- What Was the Problem?

Before Java 8:

Interfaces could only have:

-   Abstract methods\
-   Public static final variables (constants)

### Example (Java 7 style):

``` java
interface Animal {
    void makeSound();  // abstract method
}
```

👉 If we later add a new method to `Animal`, all implementing classes
will break.

That was the main problem.

Java 8 solved this using default methods.

------------------------------------------------------------------------

## 🔹 2️⃣ Default Methods in Interfaces (Java 8)

### ✅ What is a Default Method?

A default method is a method inside an interface that has a body.

It uses the keyword `default`.

### ✅ Why It Was Introduced?

-   Adding new methods to interfaces\
-   Without breaking existing implementations\
-   To support Lambda expressions & Stream API internally

### ✅ Syntax

``` java
interface Animal {

    void makeSound();  // abstract method

    default void sleep() {
        System.out.println("Animal is sleeping");
    }
}
```

### ✅ Implementation

``` java
class Dog implements Animal {

    public void makeSound() {
        System.out.println("Dog barks");
    }
}
```

### Main Method

``` java
public class Main {
    public static void main(String[] args) {

        Dog d = new Dog();
        d.makeSound();  // implemented method
        d.sleep();      // default method from interface
    }
}
```

### Output

    Dog barks
    Animal is sleeping

### ✅ Can We Override Default Method?

Yes ✔

``` java
class Dog implements Animal {

    public void makeSound() {
        System.out.println("Dog barks");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleeps in kennel");
    }
}
```

👉 Default method behaves like a normal inherited method.

------------------------------------------------------------------------

## 🔥 What If Two Interfaces Have Same Default Method?

``` java
interface A {
    default void show() {
        System.out.println("A show");
    }
}

interface B {
    default void show() {
        System.out.println("B show");
    }
}

class Test implements A, B {
}
```

❌ Compilation Error:

    class inherits unrelated defaults for show()

### ✅ Solution

You MUST override it:

``` java
class Test implements A, B {

    @Override
    public void show() {
        A.super.show();  // or B.super.show();
    }
}
```

------------------------------------------------------------------------

## 🔹 3️⃣ Static Methods in Interfaces (Java 8)

Java 8 also allowed static methods inside interface.

### ✅ Why Static Methods?

-   To keep utility/helper methods inside interface\
-   Related functionality stays inside interface\
-   No need for separate utility class

### ✅ Syntax

``` java
interface Calculator {

    static int add(int a, int b) {
        return a + b;
    }
}
```

### ✅ How To Call Static Method?

⚠ Important:

Static methods in interface cannot be called using object.

They must be called using interface name.

``` java
public class Main {
    public static void main(String[] args) {

        int result = Calculator.add(10, 20);
        System.out.println(result);
    }
}
```

### Output

    30

### ❌ This is NOT allowed:

``` java
Calculator c = new Calculator(); // Not allowed
c.add(10, 20); // Not allowed
```

------------------------------------------------------------------------

## 🔥 Default vs Static Method (Important Interview Table)

| Feature                         | Default Method | Static Method |
|----------------------------------|---------------|--------------|
| Has body?                        | ✅ Yes        | ✅ Yes       |
| Can be overridden?               | ✅ Yes        | ❌ No        |
| Called using object?             | ✅ Yes        | ❌ No        |
| Called using interface name?     | ❌ No         | ✅ Yes       |
| Inherited by class?              | ✅ Yes        | ❌ No        |

------------------------------------------------------------------------

## 🔹 Real World Example (Java 8 Stream API)

Java 8 internally uses default methods in:

-   `Collection` interface
    -   `stream()`\
    -   `forEach()`

These were added without breaking old implementations.

------------------------------------------------------------------------

## 🔹 Internal Concept (Very Important)

### How Java Allows Method Body in Interface?

**Before Java 8:**

-   Interface methods were implicitly `public abstract`

**After Java 8:**

-   Default methods are compiled like instance methods\
-   JVM treats them differently from abstract methods\
-   They do not break binary compatibility

------------------------------------------------------------------------

## 🔥 Interview Questions

1️⃣ Why default method introduced?\
→ To maintain backward compatibility.

2️⃣ Can interface have constructor?\
→ ❌ No

3️⃣ Can default method be private?\
→ Java 9 introduced private methods in interface.

4️⃣ Can we make default method final?\
→ ❌ No

5️⃣ Can static method be overridden?\
→ ❌ No (because static belongs to interface, not object)

------------------------------------------------------------------------

## 🔹 Summary

### Default Method

-   Has body\
-   Inherited\
-   Can override\
-   Solves backward compatibility

### Static Method

-   Has body\
-   Not inherited\
-   Called using interface name\
-   Used for utility logic
