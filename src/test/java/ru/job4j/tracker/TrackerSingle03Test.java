package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingle03Test {

    @Test
    public void whenGetTracker() {
        Tracker trackerFirst = TrackerSingle03.getTracker();
        Tracker trackerSecond = TrackerSingle03.getTracker();
        assertThat(trackerFirst, is(trackerSecond));
    }
}