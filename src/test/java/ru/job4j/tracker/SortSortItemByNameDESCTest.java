package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortSortItemByNameDESCTest {

    @Test
    public void whenCompareWithThreeItems() {
        List<Item> items = Arrays.asList(
                new Item("1", "third"),
                new Item("2", "second"),
                new Item("3", "first")
        );
        Collections.sort(items, new SortSortItemByNameDESC());
        assertThat(items.get(0).getName(), is("third"));
        assertThat(items.get(1).getName(), is("second"));
        assertThat(items.get(2).getName(), is("first"));
    }

    @Test
    public void whenCompare() {
        List<Item> items = Arrays.asList(
                new Item("1", "ABC"),
                new Item("2", "ZZZ"),
                new Item("3", "DEF")
        );
        Collections.sort(items, new SortSortItemByNameDESC());
        assertThat(items.get(0).getName(), is("ZZZ"));
        assertThat(items.get(1).getName(), is("DEF"));
        assertThat(items.get(2).getName(), is("ABC"));
    }

}