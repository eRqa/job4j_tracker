package ru.job4j.examples.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class JobDescByNameTest {

    @Test
    public void whenDescCompareByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("ABC", 2),
                new Job("XYZ", 3)
        );
        assertThat(rsl, greaterThan(0));
    }
}