package com.epam.day5.service;

import com.epam.day5.exception.CustomException;
import com.epam.day5.reader.ReaderFromFile;
import com.epam.day5.service.impl.RegexService;
import com.epam.day5.service.impl.StringService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws CustomException {
        ReaderFromFile reader = new ReaderFromFile();
        List<String>list = reader.readFromFile("data/dataFile.txt");
        StringService l = new StringService();
        RegexService r = new RegexService();
        System.out.println(l.replaceLetterByIndexInWord(list.get(0), 3, '@'));
        System.out.println(r.replaceLetterByIndexInWord(list.get(0), 3, '@'));
        System.out.println(l.removeSymbols(list.get(0)));
        System.out.println(r.removeSymbols(list.get(0)));
        System.out.println(l.removeWords(list.get(0), 4));
        System.out.println(r.removeWords(list.get(0), 4));
        System.out.println(l.replaceWords(list.get(0), 4, "пиздец"));
        System.out.println(r.replaceWords(list.get(0), 4, "пиздец"));
        System.out.println(l.fixTypoInText(list.get(0), "[Ии]с", "ga"));
        System.out.println(r.fixTypoInText(list.get(0), "[Ии]с", "пa"));
    }
}