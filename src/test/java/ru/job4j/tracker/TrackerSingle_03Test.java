package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingle_03Test {

    @Test
    public void whenGetTracker() {
        Tracker trackerFirst = TrackerSingle_03.getTracker();
        Tracker trackerSecond = TrackerSingle_03.getTracker();
        assertThat(trackerFirst, is(trackerSecond));
    }
}