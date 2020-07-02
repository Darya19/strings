package com.epam.day5.service.impl;

import com.epam.day5.service.RemoveLetter;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveLetterRegexService implements RemoveLetter {

    private static final String SPACE = " ";
    private static final String PUNCTUATION_MARKS_AND_DIGITS = "[\\p{Punct}\\p{Digit}]";
    private static final String VOWELS = "[EYUIOAeyuioaОУЕЭАЫЯИЮЁуеэоаыяиюё]";
    private static final String REGEX_WORD = "\\b[\\p{LD}]+\\b";

    @Override
    public Optional<String> removeSymbols(String sourceText) {
        if (sourceText == null) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile(PUNCTUATION_MARKS_AND_DIGITS);
        Matcher matcher = pattern.matcher(sourceText);
        while (matcher.find()) {
            builder.append(matcher.replaceAll(SPACE)).append(SPACE);
        }
        return Optional.of(builder.toString());
    }

    @Override
    public Optional<String> removeWords(String sourceText, int wordLength) {
        if (sourceText == null) {
            return Optional.empty();
        }
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX_WORD);
        Matcher matcher = pattern.matcher(sourceText);
        while (matcher.find()) {
            if (matcher.group().length() == wordLength
                    && !String.valueOf(matcher.group().charAt(0)).matches(VOWELS)) {
                builder.append(SPACE);
            } else {
                builder.append(matcher.group()).append(SPACE);
            }
        }
        return Optional.of(builder.toString());
    }
}
