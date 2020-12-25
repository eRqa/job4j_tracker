package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollect() {
        List<Profile> profiles = new ArrayList<>();
        Address address1 = new Address("Moscow",
                                    "Leninskaya",
                                    3,
                                    3);
        Address address2 = new Address("SPb",
                                    "Leninskaya",
                                    2,
                                    2);
        Address address3 = new Address("Omsk",
                                    "Leninskaya",
                                    4,
                                    4);
        Address address4 = new Address("Omsk",
                                    "Leninskaya",
                                    4,
                                    4);
        profiles.add(new Profile(address1));
        profiles.add(new Profile(address2));
        profiles.add(new Profile(address3));

        Profiles profCollect = new Profiles();
        List<Address> act = profCollect.collect(profiles);

        List<Address> expected = Arrays.asList(address1,
                                                address3,
                                                address2);

        assertThat(act, is(expected));

    }
}