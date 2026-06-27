# 📘 How Maven Works

## What is Maven?

**Maven** is a **Build Automation** and **Dependency Management** tool primarily used for Java projects.

It reads the `pom.xml` file, understands your project configuration, downloads the required dependencies, executes the requested build lifecycle phases, and produces the final artifact (such as a **JAR** or **WAR** file).

In simple terms, Maven automates the entire build process so developers don't have to manually compile code, manage libraries, run tests, or package applications.

---

# Maven Working Flow

```text
Developer
    │
    ▼
Run Maven Command
(e.g., mvn install)
    │
    ▼
Read pom.xml
    │
    ▼
Read Project Information
(groupId, artifactId, version)
    │
    ▼
Download Dependencies
(if not available in .m2)
    │
    ▼
Execute Maven Lifecycle Phases
    │
    ▼
Generate Artifact (JAR/WAR)
    │
    ▼
Install or Deploy Artifact
```

---

# Stages (Phases) of Maven Default Lifecycle

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

---

# What Each Stage Does

| Stage        | Purpose                                                                                               |
| ------------ | ----------------------------------------------------------------------------------------------------- |
| **validate** | Validates the project structure and `pom.xml`.                                                        |
| **compile**  | Compiles Java source code (`src/main/java`) into `.class` files.                                      |
| **test**     | Compiles and runs unit tests (`src/test/java`) using TestNG or JUnit.                                 |
| **package**  | Packages the compiled code into a **JAR** or **WAR** file.                                            |
| **verify**   | Performs additional verification checks on the packaged artifact.                                     |
| **install**  | Copies the generated artifact to the local Maven repository (`.m2/repository`).                       |
| **deploy**   | Uploads the artifact to a remote repository such as **Nexus**, **Artifactory**, or **Maven Central**. |

---

# Simple End-to-End Flow

```text
Write Java Code
      │
      ▼
mvn install
      │
      ▼
Read pom.xml
      │
      ▼
Validate Project
      │
      ▼
Compile Source Code
      │
      ▼
Run Tests
      │
      ▼
Create JAR
      │
      ▼
Verify Artifact
      │
      ▼
Copy JAR to .m2 Repository
```

> **Note:** Since the command is `mvn install`, Maven automatically executes all the previous lifecycle phases (`validate → compile → test → package → verify`) before performing the `install` phase.

---

# Maven Lifecycle Execution Order

```text
mvn validate
      │
      ▼
validate

-----------------------------------

mvn compile
      │
      ▼
validate
      │
      ▼
compile

-----------------------------------

mvn test
      │
      ▼
validate
      │
      ▼
compile
      │
      ▼
test

-----------------------------------

mvn package
      │
      ▼
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

-----------------------------------

mvn install
      │
      ▼
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

-----------------------------------

mvn deploy
      │
      ▼
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

---

# Key Points to Remember

* Maven always starts by reading the `pom.xml` file.
* Maven checks the local repository (`.m2`) before downloading dependencies.
* Missing dependencies are downloaded automatically from a remote repository (such as Maven Central or a company repository like Nexus or Artifactory).
* Every Maven phase automatically executes all previous phases in the lifecycle.
* Compiled `.class` files are stored in the `target/classes` directory.
* Packaged artifacts (JAR/WAR) are created in the `target` directory.
* The `install` phase copies the artifact to your local Maven repository.
* The `deploy` phase uploads the artifact to a remote repository where other projects can consume it.

---

# One-Line Interview Answer

> **Maven works by reading the `pom.xml` file, resolving project dependencies, executing the required lifecycle phases (`validate → compile → test → package → verify → install → deploy`), and producing and optionally publishing the project's artifact in a standardized and automated manner.**
