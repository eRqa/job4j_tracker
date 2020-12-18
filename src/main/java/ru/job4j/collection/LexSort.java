package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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