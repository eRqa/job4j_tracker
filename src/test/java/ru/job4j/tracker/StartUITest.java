package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"2", "0"});
        Tracker tracker = new Tracker();
        UserAction[] action = {new ExitAction()};
        new StartUI(out).init(in, tracker, action);
        assertThat(out.toString(), is(String.format(
                "Menu.%n"
                        + "0. === Exit ===%n"
                        + "Wrong input, you can select: 0 .. 0%n"
                        + "Menu.%n"
                        + "0. === Exit ===%n")));
    }

    @Test
    public void whenShowAllItemsAction() {
        Output out = new StubOutput();
        Input input = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        UserAction[] action = {new ShowAllItemsAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, action);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. === Show all items ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator()
                + "No one item found" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. === Show all items ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "Task One", "1"});
        UserAction[] action = {new FindItemByNameAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, action);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. === Find item by name ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator()
                + "no items found" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. === Find item by name ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] action = {new FindItemByIdAction(out), new ExitAction()};
        Input input = new StubInput(new String[] {"0", "14", "1"});
        new StartUI(out).init(input, tracker, action);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. === Find item by id ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator()
                + "No items with this id found" + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. === Find item by id ===" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "6"}
        );
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ReplaceItemAction(output),
                new FindItemByNameAction(output),
                new FindItemByIdAction(output),
                new ShowAllItemsAction(output),
                new DeleteItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenDeleteItemWithId2() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "0", "ItemName2", "5", "2", "6"}
        );
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        UserAction[] actions = {
                new CreateAction(output),
                new ReplaceItemAction(output),
                new FindItemByNameAction(output),
                new FindItemByIdAction(output),
                new ShowAllItemsAction(output),
                new DeleteItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenDeleteItemWithId1() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "0", "ItemName2", "5", "1", "6"}
        );
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ReplaceItemAction(output),
                new FindItemByNameAction(output),
                new FindItemByIdAction(output),
                new ShowAllItemsAction(output),
                new DeleteItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("ItemName2"));
    }

    @Test
    public void whenReplaceItemWithId1() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "0", "ItemName2", "1", "1", "EditedItem", "6"}
        );
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ReplaceItemAction(output),
                new FindItemByNameAction(output),
                new FindItemByIdAction(output),
                new ShowAllItemsAction(output),
                new DeleteItemAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("EditedItem"));
        assertThat(tracker.findAll().get(1).getName(), is("ItemName2"));
    }

}