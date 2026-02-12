# 🚀 Jenkins Complete Guide (Beginner → Expert)

This guide covers **Jenkins from scratch to advanced level**, including:

- Freestyle jobs
- Pipeline (UI + Jenkinsfile)
- Parameters
- Credentials / Secrets
- Parallel tests
- Pre & Post actions
- Trigger another job
- Real-world CI/CD example
- Production best practices

---

# 📌 Level 1 – Jenkins Basics

## Install
- Java 17+
- Jenkins (WAR or Docker)
- Open: http://localhost:8080

## Core Concepts
- Dashboard
- Plugins
- Nodes/Agents
- Workspaces
- Freestyle Job

## First Freestyle Job

Build Step → Execute Shell

```bash
echo "Hello Jenkins"
mvn clean package
```

---

# 📌 Level 2 – Pipeline Basics

## What is Pipeline?
Pipeline = CI/CD flow written as code (Groovy)

Two ways:
1. Pipeline script in UI
2. Jenkinsfile (recommended)

---

# ✅ Pipeline using UI

New Item → Pipeline → Pipeline Script

```groovy
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building project'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests'
            }
        }
    }
}
```

---

# ✅ Pipeline using Jenkinsfile (Best Practice)

Create `Jenkinsfile` in repo:

```groovy
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your/repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
```

Pipeline → Pipeline script from SCM

---

# 📌 Level 3 – Advanced Pipeline

---

## 🔹 Parameters

### UI
"This build is parameterized"

### Jenkinsfile

```groovy
parameters {
    string(name: 'ENV', defaultValue: 'dev')
    booleanParam(name: 'RUN_TESTS', defaultValue: true)
}
```

Use:

```groovy
echo "Env = ${params.ENV}"
```

---

## 🔹 Credentials / Secrets

Manage Jenkins → Credentials → Add

Types:
- Username/Password
- Secret Text
- SSH key

### Use in Pipeline

```groovy
withCredentials([
    string(credentialsId: 'my-token', variable: 'TOKEN')
]) {
    sh 'echo $TOKEN'
}
```

OR

```groovy
environment {
    MY_PASS = credentials('cred-id')
}
```

---

## 🔹 Parallel Tests

```groovy
stage('Parallel Tests') {
    parallel {
        stage('Unit') {
            steps { sh 'mvn test' }
        }
        stage('API') {
            steps { sh 'mvn verify' }
        }
        stage('UI') {
            steps { sh 'mvn test -Dtest=ui' }
        }
    }
}
```

---

## 🔹 Pre & Post Actions

```groovy
post {
    always {
        echo 'Cleanup'
    }
    success {
        echo 'Build successful'
    }
    failure {
        echo 'Build failed'
    }
}
```

---

## 🔹 Trigger Another Job

### Simple

```groovy
post {
    success {
        build job: 'Deploy-Job'
    }
}
```

### With parameters

```groovy
post {
    success {
        build job: 'Deploy-Job',
        parameters: [
            string(name: 'ENV', value: 'prod')
        ]
    }
}
```

---

# 📌 Level 4 – Real Project Example

Spring Boot + Maven + Tests + Docker + Deployment

```groovy
pipeline {
    agent any

    parameters {
        string(name: 'ENV', defaultValue: 'dev')
    }

    environment {
        DOCKER_PASS = credentials('docker-pass')
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/your/repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Parallel Tests') {
            parallel {
                stage('API') {
                    steps { sh 'mvn test -Dtest=api' }
                }
                stage('UI') {
                    steps { sh 'mvn test -Dtest=ui' }
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t myapp .'
            }
        }
    }

    post {
        success {
            build job: 'Deploy-Job',
                  parameters: [string(name: 'ENV', value: params.ENV)]
        }
        failure {
            echo 'Build failed'
        }
        always {
            cleanWs()
        }
    }
}
```

---

# 📌 Level 5 – Expert Topics

Must learn:

- Multi-branch pipeline
- Shared libraries
- Docker agents
- Kubernetes agents
- Artifacts
- SonarQube
- Slack/Email notifications
- Matrix builds
- Blue Ocean
- Caching strategies
- Declarative vs Scripted pipelines

---

# 📅 2-Week Practice Plan

## Week 1
Day 1 → Freestyle  
Day 2 → Pipeline  
Day 3 → Jenkinsfile  
Day 4 → Parameters  
Day 5 → Secrets  
Day 6 → Parallel  
Day 7 → Mini project  

## Week 2
Day 8 → Docker build  
Day 9 → Deploy job  
Day 10 → Trigger job  
Day 11 → Shared libs  
Day 12 → Sonar  
Day 13 → GitHub webhook  
Day 14 → Full CI/CD  

---

# 🎯 Suggested Final Project

Build:

- Spring Boot App
- RestAssured tests
- Selenium tests
- Docker image
- Jenkins pipeline
- Auto deployment

This completes your **Beginner → Expert Jenkins journey**.
