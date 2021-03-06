package ru.job4j.examples.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .sorted(new ProfilesASCComparator())
                .distinct()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }
}
