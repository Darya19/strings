package com.epam.day5.service.impl;

import com.epam.day5.service.RemoveLetter;

import java.util.Optional;

public class RemoveLetterStringService implements RemoveLetter {

    private static final String SPACE = " ";
    private static final String LETTERS = "[\\p{L}-]";
    private static final String PUNCTUATION_MARKS_AND_DIGITS = "[\\p{Punct}\\p{Digit}]";
    private static final String VOWEL = "[EYUIOAeyuioaОУЕЭАЫЯИЮЁуеэоаыяиюё]";
    private static final String BORDER_OF_WORD = "\\b";

    @Override
    public Optional<String> removeSymbols(String sourceText) {
        if (sourceText == null) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        String[] words = sourceText.split(SPACE);
        for (String word : words) {
            if (!word.matches(LETTERS)) {
                word = word.replaceAll(PUNCTUATION_MARKS_AND_DIGITS, SPACE);
            }
            builder.append(word).append(SPACE);
        }
        return Optional.of(builder.toString());
    }

    @Override
    public Optional<String> removeWords(String sourceText, int wordLength) {
        if (sourceText == null) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        String[] words = sourceText.split(BORDER_OF_WORD);
        for (String word : words) {
            if (word.length() == wordLength) {
                if (String.valueOf(word.charAt(0)).matches(VOWEL)
                        || String.valueOf(word.charAt(0)).matches(PUNCTUATION_MARKS_AND_DIGITS)) {
                    builder.append(word);
                }
            } else {
                builder.append(word);
            }
        }
        return Optional.of(builder.toString());
    }
}
