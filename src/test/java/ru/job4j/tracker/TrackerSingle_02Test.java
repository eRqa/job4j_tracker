package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingle_02Test {

    @Test
    public void whengetTracker() {
        TrackerSingle_01 trackerFirst = TrackerSingle_01.TRACKER;
        TrackerSingle_01 trackerSecond = TrackerSingle_01.TRACKER;
        assertThat(trackerFirst, is(trackerSecond));
    }
}