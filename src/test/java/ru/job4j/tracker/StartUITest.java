package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(tracker, input);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenAddThreeItems() {
        String[] answers = {"Fix PC", "Wash the dishes", "Go for a walk"};
        String[] expected = {"Fix PC", "Wash the dishes", "Go for a walk"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(tracker, input);
        StartUI.createItem(tracker, input);
        StartUI.createItem(tracker, input);

        Item[] allCreated = tracker.findAll();

        assertThat(allCreated[0].getName(), is(expected[0]));
        assertThat(allCreated[1].getName(), is(expected[1]));
        assertThat(allCreated[2].getName(), is(expected[2]));
    }

}