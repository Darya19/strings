package com.epam.day5.service;

public interface ReplaceLetter {
    public String replaceLetterByIndexInWord(String sourceText,int index, char newSymbol);

    public String fixTypoInText(String sourceText, String typo, String correctSymbol);

    public String replaceWords(String sourceText, int wordLength, String subLine);
}
