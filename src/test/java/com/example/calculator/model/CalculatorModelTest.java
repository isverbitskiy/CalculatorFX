package com.example.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorModelTest {
    private final CalculatorModel model = new CalculatorModel();

    @Test
    public void testAdd() {
        Assertions.assertEquals(5, model.add(2, 3));
    }
}