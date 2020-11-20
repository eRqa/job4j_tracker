package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        String msg = "Enter id";
        int itemId = Integer.parseInt(input.askStr(msg));
        Item foundItem = tracker.findById(itemId);
        if (foundItem != null) {
            System.out.println(foundItem.toString());
        } else {
            System.out.println("No items with this id found");
        }

        return true;
    }
}
