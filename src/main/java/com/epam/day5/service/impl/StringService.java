package com.epam.day5.service.impl;

import com.epam.day5.service.RemoveLetter;
import com.epam.day5.service.ReplaceLetter;

public class StringService implements ReplaceLetter, RemoveLetter {

    private static final String SPACE = " ";
    private static final String LETTERS_AND_DIGITS = "[\\p{LD}-]";
    private static final String PUNCTUATION_MARKS = "\\p{Punct}";
    private static final String VOWEL = "[EYUIOAeyuioaОУЕЭАЫЯИЮЁуеэоаыяиюё]";
    private static final String BORDER_OF_WORD = "\\b";

    @Override
    public String removeSymbols(String sourceText) {
        StringBuilder builder = new StringBuilder();
        String[] words = sourceText.split(SPACE);
        for (String word : words) {
            if (!word.matches(LETTERS_AND_DIGITS)) {
                word = word.replaceAll(PUNCTUATION_MARKS, SPACE);
            }
            builder.append(word).append(SPACE);
        }
        return builder.toString();
    }

    @Override
    public String removeWords(String sourceText, int wordLength) {
        StringBuilder builder = new StringBuilder();
        String[] words = sourceText.split(BORDER_OF_WORD);
        for (String word : words) {
            if (word.length() == wordLength) {
                if (String.valueOf(word.charAt(0)).matches(VOWEL)
                        || String.valueOf(word.charAt(0)).matches(PUNCTUATION_MARKS)) {
                    builder.append(word);
                }
            } else {
                builder.append(word);
            }
        }
        return builder.toString();
    }

    @Override
    public String replaceLetterByIndexInWord(String sourceText, int index, char newSymbol) {
        StringBuilder builder = new StringBuilder();
        String[] words = sourceText.split(SPACE);
        for (String word : words) {
            if (word.length() >= index && String.valueOf(word.charAt(index - 1)).matches(LETTERS_AND_DIGITS)) {
                builder.append(word, 0, index - 1).append(newSymbol).append(word.substring(index));
            } else {
                builder.append(word);
            }
            builder.append(SPACE);
        }
        return builder.toString();
    }

    @Override
    public String fixTypoInText(String sourceText, String typoRegex, String correctSymbol) {
        StringBuilder builder = new StringBuilder();
        String[] words = sourceText.split(SPACE);
        for (String word : words) {
            builder.append(word.replaceAll(typoRegex, correctSymbol)).append(SPACE);
        }
        return builder.toString();
    }

    @Override
    public String replaceWords(String sourceText, int wordLength, String subLine) {
        StringBuilder builder = new StringBuilder();
        String[] words = sourceText.split(BORDER_OF_WORD);
        for (String word : words) {
            if (word.length() == wordLength) {
                builder.append(subLine);
            } else {
                builder.append(word);
            }
        }
        return builder.toString();
    }
}
