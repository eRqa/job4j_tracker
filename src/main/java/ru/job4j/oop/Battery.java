package ru.job4j.oop;

public class Battery {

    private int load;

    public int getLoad() {
        return this.load;
    }

    public Battery(int load) {
        this.load = load;
    }

    void exchange(Battery another) {
        int tmpThisLoad = this.load;
        this.load -= tmpThisLoad;
        another.load += tmpThisLoad;
    }

}
