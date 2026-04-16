# Problem Statement 3: BankBot – Selenium-Java Test Automation Framework for an Online Banking Portal
## Project Overview

**BankBot** is a Selenium-Java based automation testing framework developed to validate an online banking application.
The framework follows industry best practices such as **Page Object Model (POM)**, **TestNG**, **data-driven testing**, and **automated reporting**.

This project automates end-to-end workflows including:

* User authentication
* Customer management
* Account management
* Fund transfer
* Form validations

## Application Under Test 
🔗 https://demo.guru99.com/V4/index.php

---
## Important Note on Credentials

The login credentials used in this project are based on the Guru99 demo application.

🔹 **Username and password are temporary** and may change or expire approximately every **20 days**.

🔹 If tests fail due to login issues, please generate new credentials from the application given above

### Steps to Update Credentials

1. Visit the Guru99 demo site
2. Register for new login credentials
3. Update the following fields in `config.properties`:

```
user=YOUR_NEW_USERNAME
pass=YOUR_NEW_PASSWORD
```

---

*Tip:* This framework is designed to be **config-driven**, so updating credentials in one place will reflect across all tests.

## Objectives

* Build a reusable and scalable automation framework
* Implement Page Object Model (POM)
* Use TestNG for execution and reporting
* Handle dynamic elements using explicit waits
* Capture screenshots automatically on test failure
* Generate professional HTML reports using Extent Reports

---

## Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Reporting:** Extent Reports
* **Data Handling:** Config.properties (Data-driven)
* **Driver Management:** WebDriverManager

---

## Project Structure

```
Bank_Bot/
│── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   ├── BaseTest.java
│   │   │   ├── BasePage.java
│   │   │
│   │   ├── pages/
│   │   │   ├── LoginPage.java
│   │   │   ├── NewCustomerPage.java
│   │   │   ├── EditCustomerPage.java
│   │   │   ├── NewAccountPage.java
│   │   │   ├── EditAccountPage.java
│   │   │   ├── FundTransferPage.java
│   │   │   ├── DepositPage.java
│   │   │   ├── BalanceEnquiryPage.java
│   │   │
│   │   ├── utils/
│   │   │   ├── ConfigReader.java
│   │   │   ├── DriverFactory.java
│   │   │   ├── ScreenshotUtil.java
│   │   │   ├── ExtentManager.java
│   │   │
│   │   ├── listeners/
│   │       ├── TestListener.java
│
│   ├── test/java/
│   │   ├── tests/
│   │       ├── LoginTest.java
│   │       ├── CustomerTest.java
│   │       ├── AccountTest.java
│   │       ├── FundTransferTest.java
│   │       ├── FormValidationTest.java
│
│── resources/
│   ├── config.properties
│
│── reports/
│   ├── ExtentReport.html
│
│── screenshots/
│   ├── *.png
│
│── testng.xml
│── pom.xml
```

---

## Key Features

### ✅ Page Object Model (POM)

* Each page is represented as a separate class
* Locators and actions are encapsulated inside page classes
* Improves maintainability and readability

---

### ✅ Data-Driven Framework

* All test data stored in `config.properties`
* No hardcoded values in test classes
* Easily configurable

---

### ✅ TestNG Integration

* Uses annotations like `@Test`, `@BeforeMethod`, `@AfterMethod`
* Supports DataProviders and listeners
* Suite execution via `testng.xml`

---

### ✅ Screenshot on Failure

* Implemented using `ITestListener`
* Captures screenshot automatically when test fails
* Stored in `/screenshots` folder

---

### ✅ Extent Reports

* Generates detailed HTML report after execution
* Includes:

  * Test status (Pass/Fail)
  * Error details
  * Screenshots on failure

---

### ✅ WebDriver Management

* Uses WebDriverManager
* No manual driver setup required

---

### ✅ Explicit Wait Strategy

* Uses `WebDriverWait`
* No usage of `Thread.sleep()`

---

##  Test Modules Covered

### 🔹 Module 1 – Authentication

* Valid & invalid login
* Blank field validation
* Logout verification

---

### 🔹 Module 2 – Customer Management

* Create customer
* Verify customer ID
* Edit customer details
* Duplicate email validation

---

### 🔹 Module 3 – Account Management

* Create account
* Verify account ID
* Edit account (handled safely)
* Invalid customer validation
* Account listing verification

---

### 🔹 Module 4 – Fund Transfer

* Transfer funds between accounts
* Verify success message
* Verify balance update
* Invalid payee validation

---

### 🔹 Module 5 – Form Validation

* Empty field validation
* Non-numeric input validation
* Future date validation

---

##  How to Run the Project

### 🔹 Using Maven

```
mvn test
```

### 🔹 Using TestNG

* Right click on `testng.xml`
* Select **Run As → TestNG Suite**

---

##  Reports

After execution:

* 📄 HTML Report → `/reports/ExtentReport.html`
* 📸 Screenshots → `/screenshots/`

---

##  Best Practices Followed

* No hardcoded values
* Reusable components
* Clean code structure
* Proper exception handling
* Scalable framework design

---

##  Author

**Bhavya Sree Kasa**

---

##  Conclusion

This framework demonstrates a complete **real-world automation testing solution** using Selenium and Java.
It is scalable, maintainable, and aligned with industry standards, making it suitable for enterprise-level testing.

---
