package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction {

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
            System.out.println("Successful change item");
        } else {
            System.out.println("Failed change");
        }
        return true;
    }
}
