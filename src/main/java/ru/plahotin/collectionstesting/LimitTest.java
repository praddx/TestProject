package ru.plahotin.collectionstesting;

import java.util.ArrayList;
import java.util.List;

public class LimitTest {

    public static void main(String[] args) {
        List<String> list = null;// = new ArrayList<>();

//        list.add("1");
//        list.add("3");

        list.stream().limit(4).forEach(System.out::println);
    }
}
