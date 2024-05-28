# CalculatorFX

**Description:**
CalculatorFX is a simple yet powerful calculator application built using JavaFX. This project demonstrates the use of
modern Java development practices, including the Model-View-Controller (MVC) architectural pattern, unit testing with
JUnit, and dependency management with Maven. The application provides a user-friendly interface for performing basic
arithmetic operations and percentage calculations.

**Features:**

- **User Interface:** Built with JavaFX, providing a responsive and intuitive design.
- **Arithmetic Operations:** Supports addition, subtraction, multiplication, division, and percentage calculations.
- **MVC Architecture:** Implements the Model-View-Controller pattern for clean separation of concerns.
- **Unit Testing:** Includes unit tests using JUnit to ensure code reliability and correctness.
- **Maven Integration:** Utilizes Maven for dependency management and build automation.

**Technologies Used:**

- **Java 17:** Latest version of Java ensuring modern language features and long-term support.
- **JavaFX:** Used for building the graphical user interface.
- **JUnit:** For writing and running unit tests.
- **Maven:** For project management and build automation.

**Project Structure:**

```
Calculator/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── calculator/
│   │   │               ├── CalculatorApp.java
│   │   │               └── controller/
│   │   │                   └── CalculatorController.java
│   │   ├── resources/
│   │   │   └── view/
│   │   │       └── calculator.fxml
│   ├── test/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── calculator/
│   │   │               ├── controller/
│   │   │               │   └── CalculatorControllerTest.java
│   │   │               └── helper/
│   │   │                   └── TestHelper.java
├── pom.xml
```

**Getting Started:**

1. **Clone the repository:**
   ```sh
   git clone https://github.com/isverbitskiy/CalculatorFX.git
   ```
2. **Set the JavaFX SDK path:**
   ```sh
   export JAVAFX_HOME=/path/to/your/javafx-sdk-22.0.1
   ```
3. **Build and run the project:**
   ```sh
   mvn clean compile exec:java
   ```

**Contributing:**
Contributions are welcome! Please fork this repository and submit pull requests for any enhancements or bug fixes.

**Author:**
Igor Verbitskiy