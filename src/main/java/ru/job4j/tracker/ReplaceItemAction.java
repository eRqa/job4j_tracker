package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        int itemId = Integer.parseInt(input.askStr("Enter id"));
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
