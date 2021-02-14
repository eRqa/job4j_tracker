package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.singleton.TrackerSingle03;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingle03Test {

    @Test
    public void whenGetTracker() {
        MemTracker trackerFirst = TrackerSingle03.getTracker();
        MemTracker trackerSecond = TrackerSingle03.getTracker();
        assertThat(trackerFirst, is(trackerSecond));
    }
}