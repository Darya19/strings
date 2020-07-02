package com.epam.day5.servicetest.impltest;

import com.epam.day5.service.impl.RemoveLetterStringService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class RemoveLetterStringServiceTest {
    RemoveLetterStringService service;
    String line = "The maximum weight for balls is 1.62 ounces, and balls are not permitted!";

    @BeforeClass
    public void setUp() {
        service = new RemoveLetterStringService();
    }

    @Test
    public void removeSymbolsPositiveTest() {
        Optional<String> actual = service.removeSymbols(line);
        Optional<String> expected = Optional.of("The maximum weight for balls is      ounces  and balls are not permitted  ");
        assertEquals(actual, expected);
    }

    @Test
    public void removeSymbolsNegativeTest() {
        Optional<String> actual = service.removeSymbols(null);
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void removeWordsPositiveTest() {
        Optional<String> actual = service.removeWords(line, 3);
        Optional<String> expected = Optional.of(" maximum weight  balls is 1 62 ounces and balls are  permitted ");
        assertEquals(actual, expected);
    }

    @Test
    public void removeWordsNegativeTest() {
        Optional<String> actual = service.removeSymbols(null);
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }
}
