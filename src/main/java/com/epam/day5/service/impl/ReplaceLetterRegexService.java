package com.epam.day5.service.impl;

import com.epam.day5.service.ReplaceLetter;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceLetterRegexService implements ReplaceLetter {

    @Override
    public Optional<String> replaceLetterByIndexInWord(String sourceText, int index, char newSymbol) {
        if (sourceText == null || index < 0) {
            return Optional.empty();
        }
        Pattern pattern = Pattern.compile("\\b(\\p{LD}{" + (index - 1) + "})(\\p{LD})([[\\p{LD}][\\p{Punct}]]*)");
        Matcher matcher = pattern.matcher(sourceText);
        return Optional.of(matcher.replaceAll("$1" + newSymbol + "$3"));
    }

    @Override
    public Optional<String> fixTypoInText(String sourceText, String typoRegex, String correctSymbol) {
        if (sourceText == null) {
            return Optional.empty();
        }
        Pattern pattern = Pattern.compile(typoRegex);
        Matcher matcher = pattern.matcher(sourceText);
        return Optional.of(matcher.replaceAll(correctSymbol));
    }

    @Override
    public Optional<String> replaceWords(String sourceText, int wordLength, String subLine) {
        if (sourceText == null) {
            return Optional.empty();
        }
        Pattern pattern = Pattern.compile("\\b\\p{LD}{" + wordLength + "}\\b");
        Matcher matcher = pattern.matcher(sourceText);
        return Optional.of(matcher.replaceAll(subLine));
    }
}
