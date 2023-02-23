package com.example.lab2;

import org.junit.Test;

import static org.junit.Assert.*;


public class CountFunctionsClassUnitTest {
    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_CountWordsFunctionIsPerformed_Then_NullPointerExceptionIsThrown() {
        CountFunctions.countWords(null);
    }

    @Test
    public void Given_StringWithManyDots_When_CountWordsFunctionIsPerformed_Then_ReturnNumberOfWords() {
        final String givenString = "...... sdsd. ..... ......";

        final int expectedNumber = 1;
        final int actualResult = CountFunctions.countWords(givenString);

        assertEquals(expectedNumber, actualResult);
    }

    @Test
    public void Given_String_When_CountWordsFunctionIsPerformed_Then_ReturnNumberOfWords() {
        final String givenString = "some random text";

        final int expectedNumber = 3;
        final int actualResult = CountFunctions.countWords(givenString);

        assertEquals(expectedNumber, actualResult);
    }

    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_CountCharsFunctionIsPerformed_Then_NullPointerExceptionIsThrown() {
        CountFunctions.countChars(null);
    }

    @Test
    public void Given_String_When_CountCharsFunctionIsPerformed_Then_ReturnNumberOfCharacters() {
        final String givenString = "Some random text to test the work of function";

        final int expectedNumber = 45;
        final int actualResult = CountFunctions.countChars(givenString);

        assertEquals(expectedNumber, actualResult);
    }
}