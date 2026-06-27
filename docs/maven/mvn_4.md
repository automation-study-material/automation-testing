# 📘 Maven Lifecycle Deep Dive – Phase 1

# Understanding `validate` and `compile` Phases

---

# Table of Contents

1. Introduction
2. Maven Lifecycle Recap
3. What is a Maven Phase?
4. validate Phase
5. Internal Working of validate
6. Real-World Example
7. compile Phase
8. Internal Working of compile
9. What Happens Inside the Compiler?
10. Generated Files
11. Enterprise Example
12. Complete Flow
13. Interview Questions
14. Summary

---

# Introduction

The **Default Maven Lifecycle** contains several phases.

```text
validate
    │
    ▼
compile
    │
    ▼
test
    │
    ▼
package
    │
    ▼
verify
    │
    ▼
install
    │
    ▼
deploy
```

Each phase has a specific responsibility.

One important concept is:

> **When you execute a Maven phase, Maven automatically executes all previous phases first.**

For example,

```bash
mvn compile
```

does **not** execute only the compile phase.

Internally Maven executes

```text
validate
      │
      ▼
compile
```

---

# What is a Phase?

A phase is simply a **step** in the Maven lifecycle.

Think of building a house.

```text
Foundation
     │
Walls
     │
Roof
     │
Painting
```

You cannot build the roof before building the walls.

Similarly,

```text
validate

↓

compile
```

Compilation cannot begin until validation is successful.

---

# validate Phase

## Purpose

The validate phase checks whether the project is **correctly configured** before compilation begins.

Think of it as a **pre-build inspection**.

Maven asks:

* Is the project structure valid?
* Is `pom.xml` correct?
* Are required values present?
* Can the build continue?

Only if everything looks correct does Maven move to the next phase.

---

# Why Do We Need validate?

Imagine your project:

```text
AppiumFramework

├── pom.xml
├── src
└── target
```

Suppose your `pom.xml` contains:

```xml
<artifactId></artifactId>
```

or

```xml
<version></version>
```

Would Maven start compiling?

No.

It first validates the project.

---

# Internal Working of validate

When you execute

```bash
mvn validate
```

Maven performs something similar to this.

```text
Read pom.xml
      │
      ▼
Parse XML
      │
      ▼
Check XML Syntax
      │
      ▼
Read Coordinates
      │
      ▼
Read Plugins
      │
      ▼
Read Dependencies
      │
      ▼
Build Project Model
      │
      ▼
Validation Successful
```

Only then does Maven stop because you requested only the **validate** phase.

---

# What Does validate Actually Check?

It checks many things.

### Project Structure

```text
Project

↓

pom.xml exists?

↓

Yes
```

---

### XML Syntax

Example

Correct

```xml
<project>

</project>
```

Incorrect

```xml
<project>

<dependencies>

</project>
```

Missing closing tag.

Validation fails.

---

### Coordinates

Checks

```xml
<groupId>

<artifactId>

<version>
```

These are required for a valid Maven project.

---

### Dependencies

Checks whether dependency declarations are valid.

Example

```xml
<dependency>

<groupId>org.testng</groupId>

<artifactId>testng</artifactId>

</dependency>
```

Maven verifies that the dependency declaration is structurally correct before later phases attempt to resolve it.

---

### Plugins

Checks configured plugins.

Example

```xml
<plugin>

<artifactId>maven-compiler-plugin</artifactId>

</plugin>
```

---

# Output of validate

Nothing is compiled.

Nothing is packaged.

No JAR is created.

No class files are generated.

It simply validates the project.

---

# Real-World Example

Imagine Adobe has a project.

```text
Automation Framework

↓

Developer modifies pom.xml

↓

Runs

mvn validate
```

If validation fails,

the CI pipeline stops immediately.

This saves time because Maven doesn't waste time compiling a project with an invalid configuration.

---

# compile Phase

Now comes one of the most important phases.

Purpose:

Convert Java source code into Java bytecode.

Java source

↓

`.java`

↓

Compiler

↓

`.class`

---

# Command

```bash
mvn compile
```

Remember

Internally Maven first executes

```text
validate

↓

compile
```

---

# What Happens During compile?

Suppose

```text
src/main/java

↓

DriverFactory.java

↓

WaitUtils.java

↓

ConfigReader.java
```

Maven compiles all Java source files.

---

# Internal Working

