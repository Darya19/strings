package com.epam.day5.service.impl;

import com.epam.day5.service.ReplaceLetter;

import java.util.Optional;

public class ReplaceLetterStringService implements ReplaceLetter {

    private static final String SPACE = " ";
    private static final String LETTERS = "[\\p{L}-]";
    private static final String BORDER_OF_WORD = "\\b";

    @Override
    public Optional<String> replaceLetterByIndexInWord(String sourceText, int index, char newSymbol) {
        if (sourceText == null || index < 1) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        String[] words = sourceText.split(SPACE);
        for (String word : words) {
            if (word.length() >= index && String.valueOf(word.charAt(index - 1)).matches(LETTERS)) {
                builder.append(word, 0, index - 1).append(newSymbol).append(word.substring(index));
            } else {
                builder.append(word);
            }
            builder.append(SPACE);
        }
        return Optional.of(builder.toString());
    }

    @Override
    public Optional<String> fixTypoInText(String sourceText, String typoRegex, String correctSymbol) {
        if (sourceText == null) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        String[] words = sourceText.split(SPACE);
        for (String word : words) {
            builder.append(word.replaceAll(typoRegex, correctSymbol)).append(SPACE);
        }
        return Optional.of(builder.toString());
    }

    @Override
    public Optional<String> replaceWords(String sourceText, int wordLength, String subLine) {
        if (sourceText == null) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        String[] words = sourceText.split(BORDER_OF_WORD);
        for (String word : words) {
            if (word.length() == wordLength) {
                builder.append(subLine);
            } else {
                builder.append(word);
            }
        }
        return Optional.of(builder.toString());
    }
}
