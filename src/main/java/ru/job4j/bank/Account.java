package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модкль данных счета пользователя {@link User}
 * @author Vlasov Pavel
 * @version 1.0
 */
public class Account {
    /**
     * Хранение значения реквизита счета осуществляется в переменной типа String
     */
    private String requisite;
    /**
     * Хранение баланса счета осуществляется в переменной типа double
     */
    private double balance;

    /**
     * Конструктор обеспечивает инициализацию полей requisite и balance
     * @param requisite - реквизит счета
     * @param balance - баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}