package ru.plahotin.collectionstesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectionsTestingMain {
    public static void main(String[] args) {
        int[] array = new int[]{};

//        int[] newArray = Arrays.copyOf(array, array.length + 1);
//        System.out.println(array.length);
//        System.out.println(newArray.length);

//        boolean b = false;
//        if (b) System.out.println(1);
//        if (!b) System.out.println(-1);
        Integer[] ar = {1, 2, 3, 4};

        List<Integer> list = new ArrayList<>();
//        list.addAll(Arrays.asList(ar));
        if (!list.contains(5))
        //list.add(5);
            System.out.println("works");

        //list.forEach(System.out::println);

//        Integer[] newAr = new Integer[]{};
//        System.out.println(newAr.length);
//        list.toArray(newAr);
//        System.out.println(newAr.length);
//        System.out.println(list.toArray(newAr).length);
//
//        Stream.of(list.toArray(new Integer[]{})).forEach(System.out::println);
//        System.out.println("Printing newAr:");
//        Stream.of(newAr).forEach(System.out::println);
//        System.out.println("End printing");
//        System.out.println((new Integer[]{1})[0]);
    }
}
