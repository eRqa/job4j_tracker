package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {

        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            char leftChat = left.charAt(i);
            char rightChar = right.charAt(i);
            if (leftChat != rightChar) {
                return leftChat - rightChar;
            }
        }

        return left.length() - right.length();
    }
}