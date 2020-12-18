package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void whenSortMultiLevelTasks() {
        String[] input = {
                "1.1.4 Task.",
                "12 Task."
        };
        String[] out = {
                "1.1.4 Task.",
                "12. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sort() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "4. Task.",
                "6. Task.",
                "2. Task.",
                "11. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "4. Task.",
                "6. Task.",
                "10. Task.",
                "11. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}