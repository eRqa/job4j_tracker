package ru.job4j.tracker;

public class TrackerSingle04 {

    private TrackerSingle04() {

    }

    public static MemTracker getTracker() {
        return Holder.TRACKER;
    }

    private static final class Holder {
        private static final MemTracker TRACKER = new MemTracker();
    }
}
