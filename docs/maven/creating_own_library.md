# 📘 Creating and Sharing Your Own Maven Library (Artifact)

## Objective

In this chapter, you will learn how to:

* Create your own reusable Java library.
* Package it as a Maven artifact (JAR).
* Install it into your local Maven repository.
* Publish it to a company repository (Nexus/Artifactory/GitHub Packages).
* Allow other developers or projects to use it by simply adding a Maven dependency.

---

# Real-World Scenario

Suppose you're working at **Adobe**.

Your team has developed several common utility classes that are used across multiple automation frameworks.

```text
Common Utilities

├── DriverFactory.java
├── WaitUtils.java
├── ScreenshotUtils.java
├── ExcelUtils.java
├── DatabaseUtils.java
└── ConfigReader.java
```

Now another team asks:

> **"Can we use these utilities in our automation framework?"**

Without Maven, you would have to:

* Zip the project.
* Email it to the team.
* Copy Java files manually.
* Maintain multiple copies of the same code.

❌ This is difficult to maintain and not recommended.

Instead, Maven allows you to package these utilities into a reusable **artifact (JAR)**.

---

# Step 1: Create a Maven Project

Create a Maven project called **automation-common**.

```text
automation-common

├── pom.xml
└── src
    └── main
        └── java
            └── com
                └── company
                    └── utils
```

---

# Step 2: Add Utility Classes

Example: `WaitUtils.java`

```java
package com.company.utils;

public class WaitUtils {

    public static void waitForFiveSeconds() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

Example: `ScreenshotUtils.java`

```java
package com.company.utils;

public class ScreenshotUtils {

    public static void capture() {

        System.out.println("Taking Screenshot");

    }

}
```

You can continue adding more reusable classes such as:

* DriverFactory
* ConfigReader
* DatabaseUtils
* ExcelUtils
* JsonUtils

---

# Step 3: Configure `pom.xml`

```xml
<groupId>com.company.automation</groupId>

<artifactId>automation-common</artifactId>

<version>1.0</version>

<packaging>jar</packaging>
```

### Explanation

#### groupId

```text
com.company.automation
```

Represents the organization or company.

---

#### artifactId

```text
automation-common
```

Represents the library name.

---

#### version

```text
1.0
```

Represents the current release version.

---

#### packaging

```text
jar
```

Tells Maven to generate a **JAR** file.

---

# Step 4: Build the Library

Execute:

```bash
mvn clean package
```

Internally Maven performs:

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
```

Finally, Maven creates:

```text
target

↓

automation-common-1.0.jar
```

---

# What's Inside the JAR?

```text
automation-common-1.0.jar

↓

WaitUtils.class

ScreenshotUtils.class

ConfigReader.class

DatabaseUtils.class
```

Notice:

```text
src/main/java

↓

Included ✅
```

But:

```text
src/test/java

↓

Not Included ❌
```

Only production code is packaged into the JAR.

---

# Step 5: Install the Library into Your Local Repository

Suppose you only want to use this library on your own laptop.

Run:

```bash
mvn install
```

Maven copies the generated JAR to your local Maven repository.

```text
C:\Users\<username>\.m2\repository

↓

com

↓

company

↓

automation

↓

automation-common

↓

1.0
```

---

# Local Repository Flow

```text
Developer

↓

mvn install

↓

target

↓

automation-common.jar

↓

Copy

↓

.m2 Repository
```

Now the library is available on **your local machine**.

---

# Step 6: Use the Library in Another Local Project

Suppose another project called **Appium Framework** needs these utilities.

Simply add the dependency:

```xml
<dependency>

    <groupId>com.company.automation</groupId>

    <artifactId>automation-common</artifactId>

    <version>1.0</version>

</dependency>
```

Now you can directly use the classes.

```java
import com.company.utils.WaitUtils;

public class LoginTest {

    public static void main(String[] args) {

        WaitUtils.waitForFiveSeconds();

    }

}
```

