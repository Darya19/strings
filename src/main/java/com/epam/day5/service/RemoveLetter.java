package com.epam.day5.service;

import java.util.Optional;

public interface RemoveLetter {

    public Optional<String> removeSymbols(String sourceText);

    public Optional<String> removeWords(String sourceText, int wordLength);
}
