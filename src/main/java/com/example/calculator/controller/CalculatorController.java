package com.example.calculator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Optional;

public class CalculatorController {
    @FXML
    public TextField display;

    private boolean start = true;
    private double num1 = 0;
    private String operator = "";

    @FXML
    void handleButtonAction(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        if (isNumeric(value)) {
            appendToDisplay(value);
        } else if (!"=".equals(value)) {
            setOperator(value);
        }
    }

    @FXML
    void handleEqualAction(javafx.event.ActionEvent event) {
        if (isOperatorEmpty() || !isValidExpression()) {
            return;
        }
        double num2 = parseOperand(display.getText().split(" ")[2]).orElse(0.0);
        double result = calculate(num1, num2, operator);
        display.setText(formatResult(result));
        resetState();
    }

    @FXML
    void handleResetAction(javafx.event.ActionEvent event) {
        resetDisplay();
    }

    @FXML
    void handleSignChangeAction(javafx.event.ActionEvent event) {
        parseOperand(display.getText()).ifPresent(value ->
                display.setText(formatResult(value * -1))
        );
    }

    @FXML
    public void handlePercentageAction(javafx.event.ActionEvent event) {
        String[] parts = display.getText().split(" ");
        if (parts.length == 1) {
            // Handle percentage of a single number
            double value = parseOperand(parts[0]).orElse(0.0);
            double result = value / 100;
            display.setText(formatResult(result));
        } else if (parts.length >= 3 && !isOperatorEmpty()) {
            // Handle percentage of an operation
            double base = parseOperand(parts[0]).orElse(0.0);
            double percentage = parseOperand(parts[2]).orElse(0.0) / 100;
            double result = calculatePercentage(base, percentage, operator);
            display.setText(formatResult(result));
            resetState();
        }
    }

    private boolean isNumeric(String value) {
        return value.matches("\\d*\\.?\\d+");
    }

    private void appendToDisplay(String value) {
        if (start) {
            display.setText(value);
            start = false;
        } else {
            display.setText(display.getText() + value);
        }
    }

    private void setOperator(String value) {
        if (!operator.isEmpty()) {
            return;
        }
        operator = value;
        num1 = parseOperand(display.getText()).orElse(0.0);
        display.setText(display.getText() + " " + value + " ");
    }

    private boolean isOperatorEmpty() {
        return operator.isEmpty();
    }

    private boolean isValidExpression() {
        return display.getText().split(" ").length >= 3;
    }

    private Optional<Double> parseOperand(String text) {
        try {
            return Optional.of(Double.parseDouble(text));
        } catch (NumberFormatException e) {
            display.setText("Error");
            return Optional.empty();
        }
    }

    private void resetDisplay() {
        display.setText("");
        resetState();
    }

    private void resetState() {
        num1 = 0;
        operator = "";
        start = true;
    }

    private double calculate(double num1, double num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "÷" -> num2 == 0 ? Double.NaN : num1 / num2;
            default -> 0;
        };
    }

    private double calculatePercentage(double base, double percentage, String operator) {
        return switch (operator) {
            case "+" -> base + (base * percentage);
            case "-" -> base - (base * percentage);
            case "*" -> base * percentage;
            case "÷" -> percentage == 0 ? Double.NaN : base / percentage;
            default -> 0;
        };
    }

    private String formatResult(double result) {
        if (Double.isNaN(result)) {
            return "Error";
        } else if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }
}