package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        final Airbus airbus = new Airbus("A320");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();

//        airbus = new Airbus("A380"); airbus - final. Можем изменить состояние, но не можем изменить ссылку
        airbus.setName("A380");
        System.out.println(airbus);

        airbus.setName("A380");
        System.out.println(airbus);
    }
}