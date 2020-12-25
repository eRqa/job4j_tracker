package ru.job4j.stream;

import java.util.Comparator;

public class ProfilesASCComparator implements Comparator<Profile> {
    @Override
    public int compare(Profile o1, Profile o2) {
        return o1.getAddress().compareTo(o2.getAddress());
    }
}
