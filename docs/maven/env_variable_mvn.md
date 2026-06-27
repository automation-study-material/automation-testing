Option 1: Pass Environment Variables Using Maven (Most Common)

Suppose your framework has multiple environments:

QA
UAT
PreProd
Prod

Instead of hardcoding:

String url = "https://qa.company.com";

we pass the environment when running Maven.

Step 1: Configure pom.xml
<properties>
    <env>qa</env>
</properties>

<build>
    <plugins>
        <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.5.3</version>

            <configuration>
                <systemPropertyVariables>
                    <env>${env}</env>
                </systemPropertyVariables>
            </configuration>
        </plugin>
    </plugins>
</build>
Step 2: Run Maven

Default

mvn clean test

Runs

env = qa

Override

mvn clean test -Denv=uat

or

mvn clean test -Denv=preprod

Now Maven exports

env=uat

to your Java code.

Step 3: Read in Java
String env = System.getProperty("env");

System.out.println(env);

Output

uat
Internal Flow
Developer

↓

mvn clean test -Denv=uat

↓

pom.xml

↓

Surefire Plugin

↓

System Property

↓

Java Test

↓

System.getProperty("env")
Real Framework Example

Suppose

config

├── qa.properties

├── uat.properties

└── preprod.properties

Java

String env = System.getProperty("env");

ConfigReader.load(env + ".properties");

If

mvn test -Denv=preprod

Loads

preprod.properties
Option 2: Pass Environment Variables from Jenkins

Suppose Jenkins has a parameter.

ENVIRONMENT

↓

QA

UAT

PREPROD

Jenkins executes

mvn clean test -Denv=${ENVIRONMENT}

If

ENVIRONMENT = UAT

Then Jenkins runs

mvn clean test -Denv=UAT

Java receives

System.getProperty("env")

Output

UAT
Jenkins Flow
User

↓

Build with Parameters

↓

ENVIRONMENT = QA

↓

Jenkins

↓

mvn clean test -Denv=QA

↓

Surefire Plugin

↓

Java Test

↓

Load qa.properties
Passing Browser

Instead of

ChromeDriver driver = new ChromeDriver();

Run

mvn test -Dbrowser=chrome

or

mvn test -Dbrowser=edge

Java

String browser = System.getProperty("browser");

Output

chrome
Passing Multiple Parameters
mvn clean test \
-Denv=qa \
-Dbrowser=chrome \
-Dsuite=smoke

Java

String env = System.getProperty("env");

String browser = System.getProperty("browser");

String suite = System.getProperty("suite");
Jenkins Example

Build Parameters

ENVIRONMENT

Browser

Suite

Values

ENVIRONMENT = QA

Browser = Chrome

Suite = Smoke

Jenkins command

mvn clean test \
-Denv=${ENVIRONMENT} \
-Dbrowser=${Browser} \
-Dsuite=${Suite}
TestNG Example
<suite name="Smoke Suite">

Java

String suite = System.getProperty("suite");

if(suite.equals("smoke")){

    // execute smoke tests

}
Enterprise Flow
Developer

↓

Push Code

↓

GitHub

↓

Jenkins

↓

Build With Parameters

↓

Environment = QA

Browser = Chrome

Suite = Smoke

↓

mvn clean test

-Denv=QA

-Dbrowser=Chrome

-Dsuite=Smoke

↓

Surefire Plugin

↓

Java Tests

We configure the maven-surefire-plugin to pass Maven properties as JVM system properties using <systemPropertyVariables>. At runtime, we provide values with -D options such as -Denv=qa or -Dbrowser=chrome. In Jenkins, these values are typically supplied through build parameters or environment variables and passed to Maven in the build command. The Java test code reads them using System.getProperty(), allowing the same framework to run against different environments, browsers, or test suites without modifying the source code.
