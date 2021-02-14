package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    @Test
    public void findAll() {
        Store tracker = new SqlTracker();
        tracker.init();
        List<Item> rsl = tracker.findAll();
        assertThat(rsl.get(0).getName(), is("Заполнить начальыне данные в таблице Items"));
        assertThat(rsl.get(0).getId(), is("2"));
        assertThat(rsl.get(1).getName(), is("Реализовать механизм получения заявое из базы данных Tracker"));
        assertThat(rsl.get(1).getId(), is("3"));
    }

    @Test
    public void findByName() {
        Store tracker = new SqlTracker();
        tracker.init();
        List<Item> rsl = tracker.findByName("Заполнить начальыне данные в таблице Items");
        assertThat(rsl.get(0).getName(), is("Заполнить начальыне данные в таблице Items"));
        assertThat(rsl.get(0).getId(), is("2"));
    }

    @Test
    public void findById() {
        Store tracker = new SqlTracker();
        tracker.init();
        Item rsl = tracker.findById("2");
        assertThat(rsl.getName(), is("Заполнить начальыне данные в таблице Items"));
        assertThat(rsl.getId(), is("2"));
    }
}