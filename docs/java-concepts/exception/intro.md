# 🚀 Java Exception Handling – Complete Notes

---

# ✅ What is Exception?

## Definition

An **Exception** is an unexpected event that disrupts the normal flow of a program.

Examples:

* Divide by zero
* File not found
* Null pointer access
* DB connection failure

---

---

# ✅ Exception Hierarchy (Diagram)
<img src="../../images/java/Exceptions.png" alt="Collections Framework" width="400"/>
```
Object
   ↓
Throwable
   ├── Error                  (Serious, system level)
   │     ├── OutOfMemoryError
   │     ├── StackOverflowError
   │     └── VirtualMachineError
   │
   └── Exception              (Application level)
         ├── Checked Exceptions (Compile time)
         │      ├── IOException
         │      ├── SQLException
         │      ├── FileNotFoundException
         │      └── InterruptedException
         │
         └── RuntimeException (Unchecked)
                ├── NullPointerException
                ├── ArithmeticException
                ├── ArrayIndexOutOfBoundsException
                ├── IllegalArgumentException
                └── NumberFormatException
```

---

---

# ✅ Throwable

Root class of all errors and exceptions.

Two main types:

* Error
* Exception

---

---

# 🔴 Error (Serious Problems)

## Description

System-level failures. Not meant to be handled by application code.

## Examples

* OutOfMemoryError
* StackOverflowError

## Handling?

❌ Usually NOT handled

---

---

# 🟡 Exception (Recoverable Problems)

## Description

Application-level issues that can be handled.

Two types:

* Checked
* Runtime

---

---

# ✅ Checked Exceptions (Compile-time)

## Definition

Checked by compiler. Must handle using:

* try-catch OR
* throws

## Examples

* IOException
* SQLException
* FileNotFoundException

## Example

```java
FileReader f = new FileReader("test.txt"); // compile error if not handled
```

---

---

# ✅ Runtime Exceptions (Unchecked)

## Definition

Occur during execution. Compiler does NOT force handling.

## Examples

* NullPointerException
* ArithmeticException
* IndexOutOfBoundsException

## Example

```java
int a = 10 / 0; // runtime crash
```

---

---

# 🔥 Checked vs Runtime (Interview Table)

| Feature           | Checked         | Runtime         |
| ----------------- | --------------- | --------------- |
| Checked by        | Compiler        | JVM             |
| Handling required | Yes             | No              |
| Occurs            | Compile time    | Runtime         |
| Cause             | External issues | Coding mistakes |
| Example           | IOException     | NullPointer     |

---

### Easy Memory

```
Checked → outside problems (file/db/network)
Runtime → coding mistakes
```

---

---

# ✅ try-catch-finally

---

## Basic Syntax

```java
try {
   risky code
}
catch(Exception e){
   handle
}
finally{
   cleanup
}
```

---

---

# ✅ try Block

Contains code that may throw exception.

```java
try {
    int a = 10/0;
}
```

---

---

# ✅ catch Block

Handles exception.

```java
catch(ArithmeticException e){
    System.out.println("Divide by zero");
}
```

---

---

# ✅ Multiple Catch (YES allowed)

```java
try {
    int a = 10/0;
}
catch(ArithmeticException e){
    System.out.println("Math error");
}
catch(NullPointerException e){
    System.out.println("Null error");
}
catch(Exception e){
    System.out.println("Generic error");
}
```

---

## Rule

Always:

```
Specific → General
```

---

---

# ✅ Multi-Catch (Java 7+)

```java
catch(IOException | SQLException e){
    System.out.println("DB or IO error");
}
```

---

---

# ✅ finally Block

## Definition

Always executes (exception or not).

## Used for

* Close DB
* Close file
* Cleanup
* Release resources

---

## Example

```java
finally{
   System.out.println("Always runs");
}
```

---

## finally does NOT run if

* System.exit()
* JVM crash
* Power failure

---

---

# ✅ Can we write only try?

❌ No

Must have:

```
try + catch OR try + finally
```

---

---

# ✅ throw vs throws

---

## throw (manual exception)

```java
throw new IllegalArgumentException("Invalid age");
```

Used to explicitly throw exception.

---

## throws (delegate exception)

```java
public void readFile() throws IOException {
}
```

Caller must handle.

---

---

# ✅ Real Selenium Example

```java
try {
    driver.findElement(By.id("login")).click();
}
catch(NoSuchElementException e){
    System.out.println("Element not found");
}
finally{
    driver.quit();
}
```

---

---

# ✅ Best Practices

✔ Handle only where needed
✔ Use specific exceptions
✔ Always cleanup resources
✔ Avoid empty catch blocks
✔ Log errors
✔ Prefer try-with-resources

---

---

# ✅ Interview Quick Answers

### Q What is hierarchy?

Throwable → Error + Exception → Checked + Runtime

### Q Checked vs runtime?

Compiler vs runtime

### Q Multiple catch?

Yes

### Q finally purpose?

Cleanup

### Q throw vs throws?

Manual vs delegation

---

---

# ✅ Cheatsheet

```
Throwable
   ├── Error
   └── Exception
         ├── Checked
         └── Runtime

try → risky
catch → handle
finally → cleanup
throw → create
throws → declare
```

---

---

# 🎯 One-Line Interview Answer

"Java exceptions extend Throwable and are divided into Error and Exception. Exceptions are further classified into checked and runtime. Checked must be handled at compile time, while runtime occur during execution. We handle them using try-catch-finally."

---

END
