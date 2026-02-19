# Understanding How Calculator Interface Is Implemented

------------------------------------------------------------------------

Great 👍 this is the exact point where most people get confused.

You have this interface:

``` java
interface Calculator {
    int add(int a, int b);
}
```

Let's see how this interface is implemented in different ways.

------------------------------------------------------------------------

# 1️⃣ Normal Class Implementation

Here we create a class and implement the interface.

``` java
class MyCalculator implements Calculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}

public class Test {
    public static void main(String[] args) {
        Calculator c = new MyCalculator();
        System.out.println(c.add(5, 3));
    }
}
```

## What is happening?

-   `MyCalculator` implements `Calculator`
-   We override `add()`
-   We create object of `MyCalculator`

------------------------------------------------------------------------

# 2️⃣ Anonymous Class Implementation

Instead of creating separate class, we implement it directly:

``` java
public class Test {
    public static void main(String[] args) {

        Calculator c = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };

        System.out.println(c.add(5, 3));
    }
}
```

## Here:

-   No class name
-   Implemented on the spot
-   This is called **anonymous class**

------------------------------------------------------------------------

# 3️⃣ Lambda Implementation (Since It Has One Method)

Because `Calculator` has only ONE abstract method,\
it is a **Functional Interface**.

Now Lambda can implement it:

``` java
public class Test {
    public static void main(String[] args) {

        Calculator c = (a, b) -> a + b;

        System.out.println(c.add(5, 3));
    }
}
```

------------------------------------------------------------------------

# 🔥 What Exactly Happens in Lambda?

When you write:

``` java
Calculator c = (a, b) -> a + b;
```

Java understands:

-   Interface = `Calculator`
-   Only method = `add(int a, int b)`
-   So `(a, b) -> a + b` must be implementation of `add()`

Internally it is similar to:

``` java
new Calculator() {
    public int add(int a, int b) {
        return a + b;
    }
}
```

But Lambda is shorter and more efficient.

------------------------------------------------------------------------

# 🧠 Think Like This

Interface says:

> "Someone must define add method"

Lambda says:

> "Here is the implementation"

------------------------------------------------------------------------

# 📌 Important Rule

If interface had:

``` java
interface Calculator {
    int add(int a, int b);
    int subtract(int a, int b);
}
```

Then Lambda ❌ will NOT work.

Because Java wouldn't know which method to implement.

------------------------------------------------------------------------

# 🎯 Simple Final Understanding

This:

``` java
Calculator c = (a, b) -> a + b;
```

Means:

-   Create an object of `Calculator`
-   Implement `add` method
-   Return `a + b`

------------------------------------------------------------------------

End of Document
