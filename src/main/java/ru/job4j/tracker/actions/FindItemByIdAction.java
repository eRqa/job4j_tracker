package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.Store;

public class FindItemByIdAction implements UserAction {

    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String msg = "Enter id";
        String itemId = input.askStr(msg);
        Item foundItem = tracker.findById(itemId);
        if (foundItem != null) {
            out.println(foundItem.toString());
        } else {
            out.println("No items with this id found");
        }

        return true;
    }
}
