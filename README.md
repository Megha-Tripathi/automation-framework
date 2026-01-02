# Automation Framework – Selenium | Java | Cucumber | Maven | Jenkins
This repository contains a **BDD-based test automation framework** built from scratch using **Selenium WebDriver, Java, Cucumber (Gherkin), Maven**, and integrated with **Jenkins for CI**.

The framework automates the **Login functionality** of: https://automationexercise.com/login

---

## Tech Stack

- **Programming Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **BDD Framework:** Cucumber (Gherkin)  
- **Test Runner:** JUnit  
- **Build Tool:** Maven  
- **CI Tool:** Jenkins  
- **Browser:** Google Chrome  
- **Driver Management:** WebDriverManager  

---

## Project Structure

```text
automation-framework
│── pom.xml
│── README.md
│
└── src
    ├── main
    │   └── java
    │       └── com.automationexercise.pages
    │           └── LoginPage.java
    │
    └── test
        ├── java
        │   └── com.automationexercise
        │       ├── hooks
        │       │   └── Hooks.java
        │       ├── runners
        │       │   └── TestRunner.java
        │       └── stepdefinitions
        │           └── LoginSteps.java
        │
        └── resources
            └── features
                └── login.feature
```

---

# Author
Megha Tripathi GitHub: https://github.com/Megha-Tripathi
