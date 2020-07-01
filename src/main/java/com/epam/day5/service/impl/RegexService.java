package com.epam.day5.service.impl;

import com.epam.day5.service.RemoveLetter;
import com.epam.day5.service.ReplaceLetter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexService implements ReplaceLetter, RemoveLetter {

    private static final String SPACE = " ";
    private static final String PUNCTUATION_MARKS = "\\p{Punct}";
    private static final String VOWELS = "[EYUIOAeyuioaОУЕЭАЫЯИЮЁуеэоаыяиюё]";
    private static final String REGEX_WORD = "\\b[\\p{LD}]+\\b";

    @Override
    public String removeSymbols(String sourceText) {
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile(PUNCTUATION_MARKS);
        Matcher matcher = pattern.matcher(sourceText);
        while (matcher.find()) {
            builder.append(matcher.replaceAll(SPACE)).append(SPACE);
        }
        return builder.toString();
    }

    @Override
    public String removeWords(String sourceText, int wordLength) {
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX_WORD);
        Matcher matcher = pattern.matcher(sourceText);
        while (matcher.find()) {
            if (matcher.group().length() == wordLength
                    && !String.valueOf(matcher.group().charAt(0)).matches(VOWELS)) {
               builder.append(SPACE);}
            else {builder.append(matcher.group()).append(SPACE);}
            }
return builder.toString();
    }

    @Override
    public String replaceLetterByIndexInWord(String sourceText, int index, char newSymbol) {
        Pattern pattern = Pattern.compile("\\b(\\p{LD}{"+ (index - 1)+"})(\\p{LD})([[\\p{LD}][\\p{Punct}]]*)");
            Matcher matcher = pattern.matcher(sourceText);
        return matcher.replaceAll("$1" + newSymbol + "$3");

    }

    @Override
    public String fixTypoInText(String sourceText, String typoRegex, String correctSymbol) {
        Pattern pattern = Pattern.compile(typoRegex);
            Matcher matcher = pattern.matcher(sourceText);
        return matcher.replaceAll(correctSymbol);
    }

    @Override
    public String replaceWords(String sourceText, int wordLength, String subLine) {
        Pattern pattern = Pattern.compile("\\b\\p{LD}{"+ wordLength+"}\\b");
        Matcher matcher = pattern.matcher(sourceText);
        return matcher.replaceAll(subLine);
    }
}
