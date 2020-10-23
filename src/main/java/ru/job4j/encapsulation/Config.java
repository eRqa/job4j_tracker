package ru.job4j.encapsulation;

public class Config {
//    String name; Правило 1) Для всех полей медификатор private;
//    protected int position; Правило 1) Для всех полей медификатор private;
//    public String[] properties; Правило 1) Для всех полей медификатор private;

    private String name;
    private int position;
    private String[] properties;

    public Config(String name) {
        this.name = name;
    }

    //void print() { Использован default вместо public или private;
    public void print() {
        System.out.println(position);
    }

//    protected String getProperty(String key) { Использован protected вместо public или private;
    public String getProperty(String key) {     // Так как это геттер, предполагаю ему нужен public
        return search(key);
    }

    private String search(String key) {
        return key;
    }
}
