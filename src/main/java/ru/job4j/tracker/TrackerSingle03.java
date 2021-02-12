package ru.job4j.tracker;

public class TrackerSingle03 {

    private static final MemTracker TRACKER = new MemTracker();

    private TrackerSingle03() {

    }

    public static MemTracker getTracker() {
        return TRACKER;
    }

}
