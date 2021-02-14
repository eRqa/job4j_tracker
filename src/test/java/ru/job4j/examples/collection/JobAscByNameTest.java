package ru.job4j.examples.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobAscByNameTest {

    @Test
    public void whenAscCompareByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(
                new Job("ABC", 2),
                new Job("XYZ", 3)
        );
        assertThat(rsl, lessThan(0));
    }

}