

# 1️⃣ Can We Create Instance of Abstract Class?

❌ **Not allowed**

Example:

```java
abstract class Animal {
}

public class Test {
    public static void main(String[] args) {
        Animal a = new Animal();   // Compile-time error
    }
}
```

Error:

```text
Animal is abstract; cannot be instantiated
```

Reason:

Abstract classes may contain **abstract methods (methods without body)**, so Java does not allow creating objects directly.

---

# 2️⃣ Why Abstract Class Can Have Constructor?

Even though we **cannot instantiate an abstract class**, its constructor is used to **initialize common fields when a subclass object is created**.

Example:

```java
abstract class Animal {

    public Animal() {
        System.out.println("Animal constructor called");
    }
}

class Dog extends Animal {

    public Dog() {
        System.out.println("Dog constructor called");
    }
}

public class Test {
    public static void main(String[] args) {
        Dog d = new Dog();
    }
}
```

---

# 3️⃣ Execution Flow

When we create:

```java
Dog d = new Dog();
```

Java does:

```text
Dog constructor
   ↓
super()
   ↓
Animal constructor
```

---

# 4️⃣ Output

```text
Animal constructor called
Dog constructor called
```

Because **parent constructor always runs first**.

---

# 5️⃣ Real Use Case

Abstract classes are used when we want to **initialize common properties**.

Example:

```java
abstract class Vehicle {

    String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }
}

class Car extends Vehicle {

    public Car() {
        super("Toyota");
    }
}
```

Here constructor initializes **shared data**.

---

# 6️⃣ Interview Answer (Best Short Answer)

* We **cannot create an instance of an abstract class** because it may contain **abstract methods without implementation**.
* However, **abstract classes can have constructors**.
* These constructors are called **when a subclass object is created**, allowing initialization of shared fields.

Example:

```java
abstract class A {
    public A() {
        System.out.println("Constructor of abstract class");
    }
}

class B extends A {
}

public class Test {
    public static void main(String[] args) {
        B obj = new B();
    }
}
```

Output:

```text
Constructor of abstract class
```

---

✅ **Key Point**

```text
Abstract class → Cannot create object
Constructor → Used by child class during object creation
```

---

If you'd like, I can also explain **one tricky interview question**:

👉 *“Can we call an abstract method inside an abstract class constructor?”*

This confuses even experienced Java developers.
