package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;
import ru.job4j.tracker.Store;

public class DeleteItemAction implements UserAction {

    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String msg = "Enter id";
        String itemId = input.askStr(msg);
        if (tracker.delete(itemId)) {
            out.println("Successful delete");
        } else {
            out.println("Failed delete");
        }

        return true;
    }
}
