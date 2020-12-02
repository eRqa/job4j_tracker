package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingle_01Test {

    @Test
    public void whenGetTrackerSingle() {
        Tracker trackerSingleFirst = TrackerSingle_02.getTracker();
        Tracker trackerSingleSecond = TrackerSingle_02.getTracker();
        assertThat(trackerSingleFirst, is(trackerSingleSecond));
    }
}