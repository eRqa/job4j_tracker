package ru.job4j.tracker;

public class TrackerSingle_03 {

    private static final Tracker tracker = new Tracker();

    private TrackerSingle_03() {

    }

    public static Tracker getTracker() {
        return tracker;
    }

}
