# Cover Go Home Task

An overview of the setup and testing process for this project.

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

### Browser (tested Firefox 135)
- **Download Firefox:** Get the latest version from the Mozilla Firefox download page.
- **Verification:** Make sure Firefox is updated to version 135 or above (check under "About Firefox").
### Operation System
Although the project should run on any operating system, it has been tested on:
<font color="blue"> $${\color{green}MacOS}$$ $${\color{green}Monterey}$$ $${\color{green}12.7.6}$$</font>
## How to Run Tests
1. **Clone the Repository:**  
   Clone the repository to your local machine.
   ```bash
      git clone https://github.com/your-username/selenium-ui-automation.git

3. **Navigate to the Project Directory:**  
   Change your current directory to the project's root folder.
   ```bash
      cd selenium-ui-automation
5. **Initial Dependency Installation:**  
- For the first run, install Maven dependencies with:
     ```bash
        mvn clean install
*All dependences should be installed successfully*

4. **Run Tests**
- For subsequent runs, simply execute:
   ```bash
      mvn test
- During this test, an automated browser session will be launched to perform various actions. Please refrain from any manual interaction (such as clicking or touching) on the browser window, as this may disrupt the automation and cause the test to fail.
- After running the tests, the results will be displayed in the terminal.
