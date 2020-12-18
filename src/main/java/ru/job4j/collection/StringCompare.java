package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {

        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            char leftChar = left.charAt(i);
            char rightChar = right.charAt(i);
            if (Character.compare(leftChar, rightChar) != 0) {
                return leftChar - rightChar;
            }
        }

        return Integer.compare(left.length(), right.length());
    }
}