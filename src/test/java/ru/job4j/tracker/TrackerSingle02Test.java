package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.singleton.TrackerSingle01;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingle02Test {

    @Test
    public void whengetTracker() {
        TrackerSingle01 trackerFirst = TrackerSingle01.TRACKER;
        TrackerSingle01 trackerSecond = TrackerSingle01.TRACKER;
        assertThat(trackerFirst, is(trackerSecond));
    }
}