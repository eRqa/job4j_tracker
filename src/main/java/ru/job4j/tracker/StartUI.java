package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {

        Tracker tracker = new Tracker();

        Item job4jTask = new Item();
        job4jTask.setName("5. Хранилище Tracker");
        tracker.add(job4jTask);

        System.out.println(tracker.findById(job4jTask.getId()));

    }

}
