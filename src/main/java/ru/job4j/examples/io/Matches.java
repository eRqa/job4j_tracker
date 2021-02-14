package ru.job4j.examples.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {

        int matchesCount = 11;
        Scanner sc = new Scanner(System.in);
        boolean firstOneWon = false;

        while (matchesCount != 0) {

            System.out.println("Введите количество списек от 1 до 3");
            int select = Integer.parseInt(sc.nextLine());

            if (select < 1 || select > 3) {
                System.out.println("Выбрать число можно только из диапозона от 1 до 3");
                continue;
            }

            if (matchesCount - select < 0) {
                System.out.println("Нельзя взять спичек больше чем лежит на столе");
                continue;
            }

            matchesCount = matchesCount - select;
            System.out.println("На столе осталось " + matchesCount + " спичек");

            firstOneWon = !firstOneWon;

        }

        String winner = firstOneWon ? "first" : "second";
        System.out.println(winner + " player won");

    }

}
