package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.comparators.SortSortItemByNameASC;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortSortItemByNameASCTest {

    @Test
    public void whenCompareWithThreeItems() {
        List<Item> items = Arrays.asList(
                new Item("1", "third"),
                new Item("2", "second"),
                new Item("3", "first")
        );
        Collections.sort(items, new SortSortItemByNameASC());
        assertThat(items.get(0).getName(), is("first"));
        assertThat(items.get(1).getName(), is("second"));
        assertThat(items.get(2).getName(), is("third"));
    }

    @Test
    public void whenCompare() {
        List<Item> items = Arrays.asList(
                new Item("1", "ABC"),
                new Item("2", "ZZZ"),
                new Item("3", "DEF")
        );
        Collections.sort(items, new SortSortItemByNameASC());
        assertThat(items.get(0).getName(), is("ABC"));
        assertThat(items.get(1).getName(), is("DEF"));
        assertThat(items.get(2).getName(), is("ZZZ"));
    }
}