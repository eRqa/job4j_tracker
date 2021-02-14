package ru.job4j.examples.ex;

public class Find {
    public static String get(String[] data, int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index out of bound");
        }
        return data[index];

    }

    public static void main(String[] args) {
        String[] data = {"onw", "two", "three"};
        String rsl = Find.get(data, 0);
        String rsl2 = Find.get(data, 5);
        System.out.println(rsl);
        System.out.println(rsl2);
    }
}