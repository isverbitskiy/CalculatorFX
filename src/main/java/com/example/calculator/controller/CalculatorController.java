package com.example.calculator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    public TextField display;

    public boolean start = true;
    private double num1 = 0;
    private String operator = "";

    @FXML
    void handleButtonAction(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        if ("0123456789.".contains(value)) {
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
                display.setText(display.getText() + " " + value + " ");
            }
        }
    }

    @FXML
    void handleEqualAction(javafx.event.ActionEvent event) {
        if (operator.isEmpty()) {
            return;
        }
        String[] parts = display.getText().split(" ");
        if (parts.length < 3) {
            return;
        }
        double num2 = Double.parseDouble(parts[2]);
        double result = calculate(num1, num2, operator);
        display.setText(formatResult(result));
        operator = "";
        start = true;
    }

    @FXML
    void handleResetAction(javafx.event.ActionEvent event) {
        display.setText("");
        num1 = 0;
        operator = "";
        start = true;
    }

    @FXML
    void handleSignChangeAction(javafx.event.ActionEvent event) {
        double value = Double.parseDouble(display.getText());
        value = value * -1;
        display.setText(formatResult(value));
    }

    @FXML
    public void handlePercentageAction(javafx.event.ActionEvent event) {
        double value = Double.parseDouble(display.getText());
        value = value / 100;
        display.setText(formatResult(value));
    }

    private double calculate(double num1, double num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num2 == 0 ? 0 : num1 / num2;
            default -> 0;
        };
    }

    private String formatResult(double result) {
        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }
}