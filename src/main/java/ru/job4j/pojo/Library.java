package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {

        Book atlasShrugged = new Book("Atlas Shrugged", 3000);
        Book americanTragedy = new Book("American Tragedy", 900);
        Book financier = new Book("Financier", 1200);
        Book cleanCode = new Book("Clean Code", 1350);

        Book[] arr = new Book[4];
        arr[0] = atlasShrugged;
        arr[1] = americanTragedy;
        arr[2] = financier;
        arr[3] = cleanCode;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }

        Book tmpBook;
        tmpBook = arr[0];

        arr[0] = arr[3];
        arr[3] = tmpBook;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getName().equals("Clean Code")) {
                System.out.println(arr[i].toString());
            }
        }

    }
}
