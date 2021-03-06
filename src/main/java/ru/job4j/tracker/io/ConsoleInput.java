package ru.job4j.tracker.io;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner sc = new Scanner(System.in);
    
    @Override
    public String askStr(String question) {
        System.out.println(question);
        return sc.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }
}
