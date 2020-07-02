package com.epam.day5.service;

import java.util.Optional;

public interface ReplaceLetter {
    public Optional<String> replaceLetterByIndexInWord(String sourceText, int index, char newSymbol);

    public Optional<String> fixTypoInText(String sourceText, String typo, String correctSymbol);

    public Optional<String> replaceWords(String sourceText, int wordLength, String subLine);
}
