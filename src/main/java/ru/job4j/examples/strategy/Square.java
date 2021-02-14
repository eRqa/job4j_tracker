package ru.job4j.examples.strategy;

public class Square implements Shape {

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    "_________" + ln
                + "|   :)  |" + ln
                + "|_______|" + ln;
    }

    public static void main(String[] args) {
        System.out.println(new Triangle().draw());
    }

}
