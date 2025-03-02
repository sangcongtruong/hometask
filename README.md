# Cover Go Home Task

A Selenium-based automation framework for testing the Saucedemo application. This framework uses Java, JUnit, and WebDriverManager to manage browser drivers. It follows the Page Object Model (POM) pattern to promote code reusability, readability, and maintainability.
## Table of Contents
- [Overview](#overview)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Running Tests](#running-tests)

## Overview
This project is designed to:
- Automate end-to-end tests for the [Saucedemo](https://www.saucedemo.com) website.
- Use the Page Object Model to encapsulate UI elements and actions.
- Provide utility classes for driver management, waiting, scrolling, and test parameter loading.
- Support running tests sequentially (or in parallel if extended with ThreadLocal drivers).

## Project Structure
   ```bash
        hometask
            │
            ├─── src
            │     ├─── main
            │     │      └─── java
            │     │             └─── cover.go
            │     │                       │
            │     │                       ├─── pages
            │     │                       │
            │     │                       └─── utils
            │     │
            │     └─── test
            │            ├─── java
            │            │      └─── cover.go
            │            │                │
            │            │                ├─── login
            │            │                │
            │            │                ├─── shopping
            │            │                │
            │            │                └─── ui_navigation
            │            └─── resources
            │                                
            └─── pom.xml
   ```
## Prerequisites

### Maven (tested version 3.8.8)
- **Download Maven:** Visit the [Apache Maven download page](https://maven.apache.org/download.cgi).
- **Select the Correct Version:** Scroll down to the **Previous Stable 3.8.x Release** section.
- **Installation:** Download the Binary installation package and follow online installation guides.
- **Verification:** Confirm your Maven installation by running:
    ```bash
       mvn --version
*Your version should be 3.8.8 or above.*
### Java (tested version 18)
- **Installation:** Install Java by following online guides.
- **Environment Setup:** Ensure Java is added to your system's PATH.
- **Verification:** Check your Java version with:
    ```bash
       java --version
*Your version should be 18 or above.*

### Browser
Tested on below browsers:
- *Firefox version 135* 
- *Chrome version 133*
- *Edge version 133*
### Operating System (macOS Monterey)
Although the project should run on any operating system, it has been tested on:
- *macOS Monterey 12.7.6*
- *Windows 10*
## How to Run Tests
1. **Clone the Repository:**  
   Clone the repository to your local machine.
   ```bash
      git clone git@github.com:sangcongtruong/hometask.git

2. **Navigate to the Project Directory:**  
   Change your current directory to the project's root folder.
   ```bash
      cd hometask
3. **Initial Dependency Installation:**  
 For the first run, install Maven dependencies with:
     ```bash
        mvn clean install
*All dependences should be installed successfully*

## Running Tests
- For subsequent runs with Firefox browser, simply execute:
   ```bash
      mvn test
- To run with Chrome browser:
   ```bash
      mvn test -Dbrowser=chrome
- To run with Egde browser:
   ```bash
      mvn test -Dbrowser=edge
- During this test, an automated browser session will be launched to perform various actions. Please refrain from any manual interaction (such as clicking or touching) on the browser window, as this may disrupt the automation and cause the test to fail.
- After running the tests, the results will be displayed in the terminal.
