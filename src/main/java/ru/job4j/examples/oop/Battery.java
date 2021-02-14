package ru.job4j.examples.oop;

public class Battery {

    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public int getLoad() {
        return this.load;
    }

    void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

}
