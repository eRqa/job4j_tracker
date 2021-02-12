package ru.job4j.tracker;

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
    public boolean execute(Input input, MemTracker tracker) {
        String msg = "Enter id";
        int itemId = Integer.parseInt(input.askStr(msg));
        if (tracker.delete(itemId)) {
            out.println("Successful delete");
        } else {
            out.println("Failed delete");
        }

        return true;
    }
}
