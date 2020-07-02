package com.epam.day5.servicetest.impltest;

import com.epam.day5.service.impl.ReplaceLetterCharService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class ReplaceLetterCharServiceTest {
    ReplaceLetterCharService service;
    String line = "The maximum weight for balls is 1.62 ounces, and balls are not permitted!";

    @BeforeClass
    public void setUp() {
        service = new ReplaceLetterCharService();
    }

    @Test
    public void fixTypoInTextPositiveTest() {
        Optional<String> actual = service.fixTypoInText(line, "ba", "ro");
        Optional<String> expected = Optional.of("The maximum weight for rolls is 1.62 ounces, and rolls are not permitted!");
        assertEquals(actual, expected);
    }

    @Test
    public void fixTypoInTextNegativeTest() {
        Optional<String> actual = service.fixTypoInText(null, "[Bb]a", "ro");
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void replaceLetterByIndexTextPositiveTest() {
        Optional<String> actual = service.replaceLetterByIndexInWord(line, 3, '@');
        Optional<String> expected = Optional.of("Th@ ma@imum we@ght fo@ ba@ls is  1 . 6 2 ou@ces , an@ ba@ls ar@ no@ pe@mitted !  ");
        assertEquals(actual, expected);
    }

    @Test
    public void replaceLetterByIndexInWordLineIsNullNegativeTest() {
        Optional<String> actual = service.replaceLetterByIndexInWord(null, 1, '@');
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void replaceLetterByIndexInWordIncorrectIndexNegativeTest() {
        Optional<String> actual = service.replaceLetterByIndexInWord(line, -8, '@');
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void replaceWordsPositiveTest() {
        Optional<String> actual = service.replaceWords(line, 3, "assert");
        Optional<String> expected = Optional.of("assert maximum weight assert balls is  1 . 6 2 ounces , assert balls assert assert permitted !  ");
        assertEquals(actual, expected);
    }

    @Test
    public void replaceWordsNegativeTest() {
        Optional<String> actual = service.replaceWords(null, 4, "true");
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }
}
