package ru.plahotin.collectionstesting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;

public class ComputeTesting {

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("one", Double.valueOf(1));

        Double adder = Double.valueOf(3);

        map.compute("two", (key, oldValue) -> oldValue == null ? adder : Double.sum(oldValue, adder));
        map.compute("one", (key, oldValue) -> oldValue == null ? adder : Double.sum(oldValue, adder));

        map.compute("three", (key, oldValue) -> oldValue == null ? adder : Double.sum(oldValue, adder));
        map.put("five", Double.valueOf(5));
        map.put("1", Double.valueOf(10));


        map.entrySet().forEach(System.out::println);

        for(int i = 0; i < 5; i++) {
            map.values().stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
            System.out.println();
        }
    }
}
