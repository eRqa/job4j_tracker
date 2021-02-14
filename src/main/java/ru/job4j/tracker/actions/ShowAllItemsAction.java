package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.Store;

import java.util.List;

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
    public boolean execute(Input input, Store tracker) {
        List<Item> allItems = tracker.findAll();

        if (allItems.size() > 0) {
            for (Item curItem
                    : allItems) {
                out.println(curItem.toString());
            }
        } else {
            out.println("No one item found");
        }
        return true;
    }
}
