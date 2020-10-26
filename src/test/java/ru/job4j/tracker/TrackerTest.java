package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

//    @Test
//    public void whenFindByNameJob4jWithNullItem() {
//        Tracker tracker = new Tracker();
//
//        Item itemJob4j = new Item();
//        itemJob4j.setName("Job4J");
//        tracker.add(itemJob4j);
//        Item nullItem = new Item();
//        tracker.add(nullItem);
//        Item[] result = tracker.findByName("Job4J");
//        assertThat(result[0].getName(), is(itemJob4j.getName()));


//    }

    @Test
    public void whenFindByNameJob4jThenArrayWithOneItem() {
        Tracker tracker = new Tracker();

        Item itemJob4j = new Item();
        itemJob4j.setName("Job4J");
        tracker.add(itemJob4j);
        Item[] result = tracker.findByName("Job4J");
        assertThat(result[0].getName(), is(itemJob4j.getName()));

    }

    @Test
    public void whenTwoItemsAndFindByNameJob4jThenArrayWithOneItem() {
        Tracker tracker = new Tracker();

        Item itemJob4j = new Item();
        itemJob4j.setName("Job4J");
        tracker.add(itemJob4j);
        Item newTask = new Item();
        newTask.setName("Test task");
        tracker.add(newTask);
        Item[] result = tracker.findByName("Job4J");
        assertThat(result[0].getName(), is(itemJob4j.getName()));

    }

    @Test
    public void whenFindByNameJob4jThenArrayWithTwoItems() {
        Tracker tracker = new Tracker();

        Item itemJob4j = new Item();
        itemJob4j.setName("Job4J");
        Item newTask = new Item();
        newTask.setName("Job4J");
        tracker.add(newTask);
        tracker.add(itemJob4j);
        Item[] result = tracker.findByName("Job4J");
        assertThat(result[0].getName(), is("Job4J"));
        assertThat(result[1].getName(), is("Job4J"));

    }

    @Test
    public void whenFindByNameNotAddedItem() {
        Tracker tracker = new Tracker();

        Item itemJob4j = new Item();
        itemJob4j.setName("taskCreateNewClass");
        Item newTask = new Item();
        newTask.setName("taskTestNewClass");
        tracker.add(newTask);
        tracker.add(itemJob4j);
        Item[] result = tracker.findByName("Job4J");
        assertThat(result.length, is(0));

    }

}