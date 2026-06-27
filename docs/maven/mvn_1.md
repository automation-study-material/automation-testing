# 📘 02-Maven-Complete-Guide.md

# Maven Complete Guide for SDET & Automation Engineers

> **Version:** 1.0
> **Audience:** Beginners to Advanced (SDET, Automation Engineers, Java Developers)

---

# Table of Contents

1. Introduction to Maven
2. Why Maven?
3. Problems Before Maven
4. What is Build Automation?
5. Maven Architecture
6. Maven Installation
7. Maven Directory Structure
8. Creating Your First Maven Project
9. Understanding `pom.xml`
10. Maven Coordinates (`groupId`, `artifactId`, `version`)
11. Summary

---

# 1. Introduction to Maven

## What is Maven?

**Apache Maven** is a **Build Automation and Dependency Management Tool** primarily used for Java projects.

It helps developers to:

* Compile Java code
* Download project dependencies automatically
* Execute unit tests
* Package applications (JAR/WAR)
* Install artifacts into the local repository
* Deploy artifacts to remote repositories
* Standardize project structure

Instead of manually managing libraries and build steps, Maven automates the entire process.

---

## Simple Definition

> **Maven is a tool that automates building, testing, packaging, dependency management, and deployment of Java projects.**

---

# 2. Why Maven?

Imagine you're developing an Appium automation framework.

Your project requires:

* Selenium
* Appium Java Client
* TestNG
* WebDriverManager
* Log4j
* Jackson
* Apache POI

Without Maven, you would need to:

* Download each JAR manually.
* Copy them into a `lib` folder.
* Update them manually when new versions are released.
* Share all JARs with your teammates.

This quickly becomes difficult to maintain.

---

## Without Maven

```text
Automation Project

├── lib
│   ├── selenium.jar
│   ├── appium.jar
│   ├── testng.jar
│   ├── poi.jar
│   ├── jackson.jar
│   └── log4j.jar
│
└── src
```

Problems:

* Manual downloads
* Version conflicts
* Difficult maintenance
* Time consuming
* Dependency management becomes complex

---

## With Maven

```text
Automation Project

├── pom.xml
└── src
```

Simply add the dependency:

```xml
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>9.5.0</version>
</dependency>
```

Run:

```bash
mvn clean install
```

Maven automatically downloads:

* Appium Java Client
* Selenium
* Required transitive dependencies

No manual work required.

---

# 3. Problems Before Maven

Before Maven, developers managed everything manually.

Typical workflow:

```text
Download JAR
      │
      ▼
Copy to Project
      │
      ▼
Configure Build Path
      │
      ▼
Repeat for Every Library
```

Problems:

* Missing JAR files
* Wrong versions
* Duplicate libraries
* Build failures
* Difficult collaboration

Maven solved all of these by introducing dependency management.

---

# 4. What is Build Automation?

A build process typically includes:

1. Compiling source code
2. Running tests
3. Packaging the application
4. Installing the artifact
5. Deploying the artifact

Without Maven, developers performed these steps manually.

With Maven, one command performs the entire process.

Example:

```bash
mvn clean install
```

---

# 5. Maven Architecture

```text
                Developer
                     │
                     ▼
               mvn clean test
                     │
                     ▼
                 pom.xml
                     │
                     ▼
                 Maven Core
                     │
        ┌────────────┼────────────┐
        ▼            ▼            ▼
 Dependency      Lifecycle      Plugins
 Management
        │
        ▼
Local Repository (.m2)
        │
        ▼
Remote Repository
(Maven Central / Nexus / Artifactory)
```

---

## Components

| Component         | Description                                    |
| ----------------- | ---------------------------------------------- |
| Maven Core        | Executes build lifecycle                       |
| pom.xml           | Project configuration file                     |
| Dependencies      | External libraries required by the project     |
| Plugins           | Perform tasks like compile, test, package      |
| Local Repository  | Stores downloaded dependencies on your machine |
| Remote Repository | Stores shared artifacts                        |

---

# 6. Maven Installation

## Step 1: Install Java

Verify Java installation:

```bash
java -version
```

Expected Output:

```text
openjdk version "17"
```

---

## Step 2: Install Maven

Download Maven from the official Apache website and extract it.

Example:

```text
C:\Program Files\Apache\maven
```

---

## Step 3: Configure Environment Variables

Create:

```text
JAVA_HOME
```

Example:

