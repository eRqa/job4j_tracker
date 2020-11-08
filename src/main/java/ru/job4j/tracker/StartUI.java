package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            }  else if (select == 1) {
                Item[] allItems = tracker.findAll();

                if (allItems.length > 0) {
                    for (Item curItem:
                            allItems) {
                        System.out.println(curItem.toString());
                    }
                } else {
                    System.out.println("No one item found");
                }

            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.println("Enter id");
                int itemId = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter name");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                if (tracker.replace(itemId, newItem)) {
                    System.out.println("Successful change item");
                } else {
                    System.out.println("Failed change");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.println("Enter id");
                int itemId = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(itemId)) {
                    System.out.println("Successful delete");
                } else {
                    System.out.println("Failed delete");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                System.out.println("Enter id");
                int itemId = Integer.parseInt(scanner.nextLine());
                Item foundItem = tracker.findById(itemId);
                if (foundItem != null) {
                    System.out.println(foundItem.toString());
                } else {
                    System.out.println("No items with this id found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.println("Enter name");
                String name = scanner.nextLine();
                Item[] arrItems = tracker.findByName(name);
                if (arrItems.length > 0) {
                    System.out.println(arrItems.length + " items found");
                    for (Item curItem :
                            arrItems) {
                        System.out.println(curItem.toString());
                    }
                } else {
                    System.out.println("no items found");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

}
