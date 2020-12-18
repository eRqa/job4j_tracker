package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingle02Test {

    @Test
    public void whengetTracker() {
        Trackersingle01 trackerFirst = Trackersingle01.TRACKER;
        Trackersingle01 trackerSecond = Trackersingle01.TRACKER;
        assertThat(trackerFirst, is(trackerSecond));
    }
}