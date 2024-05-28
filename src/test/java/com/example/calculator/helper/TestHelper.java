package com.example.calculator.helper;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class TestHelper {
    public static ActionEvent createButtonEvent(String text) {
        Button button = new Button(text);
        return new ActionEvent(button, null);
    }
}