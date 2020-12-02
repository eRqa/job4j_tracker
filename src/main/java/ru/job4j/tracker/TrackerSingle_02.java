package ru.job4j.tracker;

public class TrackerSingle_02 {

    private static Tracker trackerSingle;

    private TrackerSingle_02() {

    }

    public static Tracker getTracker() {
        if (trackerSingle == null) {
            trackerSingle = new Tracker();
        }
        return trackerSingle;
    }
}
