package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            System.out.println("Can't find user by passport " + passport);
            return;
        }

        List<Account> accounts = users.get(user.get());
        if (accounts.contains(account)) {
            System.out.println("User is already has this account");
            return;
        }
        users.get(user.get()).add(account);
    }

    /**
     * Методищет пользователя по паспорту
     * @param passport - паспорт пользователя
     * @return - объект класса {@link User}
     */
    public Optional<User> findByPassport(String passport) {
        return this.users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет пользователя по реквизиту
     * @param passport - паспорт пользователя
     * @param requisite - реквизит счета
     * @return объект класса {@link Account}
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            return Optional.empty();
        }

        List<Account> accounts = users.get(user.get());
        return accounts
                .stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);

        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() - amount >= 0) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }

        return rsl;
    }

}