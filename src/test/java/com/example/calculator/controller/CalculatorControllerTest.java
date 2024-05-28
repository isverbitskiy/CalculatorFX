package com.example.calculator.controller;

import com.example.calculator.helper.TestHelper;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorControllerTest extends ApplicationTest {

    private CalculatorController controller;

    @BeforeEach
    public void setUp() {
        controller = new CalculatorController();
        controller.display = new TextField();
    }

    @Test
    public void testAddition() {
        controller.handleButtonAction(TestHelper.createButtonEvent("2"));
        controller.handleButtonAction(TestHelper.createButtonEvent("+"));
        controller.handleButtonAction(TestHelper.createButtonEvent("3"));
        controller.handleEqualAction(TestHelper.createButtonEvent("="));

        assertEquals("5", controller.display.getText());
    }

    @Test
    public void testSubtraction() {
        controller.handleButtonAction(TestHelper.createButtonEvent("7"));
        controller.handleButtonAction(TestHelper.createButtonEvent("-"));
        controller.handleButtonAction(TestHelper.createButtonEvent("3"));
        controller.handleEqualAction(TestHelper.createButtonEvent("="));

        assertEquals("4", controller.display.getText());
    }

    @Test
    public void testMultiplication() {
        controller.handleButtonAction(TestHelper.createButtonEvent("4"));
        controller.handleButtonAction(TestHelper.createButtonEvent("*"));
        controller.handleButtonAction(TestHelper.createButtonEvent("2"));
        controller.handleEqualAction(TestHelper.createButtonEvent("="));

        assertEquals("8", controller.display.getText());
    }

    @Test
    public void testDivision() {
        controller.handleButtonAction(TestHelper.createButtonEvent("7"));
        controller.handleButtonAction(TestHelper.createButtonEvent("/"));
        controller.handleButtonAction(TestHelper.createButtonEvent("2"));
        controller.handleEqualAction(TestHelper.createButtonEvent("="));
        assertEquals("3.5", controller.display.getText());
    }

    @Test
    public void testReset() {
        controller.handleButtonAction(TestHelper.createButtonEvent("5"));
        controller.handleResetAction(TestHelper.createButtonEvent("C"));

        assertTrue(controller.display.getText().isEmpty());
    }

    @Test
    public void testSignChange() {
        controller.handleButtonAction(TestHelper.createButtonEvent("5"));
        controller.handleSignChangeAction(TestHelper.createButtonEvent("+/-"));

        assertEquals("-5", controller.display.getText());
    }

    @Test
    public void testPercentage() {
        controller.handleButtonAction(TestHelper.createButtonEvent("50"));
        controller.handlePercentageAction(TestHelper.createButtonEvent("%"));

        assertEquals("0.5", controller.display.getText());
    }
}