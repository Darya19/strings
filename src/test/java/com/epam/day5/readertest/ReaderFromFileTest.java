package com.epam.day5.readertest;

import com.epam.day5.exception.CustomException;
import com.epam.day5.reader.ReaderFromFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;


public class ReaderFromFileTest {
    ReaderFromFile reader;
    List<String> text = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        reader = new ReaderFromFile();
        text.add("The weight of a golf ball is carefully regulated to ensure that balls");
        text.add("that are too heavy are not produced and used in an official capacity.");
        text.add("The maximum weight for a ball is 1.62 ounces, and balls are not permitted");
        text.add("to exceed this and still be used in tournament play.");
    }

    @Test
    public void readNumbersFromActualFilePositiveTest() {
        try {
            List<String> actual = reader.readFromFile("data\\arrayData.txt");
            List<String> expected = text;
            assertEquals(actual, expected);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test
    public void readNumbersFromDefaultFilePositiveTest() {
        try {
            List<String> actual = reader.readFromFile("data\\rrayData.txt");
            List<String> expected = text;
            assertEquals(actual, expected);
        } catch (CustomException e) {
            fail();
        }
    }

    @Test(expectedExceptions = CustomException.class)
    public void readNumbersFromFileNegativeTest() throws CustomException {
        reader.readFromFile("data\\data.mp3");
    }
}
