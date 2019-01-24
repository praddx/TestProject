package ru.plahotin.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStreamTest {

    public static void main(String[] args) {
        List<Person> strings = new ArrayList<>();
        strings.add(new Person());
        strings.add(new Person());
        strings.add(null);
        strings.add(new Person());


//        System.out.println(strings.stream().map(String::valueOf).collect(Collectors.joining("/", "BLA", "")));

//        List<String> list = Stream.of(new String[]{"1", "2", "3"}).filter(s -> s.equals("a")).collect(Collectors.toList());
//
//        System.out.println(list.size());
        strings.stream().peek(e -> {
            if (e != null) {
                e.name = "Brad";
            } else {
                e = new Person();
                e.name = "Paul";
            }
        }).forEach(p -> System.out.println(p.name));
    }

    public static class Person {
        String name;
    }
}
