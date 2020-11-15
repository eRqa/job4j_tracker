package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String msg = "Enter id";
        int itemId = Integer.parseInt(input.askStr(msg));
        if (tracker.delete(itemId)) {
            System.out.println("Successful delete");
        } else {
            System.out.println("Failed delete");
        }

        return true;
    }
}