```text
Read pom.xml

      │

      ▼

Execute validate

      │

      ▼

Locate src/main/java

      │

      ▼

Read Java Files

      │

      ▼

Invoke Java Compiler (javac)

      │

      ▼

Generate .class Files

      │

      ▼

Store Inside target/classes
```

---

# Who Performs Compilation?

Many beginners think Maven itself compiles Java.

Actually,

Maven delegates this work to the **Maven Compiler Plugin**.

```text
Maven

      │

      ▼

Maven Compiler Plugin

      │

      ▼

javac

      │

      ▼

.class Files
```

The plugin internally calls the Java compiler (`javac`) provided by your JDK.

---

# Source Folder Used

```text
src

└── main

      └── java
```

Only this folder is compiled during the **compile** phase.

Notice

```text
src/test/java
```

is **NOT** compiled yet.

That happens during the **test-compile** phase, which occurs later in the lifecycle.

---

# Output Folder

Generated files go into

```text
target

└── classes
```

Example

Before

```text
DriverFactory.java
```

After

```text
target

└── classes

      └── DriverFactory.class
```

---

# Java Compilation Flow

```text
DriverFactory.java

      │

      ▼

Maven Compiler Plugin

      │

      ▼

javac

      │

      ▼

DriverFactory.class

      │

      ▼

target/classes
```

---

# Why .class Files?

The JVM cannot execute

```text
.java
```

It executes

```text
.class
```

Compilation converts human-readable Java code into JVM bytecode.

---

# What Happens if Compilation Fails?

Example

```java
public class Demo {

    public static void main(String args[]) {

        System.out.println("Hello")

    }

}
```

Missing semicolon.

Compilation stops.

No

```text
.class
```

files are generated.

No later phases execute.

---

# Files Generated

After

```bash
mvn compile
```

Example

```text
target

├── classes

│     ├── DriverFactory.class

│     ├── WaitUtils.class

│     └── ConfigReader.class

└── generated-sources
```

Notice

No

```text
.jar
```

yet.

Packaging happens later.

---

# Real Enterprise Example

Suppose your company has

```text
Automation Framework

↓

DriverFactory.java

↓

WaitUtils.java

↓

ConfigReader.java

↓

PageObjects.java
```

Developer executes

```bash
mvn compile
```

Internally

```text
Validate Project

↓

Compile Java Source

↓

Generate Bytecode

↓

Store Inside target/classes
```

Now the framework is ready for the next lifecycle phase.

---

# Difference Between validate and compile

| validate                      | compile                           |
| ----------------------------- | --------------------------------- |
| Checks project configuration  | Compiles Java source              |
| Reads `pom.xml`               | Uses Java compiler                |
| No `.class` files             | Generates `.class` files          |
| No compilation                | Compiles `src/main/java`          |
| No output in `target/classes` | Output stored in `target/classes` |

---

# Complete Flow

```text
Developer

      │

      ▼

mvn compile

      │

      ▼

Read pom.xml

      │

      ▼

validate

      │

      ▼

Locate src/main/java

      │

      ▼

Maven Compiler Plugin

      │

      ▼

javac

      │

      ▼

Generate .class Files

      │

      ▼

target/classes
```

---

# Interview Questions

## Q1. What does the validate phase do?

**Answer:**

The `validate` phase checks whether the Maven project is correctly configured before the build continues. It validates the `pom.xml`, project structure, coordinates, and configuration. It does not compile code or create any artifacts.

---

## Q2. What does the compile phase do?

**Answer:**

The `compile` phase compiles all Java source files from `src/main/java` into `.class` files and stores them in the `target/classes` directory.

---

## Q3. Which plugin performs compilation?

**Answer:**

The **Maven Compiler Plugin** performs the compilation by invoking the Java compiler (`javac`) from the installed JDK.

---

## Q4. Does `mvn compile` execute only the compile phase?

**Answer:**

No. Maven first executes the `validate` phase and, if successful, proceeds to the `compile` phase.

---

## Key Takeaways

* **`validate`** verifies that the project is correctly configured before any build work begins.
* **`compile`** converts Java source code (`.java`) from `src/main/java` into JVM bytecode (`.class`).
* The **Maven Compiler Plugin** performs compilation by calling the JDK's `javac` compiler.
* Compiled classes are stored in `target/classes`.
* If validation or compilation fails, Maven stops the build and does not continue to later phases.
* Every Maven phase automatically runs all previous phases in the lifecycle before executing the requested phase.

```
```
