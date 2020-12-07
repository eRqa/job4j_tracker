package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();

        for (int[] ints :
                list) {
            for (int jits :
                    ints) {
                rsl.add(jits);
            }
        }

        return rsl;
    }
}