# 🔥 Understanding hashCode() in Java

## 📌 What is hashCode()?

`hashCode()` is a method from the `Object` class that returns an integer
value representing the object's identity.

It is mainly used in hashing-based collections like:

-   HashMap
-   HashSet
-   Hashtable

------------------------------------------------------------------------

## 🧠 Why is hashCode Important?

Hash-based collections use `hashCode()` to:

1.  Determine bucket location
2.  Improve search performance
3.  Support fast lookup (O(1) average time)

------------------------------------------------------------------------

## ✅ Example 1: String hashCode

``` java
String name = "Nitin";
System.out.println(name.hashCode());
```

✔ Same string always produces same hashCode.

------------------------------------------------------------------------

## ✅ Example 2: Integer hashCode

``` java
Integer num = 100;
System.out.println(num.hashCode());
```

✔ Integer hashCode is the value itself.

------------------------------------------------------------------------

## ✅ Example 3: Default Object hashCode

``` java
class Employee {
    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

Employee e1 = new Employee("Nitin", 28);
Employee e2 = new Employee("Nitin", 28);

System.out.println(e1.hashCode());
System.out.println(e2.hashCode());
```

⚠ Default hashCode is based on object identity (memory reference).
Different objects → different hashCodes.

------------------------------------------------------------------------

## ✅ Custom hashCode (Recommended)

``` java
import java.util.Objects;

@Override
public int hashCode() {
    return Objects.hash(name, age);
}
```

✔ Objects with same logical data → same hashCode.

------------------------------------------------------------------------

## 🔥 Important Rule

If you override `equals()`,\
👉 You MUST override `hashCode()`.

Otherwise HashMap and HashSet will behave incorrectly.

------------------------------------------------------------------------

## 🎯 Interview Definition

`hashCode()` returns an integer value representing an object's logical
or memory identity and is used internally by hash-based collections for
efficient storage and retrieval.
