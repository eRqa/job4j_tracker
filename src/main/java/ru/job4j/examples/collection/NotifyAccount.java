package ru.job4j.examples.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotifyAccount {
    public static Set<Account> sent(List<Account> accounts) {
        return new HashSet<>(accounts);
    }
}