package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {
    @Test
    public void extractNumber() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        Set<String> expected = Set.of("1", "2");
        assertThat(FullSearch.extractNumber(tasks), is(expected));
    }

    @Test
    public void extractNumberWhen6Tasks() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "T1"),
                new Task("1", "T2"),
                new Task("1", "T2"),
                new Task("3", "T4"),
                new Task("4", "T5"),
                new Task("5", "T6")
        );
        Set<String> expected = Set.of("1", "3", "4", "5");
        assertThat(FullSearch.extractNumber(tasks), is(expected));
    }
}