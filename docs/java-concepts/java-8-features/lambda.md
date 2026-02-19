# Lambda Expressions in Java (Beginner to Advanced Guide)

------------------------------------------------------------------------

# 1. Introduction

Lambda Expressions were introduced in **Java 8** to support functional
programming.

A Lambda Expression is: \> A short way to implement a functional
interface (an interface with exactly one abstract method).

------------------------------------------------------------------------

# 2. Why Lambda Was Introduced

Before Java 8, we used Anonymous Classes to pass behavior.

Example (Before Java 8):

``` java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};
```

With Lambda:

``` java
Runnable r = () -> System.out.println("Hello");
```

Less code, better readability.

------------------------------------------------------------------------

# 3. Basic Syntax

    (parameters) -> { body }

Examples:

No parameter:

``` java
() -> System.out.println("Hello");
```

One parameter:

``` java
x -> System.out.println(x);
```

Multiple parameters:

``` java
(a, b) -> a + b;
```

------------------------------------------------------------------------

# 4. Functional Interface

A Functional Interface contains exactly one abstract method.

Example:

``` java
@FunctionalInterface
interface MyInterface {
    void sayHello();
}
```

Why only one? Because Lambda does not specify method name --- Java must
know which method to implement.

------------------------------------------------------------------------

# 5. Normal Method vs Anonymous Class vs Lambda

## Normal Method

``` java
public static void sayHello() {
    System.out.println("Hello");
}
```

## Anonymous Class

``` java
MyInterface obj = new MyInterface() {
    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
};
```

## Lambda

``` java
MyInterface obj = () -> System.out.println("Hello");
```

------------------------------------------------------------------------

# 6. Lambda with Parameters

Interface:

``` java
interface Calculator {
    int add(int a, int b);
}
```

Lambda:

``` java
Calculator c = (a, b) -> a + b;
System.out.println(c.add(5, 3));
```

------------------------------------------------------------------------

# 7. Built-in Functional Interfaces (java.util.function)

## Predicate`<T>`{=html}

Takes input and returns boolean.

``` java
Predicate<Integer> isEven = x -> x % 2 == 0;
```

## Function\<T, R\>

Takes input and returns output.

``` java
Function<String, Integer> length = s -> s.length();
```

## Consumer`<T>`{=html}

Takes input, returns nothing.

``` java
Consumer<String> print = s -> System.out.println(s);
```

## Supplier`<T>`{=html}

Takes no input, returns value.

``` java
Supplier<Double> random = () -> Math.random();
```

------------------------------------------------------------------------

# 8. Lambda with Collections

Sorting example:

``` java
List<Integer> list = Arrays.asList(5, 2, 9);

list.sort((a, b) -> a - b);
```

------------------------------------------------------------------------

# 9. Lambda with Streams

``` java
List<Integer> list = Arrays.asList(1,2,3,4,5);

list.stream()
    .filter(x -> x % 2 == 0)
    .forEach(System.out::println);
```

------------------------------------------------------------------------

# 10. Method References

Lambda:

``` java
x -> System.out.println(x);
```

Method Reference:

``` java
System.out::println;
```

Types: - Static method reference - Instance method reference -
Constructor reference

------------------------------------------------------------------------

# 11. Effectively Final Variables

Lambda can access local variables only if they are: - Final -
Effectively final

Example:

``` java
int x = 10;
Runnable r = () -> System.out.println(x);
```

------------------------------------------------------------------------

# 12. Lambda vs Anonymous Class

  Feature        Anonymous Class         Lambda
  -------------- ----------------------- -----------------------
  Syntax         Verbose                 Short
  this keyword   Refers to inner class   Refers to outer class
  Performance    Creates class           Uses invokedynamic
  Readability    Low                     High

------------------------------------------------------------------------

# 13. How Lambda Works Internally (Advanced)

When you write:

``` java
(a, b) -> a + b;
```

JVM: 1. Creates private synthetic method 2. Uses invokedynamic bytecode
instruction 3. Uses LambdaMetafactory 4. Creates functional interface
instance at runtime

It does NOT create a separate class like anonymous class.

------------------------------------------------------------------------

# 14. Real-World Use Cases

-   Stream API
-   Sorting collections
-   Filtering data
-   Multithreading (Runnable)
-   CompletableFuture
-   Event handling

------------------------------------------------------------------------

# 15. Interview Questions

1.  Can Lambda work without Functional Interface? → No\
2.  Can Lambda access local variables? → Yes (effectively final)\
3.  Is Lambda faster than anonymous class? → Yes (lighter at runtime)\
4.  Can interface have default methods? → Yes (but only one abstract
    method allowed)

------------------------------------------------------------------------

# 16. Practice Exercises

1.  Sort employee list by salary using Lambda.
2.  Filter names starting with 'A'.
3.  Create custom functional interface and implement with Lambda.
4.  Use Lambda with Comparator.

------------------------------------------------------------------------

# Final Summary

Lambda = Implementation of single abstract method

Lambda is: - Short - Clean - Functional style programming support - Used
heavily with Stream API

------------------------------------------------------------------------

End of Guide
