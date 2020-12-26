package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковский сервис. Содежрит в себе методы поиска пользователя {@link User},
 * счета пользователя {@link Account} перевода денег
 * @author Vlasov Pavel
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение списка пользователей осуществляется в переменной типа Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод вставляет пользователя User в кллекцию user если отсутствует
     * @param user - объект класса {@link User}
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет счет пользователю если у него нет такого счета
     * @param passport - паспорт пользователя
     * @param account - объект класса {@link Account}
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            System.out.println("Can't find user by passport " + passport);
            return;
        }

        List<Account> accounts = users.get(user);
        if (accounts.contains(account)) {
            System.out.println("User is already has this account");
            return;
        }
        users.get(user).add(account);
    }

    /**
     * Методищет пользователя по паспорту
     * @param passport - паспорт пользователя
     * @return - объект класса {@link User}
     */
    public User findByPassport(String passport) {
        return this.users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет пользователя по реквизиту
     * @param passport - паспорт пользователя
     * @param requisite - реквизит счета
     * @return объект класса {@link Account}
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }

        List<Account> accounts = users.get(user);
        return accounts
                .stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод осуществляет списание с расчетного счета пользователя указанную сумму,
     * в пользу другого счета
     * @param srcPassport - номер паспорта пользователя, который переводит сумму
     * @param srcRequisite - реквизит счета пользователя, с который переводится суммв
     * @param destPassport - номер паспорта пользователя, которому переводится сумма
     * @param destRequisite - реквизит счета пользователя, на который переводится сумма
     * @param amount - сумма перевода
     * @return - true если на счете достаточно средств, иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() - amount >= 0) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }

        return rsl;
    }

}