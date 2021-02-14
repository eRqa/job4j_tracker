package ru.job4j.examples.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {

        String wordLeft = left.replaceAll("\\D+", "");
        String wordRight = right.replaceAll("\\D+", "");

        int digitLeft = Integer.parseInt(wordLeft);
        int digitRight = Integer.parseInt(wordRight);

        return digitLeft - digitRight;
    }

}