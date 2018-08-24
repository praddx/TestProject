package ru.plahotin.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainStreamTest {

    public static void main(String[] args) {
        List<Integer> strings = new ArrayList<>();
        strings.add(1);

        System.out.println(strings.stream().map(String::valueOf).collect(Collectors.joining("/", "BLA", "")));
    }
}
