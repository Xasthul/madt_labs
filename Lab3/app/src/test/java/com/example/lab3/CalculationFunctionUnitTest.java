package com.example.lab3;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mariuszgromada.math.mxparser.*;


public class CalculationFunctionUnitTest {
    @Test
    public void Given_StringFiveMultiplyFive_When_ExpCalculatePerformed_Then_ReturnTwentyFive() {
        final String givenString = "5*5";

        final int expectedResult = 25;
        Expression exp = new Expression(givenString);
        final int actualResult = (int) exp.calculate();

        assertEquals(expectedResult, actualResult);
    }
}