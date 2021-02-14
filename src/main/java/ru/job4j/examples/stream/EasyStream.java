package ru.job4j.examples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> data;

    public static EasyStream of(List<Integer> source) {
        EasyStream easyStream = new EasyStream();
        easyStream.data = new ArrayList<>(source);
        return easyStream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> tmpList = new ArrayList<>();
        for (Integer value : data) {
            tmpList.add(fun.apply(value));
        }
        data = tmpList;
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        data.removeIf(value -> !fun.test(value));
        return this;
    }

    public List<Integer> collect() {
        return this.data;
    }
}