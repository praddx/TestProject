package ru.plahotin.collectionstesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListAddingTest {

    List<String> intList = new ArrayList<>();

    public List<String> getIntList() {
        return intList;
    }

    public void setIntList(List<String> intList) {
        this.intList = intList;
    }

    public static void main(String[] args) {
        ListAddingTest test = new ListAddingTest();

        test.getIntList().add(String.valueOf(1));
        test.getIntList().add(String.valueOf(2));
        test.getIntList().add(String.valueOf(3));

//        String a = String.valueOf(4);
//
//        IntStream.range(4, 6).mapToObj(String::valueOf).collect(Collectors.toCollection(test::getIntList));
//
//        test.getIntList().stream().forEach(System.out::println);
//
//        System.out.println("result {" + new ArrayList<String>().stream().collect(Collectors.joining("!!")) + "}");
//
//        String s = "asdf asdfa asdf asd";
//
//        Stream.of(s).map(str -> str.split(" ")).flatMap(Stream::of).forEach(System.out::println);
        String test1 = "123$ljsf$test";
        char DOLLAR = '\u0024';
        String delim = "\\" + String.valueOf(DOLLAR);
        Stream.of(test1.split(delim)).forEach(System.out::println);
        System.out.println(String.valueOf(DOLLAR));
    }


}
