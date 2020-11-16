package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

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
                new ReplaceItemAction(),
                new FindItemByNameAction(),
                new FindItemByIdAction(),
                new ShowAllItemsAction(),
                new DeleteItemAction(),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
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
                new ReplaceItemAction(),
                new FindItemByNameAction(),
                new FindItemByIdAction(),
                new ShowAllItemsAction(),
                new DeleteItemAction(),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
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
                new ReplaceItemAction(),
                new FindItemByNameAction(),
                new FindItemByIdAction(),
                new ShowAllItemsAction(),
                new DeleteItemAction(),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("ItemName2"));
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
                new ReplaceItemAction(),
                new FindItemByNameAction(),
                new FindItemByIdAction(),
                new ShowAllItemsAction(),
                new DeleteItemAction(),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("EditedItem"));
        assertThat(tracker.findAll()[1].getName(), is("ItemName2"));
    }

    /*
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        StartUI.replaceItem(tracker, new StubInput(answers));
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("First item");
        Item secondItem = new Item("Second item");
        Item thirdItem = new Item("Third item");

        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);

        String[] answers = {"2"};

        StartUI.deleteItem(tracker, new StubInput(answers));

        Item deleted = tracker.findById(secondItem.getId());
        assertNull(deleted);

    }

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

*/
}