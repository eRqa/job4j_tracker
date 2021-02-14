package ru.job4j.tracker.singleton;

import ru.job4j.tracker.MemTracker;

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
