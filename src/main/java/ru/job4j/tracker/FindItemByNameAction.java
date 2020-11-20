package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {

    private final Output out;

    public FindItemByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name");
        Item[] arrItems = tracker.findByName(name);
        if (arrItems.length > 0) {
            System.out.println(arrItems.length + " items found");
            for (Item curItem :
                    arrItems) {
                System.out.println(curItem.toString());
            }
        } else {
            System.out.println("no items found");
        }
        return true;
    }
}
