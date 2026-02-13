# Java Constructors – From Scratch to Expert

## 🔑 What is a Constructor?
- A **constructor** is a special method in Java used to **initialize objects**.
- It has the **same name as the class**.
- It **does not have a return type**, not even `void`.
- Automatically called when an **object is created**.
- Used in combination with **OOP concepts** like encapsulation, inheritance, and polymorphism.

---

## ✅ Key Points About Constructors
1. Constructor name must **match the class name**.
2. **No return type** is allowed.
3. Can be **default, parameterized, or private**.
4. Can be **overloaded** to provide multiple ways to create objects.
5. Supports **constructor chaining** using `this()` (same class) and `super()` (parent class).
6. Can be combined with **access modifiers** to control visibility.
7. Can be **used with static blocks** for class-level initialization.

---

## Types of Constructors

### 1. Default Constructor
- Automatically provided by Java if no constructor is defined.
- No parameters and initializes objects with default values.

```java
class Test{
    String name="xyz";
    int age=55;

    public Test() {
        name = name;
        age = age;
    }
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
class Main {
    public static void main(String[] args) {
        Test obj=new Test();
        obj.displayInfo();
        obj.name="Umesh";
        obj.displayInfo();
    }
}
```
### 2.Parameterized Constructor
- Takes arguments to initialize object with specific values.

```java
class Employee {
    String name;
    int age;

    // Parameterized constructor
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 28); // Parameterized constructor called
        emp.displayInfo(); // Output: Name: Alice, Age: 28
    }
}

```

### 3.Constructor Overloading
- Multiple constructors with different parameters in the same class.
- Provides flexibility in object creation.

```java
class Employee {
    String name;
    int age;
    String company;

    // Default constructor
    public Employee() {
        this.name = "Unknown";
        this.age = 0;
        this.company = "Not Assigned";
    }

    // Parameterized constructor
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
        this.company = "Unknown";
    }

    // Parameterized constructor with all fields
    public Employee(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Company: " + company);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("Bob", 30);
        Employee e3 = new Employee("Charlie", 35, "TechCorp");

        e1.displayInfo();
        e2.displayInfo();
        e3.displayInfo();
    }
}

```

✅ Output:

```text
Name: Unknown, Age: 0, Company: Not Assigned
Name: Bob, Age: 30, Company: Unknown
Name: Charlie, Age: 35, Company: TechCorp

```
### 4.Constructor Chaining

#### a) Using this() – Within Same Class

```java
class Employee {
    String name;
    int age;
    String company;

    public Employee() {
        this("Unknown", 0, "Not Assigned"); // Call another constructor
    }

    public Employee(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    public void displayInfo() {
        System.out.println(name + ", " + age + ", " + company);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee(); // Calls default, which chains to parameterized
        e.displayInfo(); // Output: Unknown, 0, Not Assigned
    }
}

```

```java
class Employee {

    // =========================
    // Instance Variables
    // =========================
    int id;
    String name;
    int age;
    String company;
    double salary;

    // ==================================================
    // 1️⃣ DEFAULT CONSTRUCTOR (NO ARG)
    // ==================================================
    // Entry point if no data is provided
    public Employee() {
        // Calls 2-arg constructor
        this(0, "Unknown");

        System.out.println("1️⃣ Default constructor executed");
    }

    // ==================================================
    // 2️⃣ TWO-PARAMETER CONSTRUCTOR
    // ==================================================
    public Employee(int id, String name) {
        // Calls 3-arg constructor
        this(id, name, 18);

        System.out.println("2️⃣ Two-parameter constructor executed");
    }

    // ==================================================
    // 3️⃣ THREE-PARAMETER CONSTRUCTOR
    // ==================================================
    public Employee(int id, String name, int age) {
        // Calls 5-arg constructor
        this(id, name, age, "Not Assigned", 0.0);

        System.out.println("3️⃣ Three-parameter constructor executed");
    }

    // ==================================================
    // 4️⃣ FULL CONSTRUCTOR (MASTER)
    // ==================================================
    // This constructor does actual initialization
    public Employee(int id, String name, int age, String company, double salary) {

        System.out.println("4️⃣ Full constructor START");

        this.id = id;
        this.name = name;
        this.age = age;
        this.company = company;
        this.salary = salary;

        System.out.println("4️⃣ Full constructor END");
    }

    // =========================
    // Utility Method
    // =========================
    public void displayInfo() {
        System.out.println("\n📌 Employee Details");
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Company : " + company);
        System.out.println("Salary  : " + salary);
    }
}
```
Main Class calling-
```java
public class Main {
    public static void main(String[] args) {

        System.out.println("🚀 Creating Employee Object\n");

        Employee emp = new Employee();

        emp.displayInfo();
    }
}
```
```txt
🚀 Creating Employee Object

4️⃣ Full constructor START
4️⃣ Full constructor END
3️⃣ Three-parameter constructor executed
2️⃣ Two-parameter constructor executed
1️⃣ Default constructor executed

📌 Employee Details
ID      : 0
Name    : Unknown
Age     : 18
Company : Not Assigned
Salary  : 0.0
🔷 Execution Flow (THIS IS KEY 🧠)
When you do:

Employee emp = new Employee();
Call chain:
Employee()
   ↓ this(0, "Unknown")
Employee(int, String)
   ↓ this(id, name, 18)
Employee(int, String, int)
   ↓ this(id, name, age, "Not Assigned", 0.0)
Employee(int, String, int, String, double)
Execution order (reverse):
4️⃣ Full constructor
3️⃣ Three-param constructor
2️⃣ Two-param constructor
1️⃣ Default constructor
```
#### b) Using super() – Calling Parent Class Constructor

```java
class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Manager extends Employee {
    String department;

    public Manager(String name, int age, String department) {
        super(name, age); // Call superclass constructor
        this.department = department;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Manager mgr = new Manager("Alice", 35, "IT");
        mgr.displayInfo();
    }
}

```
Output:
```text
Name: Alice, Age: 35
Department: IT
```
### 5.Private Constructor
- Restricts object creation outside the class.
- Used in Singleton Design Pattern.

```java
class Singleton {
    private static Singleton instance;
    private Singleton() {} // Private constructor

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton instance");
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        s1.showMessage();
    }
}

```
#### Validate Code
```java
public class Main {
    public static void main(String[] args) {

        SingleTonePattern s1 = SingleTonePattern.getInstance();
        SingleTonePattern s2 = SingleTonePattern.getInstance();

        System.out.println(s1 == s2); // true
    }
}
```

### 6.Static Blocks vs Constructor
- Static blocks execute once when class loads.
- Constructor executes each time object is created.

```java
class Demo {
    static {
        System.out.println("Static block executed");
    }

    public Demo() {
        System.out.println("Constructor executed");
    }
}

public class Main {
    public static void main(String[] args) {
        Demo d1 = new Demo(); // Static block runs once, constructor runs every object
        Demo d2 = new Demo();
    }
}

```
## Key Takeaways
#### 1.Constructors & OOP
- Works with encapsulation (initialize private fields).
- Works with inheritance (super() to initialize parent).
- Supports polymorphism via overloading.

#### 2.Best Practices
- Use parameterized constructors for meaningful object initialization.
- Use constructor chaining to reduce code duplication.
- Keep static members in mind when using constructors.

#### 3.Common Interview Questions
- Difference between default, parameterized, and private constructors.
- What is constructor overloading?
- How constructor chaining works with this() and super().
- Difference between static block and constructor.
- How constructors interact with inheritance and polymorphism.
