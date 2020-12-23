package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> left.getSize() - right.getSize();
        Arrays.sort(atts, comparator);

        Comparator<Attachment> cmpText = (left, right) -> {
            System.out.println("compare " + left.getName() + " : " + right.getName());
            return left.getName().compareTo(right.getName());
        };
        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("compare " + left.getSize() + " : " + right.getSize());
            return left.getSize() - right.getSize() ;
        };
    }

}