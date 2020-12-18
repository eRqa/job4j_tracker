package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("newEMail@gmail.com", "Pavel Vlasov");
        hashMap.put("anotherEMail@gmail.com", "Someone");

        for (String key
                : hashMap.keySet()) {
            System.out.println("Key = " + key + " : value = " + hashMap.get(key));
        }
        
    }

}
