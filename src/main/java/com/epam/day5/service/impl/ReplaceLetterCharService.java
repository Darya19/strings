package com.epam.day5.service.impl;

import com.epam.day5.service.ReplaceLetter;

import java.util.Optional;

public class ReplaceLetterCharService implements ReplaceLetter {

    private static final String SPACE = " ";
    private static final int DEFAULT_CAPACITY = 20;

    @Override
    public Optional<String> replaceLetterByIndexInWord(String sourceText, int index, char newSymbol) {
        if (sourceText == null || index < 0) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        char[] letterArray = sourceText.toCharArray();
        char[][] words = split(letterArray);
        for (int i = 0; i < words.length; i++) {
            if (words[i].length >= index) {
                words[i][index - 1] = newSymbol;
            }
            builder.append(words[i]).append(SPACE);
        }
        return Optional.of(builder.toString());
    }

    @Override
    public Optional<String> fixTypoInText(String sourceText, String typo, String correctSymbol) {
        if (sourceText == null) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        char[] letterArray = sourceText.toCharArray();
        char[] typoArray = typo.toCharArray();
        char[] correctSymbolArray = correctSymbol.toCharArray();
        for (int i = 0; i < letterArray.length; i++) {
            if (letterArray[i] == typoArray[0] && letterArray[i + 1] == typoArray[1]) {
                letterArray[i] = correctSymbolArray[0];
                letterArray[i + 1] = correctSymbolArray[1];
            }
            builder.append(letterArray[i]);
        }
        return Optional.of(builder.toString());
    }

    @Override
    public Optional<String> replaceWords(String sourceText, int wordLength, String subLine) {
        if (sourceText == null) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        char[] letterArray = sourceText.toCharArray();
        char[][] words = split(letterArray);
        for (int i = 0; i < words.length; i++) {
            if (words[i].length == wordLength) {
                words[i] = subLine.toCharArray();
            }
            builder.append(words[i]).append(SPACE);
        }
        return Optional.of(builder.toString());
    }

    private char[][] split(char[] letterArray) {
        int columnIndex = 0;
        int lineIndex = 0;
        char[][] words = new char[DEFAULT_CAPACITY][];
        for (int i = 0; i < words.length; i++) {
            words[i] = new char[letterArray.length];
        }
        for (int i = 0; i < letterArray.length; i++) {
            if (Character.isLetter(letterArray[i])) {
                words[columnIndex][lineIndex] = letterArray[i];
                lineIndex++;
            } else {
                if (Character.isSpaceChar(letterArray[i])) {
                    columnIndex++;
                    lineIndex = 0;
                } else {
                    lineIndex = 0;
                    columnIndex++;
                    words[columnIndex][lineIndex] = letterArray[i];
                }
            }
        }
        char copyWords[][] = new char[DEFAULT_CAPACITY][];
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words[i].length; j++) {
                if (words[i][j] != '\u0000') {
                    count++;
                }
            }
            copyWords[i] = new char[count];
            for (int j = 0; j < copyWords[i].length; j++) {
                copyWords[i][j] = words[i][j];
            }
        }
        return copyWords;
    }
}
