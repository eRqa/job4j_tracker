package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingle_04Test {

    @Test
    public void getTracker() {
        Tracker trackerFirst = TrackerSingle_04.getTracker();
        Tracker trackerSecond = TrackerSingle_04.getTracker();
        assertThat(trackerFirst, is(trackerSecond));
    }
}