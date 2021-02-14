package ru.job4j.examples.ex;

public class Fact {
    public static void main(String[] args) {
        int rsl = calc(3);
        int rslWithException = calc(-1);
    }

    public static int calc(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Parameter n should be greater than 0");
        }

        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}