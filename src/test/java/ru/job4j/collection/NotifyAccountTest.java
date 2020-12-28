package ru.job4j.collection;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        Set<Account> expect = Set.of(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenSentToFourAccounts() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001"),
                new Account("142", "Pavel Vlasov", "1334"),
                new Account("142", "Pavel Vlasov", "1334"),
                new Account("142", "Pavel Vlasov", "222")
        );
        Set<Account> expected = Set.of(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001"),
                        new Account("142", "Pavel Vlasov", "1334"),
                        new Account("142", "Pavel Vlasov", "222")
        );
        assertThat(NotifyAccount.sent(accounts), is(expected));
    }
}