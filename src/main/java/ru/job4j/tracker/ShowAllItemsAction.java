package ru.job4j.tracker;

public class ShowAllItemsAction implements UserAction {

    private final Output out;

    public ShowAllItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();

        if (allItems.length > 0) {
            for (Item curItem :
                    allItems) {
                System.out.println(curItem.toString());
            }
        } else {
            System.out.println("No one item found");
        }
        return true;
    }
}
