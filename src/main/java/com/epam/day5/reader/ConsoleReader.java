package com.epam.day5.reader;

import com.epam.day5.exception.CustomException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleReader {
    private final String REGEX = " ";

    public List<String> readNumbersFromConsole() throws CustomException {
        List<String> stringLines = new ArrayList<>();
        String line = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            assert line != null;
            while(!line.isEmpty()){
            line = reader.readLine();
           stringLines.add(line);}
            return stringLines;
        } catch (IOException e) {
            throw new CustomException("incorrect input data", e);
        }
    }
}
