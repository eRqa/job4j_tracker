package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combineName = person -> person.getName().equals(key);
        Predicate<Person> combineSurname = person -> person.getSurname().equals(key);
        Predicate<Person> combineAddress = person -> person.getAddress().equals(key);
        Predicate<Person> combinePhone = person -> person.getPhone().equals(key);
        Predicate<Person> combine = combineName.or(combineSurname.or(combineAddress.or(combinePhone)));
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}