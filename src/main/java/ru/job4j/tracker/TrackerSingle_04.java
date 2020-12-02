package ru.job4j.tracker;

public class TrackerSingle_04 {
    private TrackerSingle_04() {

    }

    public static Tracker getTracker(){
        return Holder.TRACKER;
    }

    private static final class Holder {
        private static final Tracker TRACKER = new Tracker();
    }
}
