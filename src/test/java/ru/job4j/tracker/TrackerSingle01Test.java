package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingle01Test {

    @Test
    public void whenGetTrackerSingle() {
        MemTracker trackerSingleFirst = TrackerSingle02.getTracker();
        MemTracker trackerSingleSecond = TrackerSingle02.getTracker();
        assertThat(trackerSingleFirst, is(trackerSingleSecond));
    }
}