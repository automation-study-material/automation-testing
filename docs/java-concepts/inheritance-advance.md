# Advanced Inheritance in Java with Static Methods and Constructors

## Key Points
- Subclasses inherit properties and methods from a superclass.  
- **Static variables/methods** belong to the class and can be shared across instances.  
- **Constructors** initialize objects; subclasses can call superclass constructors using `super()`.  
- **Method overriding** demonstrates runtime polymorphism.  
- **Access modifiers** control visibility (`private`, `protected`, `public`).

---

## Complex Inheritance Example

```java
package com.example.inheritance;

// Superclass
class Employee {
    protected String name;
    private int age;
    public String company;
    protected static int employeeCount = 0;

    // User-defined constructor
    public Employee(String name, int age, String company) {
        this.name = name;
        setAge(age);  // Encapsulation in action
        this.company = company;
        employeeCount++;
        System.out.println("Employee constructor called for " + name);
    }

    // Getter and Setter for private field
    public void setAge(int age) {
        if(age < 18 || age > 65) {
            System.out.println("Age must be between 18 and 65");
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    // Instance method
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Company: " + company);
    }

    // Static method
    public static void showEmployeeCount() {
        System.out.println("Total Employees: " + employeeCount);
    }
}

// Subclass
class Manager extends Employee {
    private String department;

    // Subclass constructor
    public Manager(String name, int age, String company, String department) {
        super(name, age, company); // Call superclass constructor
        this.department = department;
        System.out.println("Manager constructor called for " + name);
    }

    // Method overriding
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call superclass method
        System.out.println("Department: " + department);
    }

    // Subclass-specific method
    public void approveLeave() {
        System.out.println(name + " approved leave for the team.");
    }

    // Static method in subclass (hides superclass static method)
    public static void showEmployeeCount() {
        System.out.println("Manager count: " + employeeCount);
    }
}
```

## Testing Inheritance with Static Methods and Constructors
```java
package com.example.inheritance;

public class Main {
    public static void main(String[] args) {
        // Create Employee and Manager objects
        Employee emp1 = new Employee("Alice", 28, "TechCorp");
        Manager mgr1 = new Manager("Bob", 35, "TechCorp", "IT");

        System.out.println("\n--- Display Info ---");
        emp1.displayInfo();
        mgr1.displayInfo(); // Overridden method

        System.out.println("\n--- Approve Leave ---");
        mgr1.approveLeave();

        System.out.println("\n--- Static Methods ---");
        Employee.showEmployeeCount(); // Calls superclass static method
        Manager.showEmployeeCount();  // Calls subclass static method (hides superclass)
        
        // Access modifiers demonstration
        System.out.println("\n--- Access Modifiers ---");
        System.out.println("Manager Name (protected): " + mgr1.name);
        System.out.println("Manager Company (public): " + mgr1.company);
        // System.out.println(mgr1.age); // ❌ private, cannot access directly
    }
}
```

## ✅ What This Example Shows

### User-defined Constructors
- Superclass and subclass constructors are called in **order of inheritance**.
- `super()` ensures **proper initialization of superclass fields**.

### Static Variables and Methods
- `employeeCount` is **shared across all instances**.
- Static methods in subclasses **hide** superclass static methods, not override.

### Method Overriding
- Subclass `displayInfo()` **overrides** superclass method for **custom behavior**.
- `super.displayInfo()` can still be called inside overridden method.

### Access Modifiers
- `private` → fully hidden, accessed via getter/setter.  
- `protected` → accessible in subclass.  
- `public` → accessible everywhere.

### Encapsulation + Inheritance
- Private members remain **encapsulated**, even in subclasses.  
- Protected/public members allow **safe inheritance and reuse**.
