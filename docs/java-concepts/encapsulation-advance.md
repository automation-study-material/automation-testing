# Encapsulation in Java – Advanced Example

## Key Points of Encapsulation
- Wrap data and methods in a class.
- Hide fields using access modifiers (`private`, `default`, `protected`, `public`).
- Provide controlled access using getters/setters.
- Static variables can also be encapsulated (class-level data).
- Validation logic can be added in setters.

---

## Access Modifiers in Encapsulation

| Modifier   | Access Level                                       | Encapsulation Use Case                                  |
|------------|--------------------------------------------------|--------------------------------------------------------|
| private    | Only within the class                            | Most common for encapsulation                          |
| default    | Within the same package                          | Less common, package-level control                     |
| protected  | Within package + subclasses (even in different package) | For inheritance-based encapsulation                    |
| public     | Anywhere                                         | Usually avoid for fields, used for methods/getters     |

---

## Complex Encapsulation Example

```java
package com.example.encapsulation;

// Employee class demonstrating encapsulation
public class Employee {

    // Private instance variables (best practice)
    private String name;
    private int age;
    
    // Protected variable (accessible in subclasses)
    protected String department;
    
    // Default access variable (accessible in same package)
    String project;

    // Public variable (less recommended)
    public String company;

    // Static variable (class-level, shared across objects)
    private static int employeeCount = 0;

    // Constructor
    public Employee(String name, int age, String department, String project, String company) {
        setName(name);       // Using setter for validation
        setAge(age);         // Using setter for validation
        this.department = department;
        this.project = project;
        this.company = company;

        employeeCount++;     // Increment static count
    }

    // ----------------------
    // Getters & Setters
    // ----------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            System.out.println("Invalid name!");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 18 || age > 65) {
            System.out.println("Age must be between 18 and 65");
        } else {
            this.age = age;
        }
    }

    // Getter for static variable
    public static int getEmployeeCount() {
        return employeeCount;
    }

    // No setter for employeeCount (read-only) to protect encapsulation

    // Method to display info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Project: " + project);
        System.out.println("Company: " + company);
        System.out.println("Total Employees: " + employeeCount);
    }
}
```

# Testing the Encapsulation in Java

## Main Class Example

```java
package com.example.encapsulation;

public class Main {
    public static void main(String[] args) {
        // Create employee objects
        Employee emp1 = new Employee("Alice", 25, "IT", "Automation", "TechCorp");
        Employee emp2 = new Employee("Bob", 30, "HR", "Recruitment", "TechCorp");

        // Accessing fields through getters and setters
        System.out.println("Employee 1 Name: " + emp1.getName());
        emp1.setAge(17);  // Invalid age, setter validation triggers
        emp1.setAge(28);  // Valid

        // Accessing protected, default, and public variables directly
        System.out.println("Employee 1 Department: " + emp1.department); // Protected
        System.out.println("Employee 1 Project: " + emp1.project);       // Default
        System.out.println("Employee 1 Company: " + emp1.company);       // Public

        // Display info
        emp1.displayInfo();
        emp2.displayInfo();

        // Access static variable
        System.out.println("Total employees: " + Employee.getEmployeeCount());
    }
}
```
## ✅ What This Example Shows

### Private Variables + Getter/Setter
- Encapsulated `name` and `age` with **validation in setter**.
- Prevents illegal data entry (core principle of encapsulation).

### Static Variable
- `employeeCount` is **class-level**.
- Getter allows **controlled read access**; no setter keeps it **read-only**.

### Access Modifiers
- `private` → fully hidden.  
- `protected` → accessible in subclass (good for inheritance scenarios).  
- `default` → accessible in same package (package-level encapsulation).  
- `public` → accessible everywhere (should avoid for fields; use for methods instead).

### Encapsulation + OOP
- Combines **data hiding, validation, and controlled access**.
- Prepares your code for **safe inheritance and reuse**.

---

💡 **Interview Tip:**  
A complex encapsulation question might ask:  

> “Can you make a static variable private and expose it via getter? Can you combine all access modifiers in one class?”
