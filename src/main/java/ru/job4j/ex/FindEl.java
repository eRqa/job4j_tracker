package ru.job4j.ex;

public class FindEl {

    public static void main(String[] args) {
        String[] values = new String[] {"E1", "E2"};
        try {
            int index = indexOf(values, "E3");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {

        int rsl = -1;

        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }

        if (rsl == -1) {
            throw new ElementNotFoundException("Value is not found");
        }

        return rsl;
    }
}