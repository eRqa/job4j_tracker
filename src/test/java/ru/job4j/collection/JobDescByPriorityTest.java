package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobDescByPriorityTest {

    @Test
    public void whenCompareByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("ABC", 2),
                new Job("XYZ", 3)
        );
        assertThat(rsl, greaterThan(0));
    }
}