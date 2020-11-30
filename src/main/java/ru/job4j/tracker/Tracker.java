package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;
    private static Tracker trackerSingle;

    private Tracker() {

    }

    public static Tracker getTracker() {
        if (trackerSingle == null) {
            trackerSingle = new Tracker();
        }

        return trackerSingle;

    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String name) {

        Item[] rsl = new Item[size];
        int counter = 0;

        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName().equals(name)) {
                rsl[counter] = item;
                counter++;
            }
        }
        return Arrays.copyOf(rsl, counter);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {

        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            this.items[index] = item;
            this.items[index].setId(id);
        }

        return rsl;
    }

    public boolean delete(int id) {

        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {

            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;

        }

        return rsl;
    }

}