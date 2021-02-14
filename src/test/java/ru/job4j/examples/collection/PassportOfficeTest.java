package ru.job4j.examples.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenAdd3Citizens() {
        Citizen citizenPetr = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenPavel = new Citizen("PP542112", "Pavel Vlasov");
        Citizen citizenVazgen = new Citizen("AV74421", "Vazgen Litr");
        PassportOffice office = new PassportOffice();
        office.add(citizenPetr);
        office.add(citizenPavel);
        office.add(citizenVazgen);
        assertThat(office.get(citizenPetr.getPassport()), is(citizenPetr));
        assertThat(office.get(citizenPavel.getPassport()), is(citizenPavel));
        assertThat(office.get(citizenVazgen.getPassport()), is(citizenVazgen));
    }

    @Test
    public void whenGetWith3Citizens() {
        Citizen citizenPetr = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenPavel = new Citizen("PP542112", "Pavel Vlasov");
        Citizen citizenVazgen = new Citizen("AV74421", "Vazgen Litr");
        PassportOffice office = new PassportOffice();
        office.add(citizenPetr);
        office.add(citizenPavel);
        office.add(citizenVazgen);
        assertThat(office.get("2f44a"), is(citizenPetr));
        assertThat(office.get("PP542112"), is(citizenPavel));
        assertThat(office.get("AV74421"), is(citizenVazgen));
    }
}