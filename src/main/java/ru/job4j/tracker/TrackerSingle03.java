package ru.job4j.tracker;

public class TrackerSingle03 {

    private static final Tracker TRACKER = new Tracker();

    private TrackerSingle03() {

    }

    public static Tracker getTracker() {
        return TRACKER;
    }

}
