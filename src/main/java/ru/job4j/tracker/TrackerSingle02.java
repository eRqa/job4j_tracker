package ru.job4j.tracker;

public class TrackerSingle02 {

    private static MemTracker trackerSingle;

    private TrackerSingle02() {

    }

    public static MemTracker getTracker() {
        if (trackerSingle == null) {
            trackerSingle = new MemTracker();
        }
        return trackerSingle;
    }
}
