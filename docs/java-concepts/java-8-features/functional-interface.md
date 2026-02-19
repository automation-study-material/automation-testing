# Functional Interfaces in Java

------------------------------------------------------------------------

## ✅ What is a Functional Interface?

A Functional Interface is:

> An interface that contains exactly one abstract method.

That's it.

------------------------------------------------------------------------

## 🔹 Simple Example

``` java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
```

✔ Only one abstract method → So it is a Functional Interface.

------------------------------------------------------------------------

## 🎯 Why Functional Interface Is Needed?

Because Lambda expression implements only one method.

Since Lambda does not mention method name:

``` java
(a, b) -> a + b
```

Java must know:

-   Which interface?
-   Which method?
-   What return type?

If interface has 1 method → No confusion\
If interface has 2 methods → Java confused 😵

------------------------------------------------------------------------

## 🔥 Important Rule

Functional Interface:

-   Must have only one abstract method
-   Can have:
    -   Multiple default methods
    -   Multiple static methods
    -   Methods from Object class (equals, toString, etc.)

------------------------------------------------------------------------

## 🧠 Example With Default Method

``` java
@FunctionalInterface
interface MyInterface {

    void sayHello();   // Only abstract method

    default void print() {
        System.out.println("Default method");
    }

    static void info() {
        System.out.println("Static method");
    }
}
```

✔ Still Functional Interface\
Because only ONE abstract method.

------------------------------------------------------------------------

## ❌ Invalid Functional Interface

``` java
interface WrongInterface {
    void method1();
    void method2();
}
```

❌ Not functional\
Because it has 2 abstract methods.

------------------------------------------------------------------------

## 📌 What is @FunctionalInterface Annotation?

It is optional but recommended.

``` java
@FunctionalInterface
interface MyInterface {
    void test();
}
```

If you accidentally add second abstract method:

``` java
void test2();
```

Compiler error ❌

So annotation ensures safety.

------------------------------------------------------------------------

# 🚀 Built-in Functional Interfaces (Very Important)

Java provides many ready-made functional interfaces in:

    java.util.function

------------------------------------------------------------------------

## 🔹 1. Predicate`<T>`{=html}

-   Takes input\
-   Returns boolean

``` java
Predicate<Integer> isEven = x -> x % 2 == 0;
System.out.println(isEven.test(4));
```

------------------------------------------------------------------------

## 🔹 2. Function\<T, R\>

-   Takes input\
-   Returns output

``` java
Function<String, Integer> length = s -> s.length();
System.out.println(length.apply("Java"));
```

------------------------------------------------------------------------

## 🔹 3. Consumer`<T>`{=html}

-   Takes input\
-   Returns nothing

``` java
Consumer<String> print = s -> System.out.println(s);
print.accept("Hello");
```

------------------------------------------------------------------------

## 🔹 4. Supplier`<T>`{=html}

-   Takes no input\
-   Returns value

``` java
Supplier<Double> random = () -> Math.random();
System.out.println(random.get());
```

------------------------------------------------------------------------

# 🔥 Real Example: Runnable

Runnable is a Functional Interface:

``` java
public interface Runnable {
    void run();
}
```

That's why Lambda works:

``` java
Runnable r = () -> System.out.println("Running");
```

------------------------------------------------------------------------

# 🧠 Internally What Happens?

When you write:

``` java
Calculator c = (a, b) -> a + b;
```

JVM:

-   Knows Calculator is functional interface
-   Knows method is add
-   Creates implementation dynamically
-   Uses invokedynamic
-   Uses LambdaMetafactory
-   No separate .class file created

------------------------------------------------------------------------

# 📊 Functional Interface vs Normal Interface

| Feature          | Functional Interface | Normal Interface  |
| ---------------- | -------------------- | ----------------- |
| Abstract Methods | Exactly 1            | 0, 1 or many      |
| Lambda Support   | Yes                  | No (if >1 method) |
| Used For         | Behavior passing     | General contract  |


