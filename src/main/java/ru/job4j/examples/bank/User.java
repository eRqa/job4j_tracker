package ru.job4j.examples.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных User
 * @author Vlasov Pavel
 * @version 1.0
 */
public class User {
    /**
     * Хранение паспорта пользователя осуществляется в переменной типа String
     */
    private String passport;
    /**
     * Хранение имени пользователя осуществляется в переменной типа String
     */
    private String username;

    /**
     * Конструктор обеспечивает инициализацию полей passport и username
     * @param passport - паспорт пользователя
     * @param username - имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}