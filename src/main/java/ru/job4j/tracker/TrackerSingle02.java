package ru.job4j.tracker;

public class TrackerSingle02 {

    private static Tracker trackerSingle;

    private TrackerSingle02() {

    }

    public static Tracker getTracker() {
        if (trackerSingle == null) {
            trackerSingle = new Tracker();
        }
        return trackerSingle;
    }
}
