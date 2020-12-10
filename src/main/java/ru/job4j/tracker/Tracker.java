package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String name) {

        List<Item> rsl = new ArrayList<>();

        for (Item item :
                items) {
            if (item.getName().equals(name)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(indexOf(id)) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < this.items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);

        if (index != -1) {
            item.setId(items.get(index).getId());
            items.set(indexOf(id), item);
            rsl = true;
        }

        return rsl;
    }

    public boolean delete(int id) {

        boolean rsl = false;
        int index = indexOf(id);

        if (index != -1) {
            this.items.remove(index);
            rsl = true;
        }

        return rsl;
    }

}