No Java files are copied.

---

# But There's a Limitation

Only **you** can use this library.

Why?

Because it exists only in:

```text
.m2

↓

Your Laptop
```

Other developers don't have your local repository.

---

# Step 7: Publish the Library to a Company Repository

Large organizations use private Maven repositories such as:

* Nexus Repository
* JFrog Artifactory
* GitHub Packages
* Azure Artifacts

Run:

```bash
mvn deploy
```

Internally Maven performs:

```text
Build Library

↓

Generate JAR

↓

Generate POM

↓

Authenticate

↓

Upload to Nexus
```

Repository structure:

```text
Nexus

↓

com.company.automation

↓

automation-common

↓

1.0

↓

automation-common-1.0.jar
```

Now the library is available to the entire organization.

---

# Step 8: Another Developer Uses the Library

Suppose your teammate creates a project called:

```text
Mobile Automation
```

He adds:

```xml
<dependency>

<groupId>com.company.automation</groupId>

<artifactId>automation-common</artifactId>

<version>1.0</version>

</dependency>
```

Then executes:

```bash
mvn clean install
```

Internally Maven performs:

```text
Read pom.xml

↓

Dependency Found

↓

Check .m2

↓

Not Found

↓

Check Nexus

↓

Download JAR

↓

Store in .m2

↓

Compile Project
```

Everything happens automatically.

---

# Complete Enterprise Flow

```text
Developer A

Writes Utility Classes

        │

        ▼

mvn clean package

        │

        ▼

automation-common.jar

        │

        ▼

mvn deploy

        │

        ▼

Company Nexus / Artifactory

        │

────────┼──────────────────────────

        │

        ▼

Developer B

        │

        ▼

Adds Dependency

        │

        ▼

mvn clean install

        │

        ▼

Downloads Library

        │

        ▼

Uses WaitUtils
```

---

# Real Example

The Selenium library works exactly the same way.

You never download Selenium source code manually.

You simply add the dependency:

```xml
<dependency>

<groupId>org.seleniumhq.selenium</groupId>

<artifactId>selenium-java</artifactId>

<version>4.35.0</version>

</dependency>
```

Maven downloads:

```text
selenium-java.jar
```

Inside the JAR are classes such as:

```text
WebDriver

ChromeDriver

FirefoxDriver

WebElement
```

You simply import them:

```java
import org.openqa.selenium.WebDriver;
```

Your own library works in exactly the same way.

---

# Difference Between `install` and `deploy`

| Command       | Who Can Use It? | Location                                                                       |
| ------------- | --------------- | ------------------------------------------------------------------------------ |
| `mvn install` | Only you        | Local `.m2` repository                                                         |
| `mvn deploy`  | Entire team     | Remote repository (Nexus, Artifactory, GitHub Packages, Azure Artifacts, etc.) |

---

# Interview Question

## Q. How do you create and share your own Maven library?

### Answer

1. Create a Maven project containing reusable code inside `src/main/java`.
2. Configure the `groupId`, `artifactId`, `version`, and `packaging` in the `pom.xml`.
3. Execute `mvn clean package` to generate the JAR file.
4. Execute `mvn install` to copy the JAR into the local Maven repository (`.m2`) for personal use.
5. Execute `mvn deploy` to publish the artifact to a remote repository such as Nexus or Artifactory.
6. Other developers simply add the Maven dependency in their `pom.xml`.
7. Maven automatically downloads the artifact into their local `.m2` repository, making the shared classes available without copying any source code.

---

# Key Takeaways

* `src/main/java` contains reusable code that is packaged into the JAR.
* `src/test/java` is **not** included in the generated JAR.
* `mvn package` creates the JAR.
* `mvn install` makes the JAR available on your local machine.
* `mvn deploy` shares the JAR with your entire team through a remote Maven repository.
* Other projects only need to add the dependency in `pom.xml`; Maven handles downloading and managing the library automatically.
