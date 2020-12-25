package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ListToMapTest {

    @Test
    public void listToMap() {
        List<Student> students = List.of(
                new Student(50, "Vlasov"),
                new Student(11, "Gavrilov"),
                new Student(11, "Gavrilov"),
                new Student(20, "Petrov"),
                new Student(40, "Kolbasov"),
                new Student(20, "Petrov"));

        Map<String, Student> actual = ListToMap.listToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put(students.get(0).getSurname(), students.get(0));
        expected.put(students.get(2).getSurname(), students.get(2));
        expected.put(students.get(4).getSurname(), students.get(4));
        expected.put(students.get(5).getSurname(), students.get(5));

        assertThat(actual, is(expected));
    }
}