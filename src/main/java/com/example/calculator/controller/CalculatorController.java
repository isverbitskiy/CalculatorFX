package com.example.calculator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField display;

    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        if ("0123456789".contains(value)) {
            if (start) {
                display.setText(value);
                start = false;
            } else {
                display.setText(display.getText() + value);
            }
        } else {
            if (!"=".equals(value)) {
                if (!operator.isEmpty()) {
                    return;
                }
                operator = value;
                num1 = Double.parseDouble(display.getText());
                display.setText("");
            }
        }
    }

    @FXML
    private void handleEqualAction(javafx.event.ActionEvent event) {
        if (operator.isEmpty()) {
            return;
        }
        double num2 = Double.parseDouble(display.getText());
        double result = calculate(num1, num2, operator);
        display.setText(String.valueOf(result));
        operator = "";
        start = true;
    }

    @FXML
    private void handleResetAction(javafx.event.ActionEvent event) {
        display.setText("");
        num1 = 0;
        operator = "";
        start = true;
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    return 0;
                }
                return num1 / num2;
            default:
                return 0;
        }
    }
}