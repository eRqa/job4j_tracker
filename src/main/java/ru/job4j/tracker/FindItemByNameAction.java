package ru.job4j.tracker;

import java.util.List;

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
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            out.println(items.size() + " items found");
            for (Item curItem :
                    items) {
                out.println(curItem.toString());
            }
        } else {
            out.println("no items found");
        }
        return true;
    }
}
