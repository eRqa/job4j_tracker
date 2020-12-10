package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

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

    @Test
    public void whenFindByNameJob4jThenArrayWithOneItem() {
        Tracker tracker = new Tracker();

        Item itemJob4j = new Item();
        itemJob4j.setName("Job4J");
        tracker.add(itemJob4j);
        List<Item> result = tracker.findByName("Job4J");
        assertThat(result.get(0).getName(), is(itemJob4j.getName()));

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
        List<Item> result = tracker.findByName("Job4J");
        assertThat(result.get(0).getName(), is(itemJob4j.getName()));
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
        List<Item>  result = tracker.findByName("Job4J");
        assertThat(result.get(0).getName(), is("Job4J"));
        assertThat(result.get(0).getName(), is("Job4J"));

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
        List<Item> result = tracker.findByName("Job4J");
        assertThat(result.size(), is(0));

    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenReplaceTrackerWith3Items() {
        Tracker tracker = new Tracker();
        Item bugJohny = new Item();
        bugJohny.setName("Bug Johny");
        tracker.add(bugJohny);

        Item bugHarry = new Item();
        bugHarry.setName("Bug Harry");
        tracker.add(bugHarry);

        Item bugMrFord = new Item();
        bugMrFord.setName("Bug Mr Ford");
        tracker.add(bugMrFord);

        int id = bugMrFord.getId();
        tracker.replace(id, bugHarry);
        assertThat(tracker.findById(id).getName(), is("Bug Harry"));
    }

    @Test
    public void whenReplaceTrackerWith3ItemsAndReplace3To1() {
        Tracker tracker = new Tracker();
        Item bugJohny = new Item();
        bugJohny.setName("Bug Johny");
        tracker.add(bugJohny);

        Item bugHarry = new Item();
        bugHarry.setName("Bug Harry");
        tracker.add(bugHarry);

        Item bugMrFord = new Item();
        bugMrFord.setName("Bug Mr Ford");
        tracker.add(bugMrFord);

        int id = bugMrFord.getId();
        tracker.replace(id, bugJohny);
        assertThat(tracker.findById(id).getName(), is("Bug Johny"));
    }

    @Test
    public void whenReplaceTrackerWith3ItemsAndReplace1To3() {
        Tracker tracker = new Tracker();
        Item bugJohny = new Item();
        bugJohny.setName("Bug Johny");
        tracker.add(bugJohny);

        Item bugHarry = new Item();
        bugHarry.setName("Bug Harry");
        tracker.add(bugHarry);

        Item bugMrFord = new Item();
        bugMrFord.setName("Bug Mr Ford");
        tracker.add(bugMrFord);

        int id = bugMrFord.getId();
        tracker.replace(id, bugJohny);
        assertThat(tracker.findById(id).getName(), is("Bug Johny"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDelete1of3() {
        Tracker tracker = new Tracker();

        Item bugJohny = new Item();
        bugJohny.setName("Bug Johny");
        tracker.add(bugJohny);

        Item bugHarry = new Item();
        bugHarry.setName("Bug Harry");
        tracker.add(bugHarry);

        Item bugMrFord = new Item();
        bugMrFord.setName("Bug Mr Ford");
        tracker.add(bugMrFord);

        int id = bugHarry.getId();

        tracker.delete(id);

        assertThat(tracker.findById(id), is(nullValue()));
    }
}