package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.Store;

public class ReplaceItemAction implements UserAction {

    private final Output out;

    public ReplaceItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String itemId = input.askStr("Enter id");
        String name = input.askStr("Enter name");
        Item newItem = new Item(name);
        if (tracker.replace(itemId, newItem)) {
            out.println("Successful change item");
        } else {
            out.println("Failed change");
        }
        return true;
    }
}
