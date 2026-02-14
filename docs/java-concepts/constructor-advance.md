# Java Constructor – Interview Questions with Theory and OOP Concepts

## 1. What is a constructor in Java?
- **Answer:**  
  A constructor is a special method used to **initialize objects**.  
  - Name **must match the class name**.  
  - **No return type** (not even void).  
  - Automatically called when an object is created.  

- **OOP Concept:** Encapsulation – Constructors help **initialize private fields safely** using setters/getters.  

- **Example:**
```java
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) { // Parameterized constructor
        this.name = name;
        this.age = age;
    }
}
```
## 2. What are the types of constructors in Java?

- **Answer:**
  - Default constructor – No parameters, auto-created by Java if none exists.
  - Parameterized constructor – Accepts arguments to initialize objects.
  - Private constructor – Restricts instantiation, used in Singleton pattern.
  - Copy constructor – Initializes object using another object.
- OOP Concept: Supports encapsulation, constructor overloading, and reusability.
- Example (Parameterized & Default):
  
```java
  class Employee {
    private String name;
    private int age;

    // Default constructor
    public Employee() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized constructor
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```
## 3. What is constructor overloading?

- **Answer:**
  - Having multiple constructors in a class with different parameter lists.
  - Provides flexibility in object creation.
 
- OOP Concept: Supports polymorphism at compile time (compile-time polymorphism).
- Example:
```js
class Employee {
    String name;
    int age;

    public Employee() {
      this("Unknown", 0);
    }
    public Employee(String name) {
      this(name, 0);
    }

    public Employee(String name, int age) { 
        this.name = name;        this.age = age;
    }
}
```


## 4.Explain constructor chaining.

- **Answer:**
  - this() → Call another constructor in the same class.
    - super() → Call constructor of parent class.
    - Rules: Must be the first statement in the constructor.
- OOP Concept: Inheritance – super() ensures parent class fields are initialized.
- Example:

```js
class Abc {
	public Abc() {
		System.out.println("ABC constructor - Abc"); //1
	}
}

class Xyz extends Abc {
	public Xyz() {
		this(2);
		System.out.println("Xyz constructor - Xyz"); //3
	}
	
	public Xyz(int a) {
		System.out.println("Xyz Parametrized constructor - Xyz");	//2
	}
}

public class TestClass2  {
	public static void main(String[] args) {
		Xyz Xyz1 = new Xyz();    
	}
}
```

## 5. Can constructors be static?
- **Answer:**
  - No. Constructors cannot be static.
  - Reason: Static belongs to class, constructor belongs to object creation.
  - Interview answer
    - 👉 Constructors cannot be static because static members belong to the class, while constructors are used to create and initialize objects.
- OOP Concept: Encapsulation + Class vs Object – Constructors are object-level initialization, not class-level.


## 6. What is a private constructor?
- **Answer:**
  - Restricts object creation outside the class.
  - Used in Singleton pattern to ensure only one instance exists.
- OOP Concept: Encapsulation + Design Pattern – Controls object creation.
Example:
```java
class Singleton {
    private static Singleton instance;
    private Singleton() {} // Private constructor
    public static Singleton getInstance() {
        if(instance == null) instance = new Singleton();
        return instance;
    }
}
```
## 7. What is the difference between constructor and method?

| Feature      | Constructor            | Method                     |
|--------------|----------------------|----------------------------|
| Name         | Same as class         | Any valid name             |
| Return type  | None                  | Must have return type (void or type) |
| Purpose      | Initialize objects    | Perform actions or logic   |
| Call         | Automatically at object creation | Explicitly called  |
| Overridable  | No                    | Yes (can be overridden in subclass) |

## 8. How do static variables interact with constructors?

- **Answer:**
  - Static variables are class-level, shared across all objects.
  - Constructors can increment or modify static variables for each object creation.
- OOP Concept: Encapsulation + Class-level state
- Example:
  
```java
class Employee {
    private String name;
    private static int count = 0;

    public Employee(String name) {
        this.name = name;
        count++;
    }

    public static void showCount() {
        System.out.println("Total Employees: " + count);
    }
}
```
## 9. Can constructors be inherited or overridden?
- **Answer:**
  - Constructors are not inherited.
  - Cannot be overridden, but can be called using super() in subclass.
- OOP Concept: Inheritance – super() ensures proper parent class initialization.

✅ Constructor Chaining Example (Summary)

```java
class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child constructor");
    }
}

public class Test {
    public static void main(String[] args) {

        new Child();   // object creation

    }
}
```
✅ Output
```text
Parent constructor
Child constructor
```

✅ What happens?
- Parent constructor runs first → super()
- Then Child constructor runs
- This is constructor chaining, not overriding

## 10. How are constructors related to encapsulation, inheritance, and polymorphism?
- Encapsulation: Initialize private fields safely via constructor.
- Inheritance: Use super() to initialize parent class fields.
- Polymorphism: Constructor overloading is compile-time polymorphism.
- Abstraction: Abstract classes can have constructors to initialize shared fields.
- Example:
``` java
abstract class Person {
    protected String name;
    public Person(String name) { this.name = name; }
}

class Employee extends Person {
    private int age;
    public Employee(String name, int age) {
        super(name); // Abstract class constructor
        this.age = age;
    }
}
```
