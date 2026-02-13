# 🔹 this() vs super() and Inheritance Rules (Java)

---

# ✅ this() vs super()

Both are used inside constructors.

| Feature | this() | super() |
|----------|----------|-----------|
| Refers to | Current class constructor | Parent class constructor |
| Used for | Constructor chaining within same class | Calling parent constructor |
| Position | Must be first statement | Must be first statement |
| Can use both together? | ❌ No | ❌ No |

---

# 🔹 Example 1 — this() (Constructor Chaining)

```java
class Employee {

    String name;
    int age;

    Employee() {
        this("Unknown", 0);
    }

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

Output:
```
Unknown 0
```

---

# 🔹 Example 2 — super()

```java
class Parent {
    Parent() {
        System.out.println("Parent Constructor");
    }
}

class Child extends Parent {
    Child() {
        super();
        System.out.println("Child Constructor");
    }
}
```

Output:
```
Parent Constructor
Child Constructor
```

---

# 🔴 Rule — Cannot use both together

```java
Child() {
    this();   // ❌
    super();  // ❌
}
```

Only ONE can be first statement.

---

# 🔹 Example 3 — this() + super() (Chaining)

```java
class Parent {
    Parent(int x) {
        System.out.println("Parent " + x);
    }
}

class Child extends Parent {

    Child() {
        this(10);
    }

    Child(int x) {
        super(x);
        System.out.println("Child " + x);
    }
}
```

Output:
```
Parent 10
Child 10
```

---

# ================================
# 🔹 Inheritance Rules (Java)
# ================================

## ✅ Basic Rules

- Java supports single inheritance only
- Child inherits public and protected members
- Private members are NOT inherited
- Constructors are NOT inherited
- Parent constructor runs first
- Method overriding enables runtime polymorphism

---

# 🔹 Example — Basic Inheritance

```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}
```

Output:
```
Animal makes sound
Dog barks
```

---

# 🔹 Example — Method Overriding

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

Output:
```
Dog barks
```

---

# 🔹 Example — Multi-Level Inheritance

```java
class A {
    A() { System.out.println("A"); }
}

class B extends A {
    B() { System.out.println("B"); }
}

class C extends B {
    C() { System.out.println("C"); }
}
```

Output:
```
A
B
C
```

---

# 🔹 Access Modifier Rules

| Modifier | Inherited? | Accessible? |
|------------|-------------|--------------|
| public | ✅ | ✅ |
| protected | ✅ | ✅ |
| default | ✅ (same package) | ✅ |
| private | ❌ | ❌ |

---

# ✅ Interview One‑Liner

👉 this() calls current class constructor, super() calls parent constructor, and inheritance allows reuse and extension of parent behavior.
