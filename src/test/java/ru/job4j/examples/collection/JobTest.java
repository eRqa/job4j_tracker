package ru.job4j.examples.collection;

import org.junit.Test;

import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenAscComparatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenDescComparatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority
                = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareSameNameAndDifferentPriority() {
        Comparator<Job> cmpNamePriority
                = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Task", 2),
                new Job("Task", 4)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareSameNameAndDifferentPriority2() {
        Comparator<Job> cmpNamePriority
                = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Task", 4),
                new Job("Task", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenASCCompareSameNameAndDifferentPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Task", 2),
                new Job("Task", 4)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenASCCompareSameNameAndDifferentPriority2() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Task", 4),
                new Job("Task", 2)
        );
        assertThat(rsl, greaterThan(0));
    }
}