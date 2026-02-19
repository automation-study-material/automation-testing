# Abstract Class vs Interface -- Complete Guide (Java OOP)

## ✅ Abstract Class -- Implementation Rules

### Short Answer

If a class **extends an abstract class**, it must implement **ALL
abstract methods**,\
unless the child class is also declared `abstract`.

------------------------------------------------------------------------

## Example

``` java
abstract class Animal {

    abstract void eat();
    abstract void sleep();
    abstract void sound();

    void walk() {   // concrete method
        System.out.println("Animal is walking");
    }
}
```

### 📌 Here:

-   3 abstract methods → `eat()`, `sleep()`, `sound()`
-   1 concrete method → `walk()`

------------------------------------------------------------------------

## Case 1: Concrete Child Class

``` java
class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("Dog eats food");
    }

    @Override
    void sleep() {
        System.out.println("Dog sleeps");
    }

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

✅ **Rule:** You MUST implement all abstract methods.\
Otherwise, compiler error:

    Dog is not abstract and does not override abstract method...

------------------------------------------------------------------------

## Case 2: Child Class is Also Abstract

``` java
abstract class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("Dog eats food");
    }
}
```

-   Only `eat()` implemented
-   `sleep()` and `sound()` not implemented
-   Compiles because `Dog` is abstract

Next concrete class:

``` java
class Labrador extends Dog {

    @Override
    void sleep() {
        System.out.println("Labrador sleeps");
    }

    @Override
    void sound() {
        System.out.println("Labrador barks");
    }
}
```

------------------------------------------------------------------------

## Important Interview Table

 | Situation               | Must implement all abstract methods? |
| ----------------------- | ------------------------------------ |
| Child class is concrete | ✅ YES                                |
| Child class is abstract | ❌ NO                                 |

------------------------------------------------------------------------

# 📘 Interface -- Implementation Rules

## Before Java 8

``` java
interface Vehicle {
    void start();
    void stop();
}
```

-   Only abstract methods allowed
-   No method body allowed
-   All methods implicitly 
  - public
  - abstract

Implementation:

``` java
class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car starts");
    }

    @Override
    public void stop() {
        System.out.println("Car stops");
    }
}
```

✅ Must implement ALL methods.

------------------------------------------------------------------------

## After Java 8 🚀

Java 8 introduced: 
  - `default` methods
  - - `static` methods

``` java
interface Vehicle {

    void start();
    void stop();

    default void fuelType() {
        System.out.println("Petrol or Diesel");
    }

    static void category() {
        System.out.println("Transport Vehicle");
    }
}
```
## 📌 Important:
-   Must implement abstract methods
-   Default methods are optional
-   Static methods are called using interface name:

``` java
Vehicle.category();
```

------------------------------------------------------------------------

## After Java 9

-   Private methods allowed inside interfaces (for internal use)

------------------------------------------------------------------------

# Abstract Class vs Interface Comparison

  | Feature              | Abstract Class | Interface (Before Java 8)  | Interface (After Java 8)  |
| -------------------- | -------------- | -------------------------- | ------------------------- |
| Abstract methods     | ✅ Yes          | ✅ Yes                      | ✅ Yes                     |
| Concrete methods     | ✅ Yes          | ❌ No                       | ✅ Default methods         |
| Multiple inheritance | ❌ No           | ✅ Yes                      | ✅ Yes                     |
| Constructors         | ✅ Yes          | ❌ No                       | ❌ No                      |
| Instance variables   | ✅ Yes          | ❌ Only public static final | ❌ Only constants          |
| Access modifiers     | Any            | Public only                | Public / Private (Java 9) |


# Final Concept

-   **Abstract Class = Partial blueprint**
-   **Interface = Contract (with optional default behavior after Java
    8)**