```text
C:\Program Files\Java\jdk-17
```

Create:

```text
MAVEN_HOME
```

Example:

```text
C:\Program Files\Apache\maven
```

Update the system `PATH`:

```text
%JAVA_HOME%\bin
%MAVEN_HOME%\bin
```

---

## Step 4: Verify Installation

Run:

```bash
mvn -version
```

Expected Output:

```text
Apache Maven 3.x.x

Java version: 17
```

---

# 7. Standard Maven Project Structure

```text
MyProject

├── src
│
│   ├── main
│   │     ├── java
│   │     └── resources
│   │
│   └── test
│         ├── java
│         └── resources
│
├── target
├── pom.xml
└── .mvn
```

---

## src/main/java

Contains your production code.

Examples:

* Business Logic
* Services
* Utilities
* Framework Classes
* Page Objects

---

## src/main/resources

Stores:

* Properties files
* JSON files
* XML files
* Configuration files

Example:

```text
config.properties
log4j2.xml
testdata.json
```

---

## src/test/java

Contains:

* TestNG Tests
* JUnit Tests
* Automation Scripts

Example:

```text
LoginTest

CheckoutTest

SearchTest
```

---

## src/test/resources

Contains:

* Test Data
* Test Configuration
* JSON Files
* Excel Files

---

## target

Generated automatically.

Contains:

```text
Compiled Classes

JAR Files

Reports

Temporary Files
```

Example:

```text
target

├── classes
├── test-classes
├── surefire-reports
└── my-project-1.0.jar
```

Never commit the `target` folder to Git because Maven recreates it during each build.

---

# 8. Creating Your First Maven Project

Example:

```text
Group Id

com.company.mobile

Artifact Id

appium-framework

Version

1.0-SNAPSHOT
```

Maven generates:

```text
appium-framework

├── pom.xml
├── src
└── target
```

---

# 9. Understanding pom.xml

The `pom.xml` (**Project Object Model**) is the heart of every Maven project.

Everything about the project is configured here.

Example:

```xml
<project>

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.company.mobile</groupId>

    <artifactId>appium-framework</artifactId>

    <version>1.0-SNAPSHOT</version>

    <packaging>jar</packaging>

</project>
```

---

## What does each tag mean?

### modelVersion

```xml
<modelVersion>4.0.0</modelVersion>
```

Defines the POM model version.

Almost every Maven project uses:

```text
4.0.0
```

---

### groupId

```xml
<groupId>com.company.mobile</groupId>
```

Represents the organization or company.

Examples:

```text
org.testng

org.seleniumhq.selenium

io.appium

com.company
```

---

### artifactId

```xml
<artifactId>appium-framework</artifactId>
```

Represents the project or module name.

Examples:

```text
appium-framework

common-utils

api-framework

selenium-framework
```

---

### version

```xml
<version>1.0-SNAPSHOT</version>
```

Represents the current version of the artifact.

Examples:

```text
1.0

1.1

2.0

1.0-SNAPSHOT
```

---

### packaging

```xml
<packaging>jar</packaging>
```

Specifies the type of artifact Maven should create.

Common values:

| Packaging | Output                 |
| --------- | ---------------------- |
| jar       | Java Library           |
| war       | Web Application        |
| ear       | Enterprise Application |

---

# 10. Maven Coordinates

Every Maven artifact is uniquely identified by three values:

```text
groupId
    +
artifactId
    +
version
```

Example:

```text
org.testng
        │
        ▼
testng
        │
        ▼
7.11.0
```

Another example:

```text
com.company.mobile
        │
        ▼
appium-framework
        │
        ▼
1.0
```

This combination uniquely identifies a Maven artifact.

---

# 📌 Summary

In this chapter, you learned:

* What Maven is.
* Why Maven is used.
* Problems Maven solves.
* Build automation basics.
* Maven architecture.
* How to install Maven.
* Standard Maven project structure.
* What `pom.xml` is.
* Meaning of `groupId`, `artifactId`, `version`, and `packaging`.

---

# 🚀 Next Chapter

In **Part 2**, we'll cover:

* Maven Repositories
* Local Repository (`.m2`)
* Maven Central
* Nexus & Artifactory
* Dependency Management
* Maven Lifecycle
* `mvn clean`
* `mvn compile`
* `mvn test`
* `mvn package`
* `mvn install`
* `mvn deploy`
* Complete Maven Flow with Enterprise Examples
