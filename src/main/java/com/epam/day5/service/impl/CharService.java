package com.epam.day5.service.impl;

import com.epam.day5.service.RemoveLetter;
import com.epam.day5.service.ReplaceLetter;

public class CharService implements ReplaceLetter, RemoveLetter {

    @Override
    public String removeSymbols(String sourceText) {
        return null;
    }

    @Override
    public String removeWords(String sourceText, int wordLength) {
        return null;
    }

    @Override
    public String replaceLetterByIndexInWord(String sourceText, int index, char newSymbol) {
        return null;
    }

    @Override
    public String fixTypoInText(String sourceText, String typo, String correctSymbol) {
        return null;
    }

    @Override
    public String replaceWords(String sourceText, int wordLength, String subLine) {
        return null;
    }
}
