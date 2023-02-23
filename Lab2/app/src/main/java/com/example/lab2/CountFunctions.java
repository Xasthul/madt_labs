package com.example.lab2;

import java.util.ArrayList;
import java.util.Arrays;

public class CountFunctions {
    static int countWords(String text) {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(text.split("[ .,]+")));
        if (words.size() > 0 && words.get(0).equals("")) {
            words.remove(0);
        }
        return words.size();
    }

    static int countChars(String text) {
        return text.length();
    }
}
