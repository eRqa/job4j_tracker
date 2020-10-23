package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student pavelVlasov = new Student();
        pavelVlasov.setGroup("elementary_students");
        pavelVlasov.setName("Pavel Vlasov");
        pavelVlasov.setEntered(new Date());

        System.out.println("name = " + pavelVlasov.getName() + "; group = " + pavelVlasov.getGroup()
                            + "; entered = " + pavelVlasov.getEntered());

    }
}
