package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
//        List<Attachment> rsl = new ArrayList<>();
//        for (Attachment att : list) {
//            if (att.getSize() > 100) {
//                rsl.add(att);
//            }
//        }
//        return rsl;
        return filter(list, el -> el.getSize() > 100);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
//        List<Attachment> rsl = new ArrayList<>();
//        for (Attachment att : list) {
//            if (att.getName().contains("bug")) {
//                rsl.add(att);
//            }
//        }
//        return rsl;
        return filter(list, el -> el.getName().contains("bug"));
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> condition) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment attachment : list) {
            if (condition.test(attachment)) {
                rsl.add(attachment);
            }
        }
        return rsl;
    }

}