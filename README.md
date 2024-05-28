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
project-root/
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
│   │   │       └── calculator_view.fxml
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── calculator/
│   │   │               ├── CalculatorControllerTest.java
│   │   │               └── helper/
│   │   │                   └── TestHelper.java
├── pom.xml
```

**Getting Started:**

1. **Clone the repository:**
   ```sh
   git clone https://github.com/yourusername/CalculatorFX.git
   cd CalculatorFX
   ```
2. **Set the JavaFX SDK path:**
   ```sh
   export JAVAFX_HOME=/path/to/your/javafx-sdk-22.0.1
   ```
3. **Build and run the project:**
   ```sh
   mvn clean compile exec:java
   ```

**Future Enhancements:**

- Implement advanced mathematical functions such as trigonometry and logarithms.
- Add a history feature to track previous calculations.
- Enhance the UI with custom themes and styles.

**Contributing:**
Contributions are welcome! Please fork this repository and submit pull requests for any enhancements or bug fixes.

**Author:**
Igor Verbitskiy