package ru.plahotin.collectionstesting;

import java.util.*;
import java.util.stream.IntStream;
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


        System.out.println(Stream.of(ar).count());

        String test = "Blab";
        char[] ch = test.toCharArray();
        CharSequence charS = "asdfs";

        System.out.println(test.toLowerCase().chars().distinct().count() == test.length());

        List<Integer> firstList = new ArrayList<Integer>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(5);
        secondList.add(6);

        firstList.addAll(secondList);
        System.out.println(firstList.size());

        Integer[] newArr = firstList.toArray(new Integer[]{});
        System.out.println("==============");

        for (Integer el : newArr) {
            System.out.println(el);
        }

//        Integer[] arr = new Integer[]{};
//        List<Integer> list = new ArrayList<>();
//        list.addAll(Arrays.asList(ar));
//        System.out.println(list.size());
//        list.remove(new Integer(4));
//        System.out.println(list.size());
//        System.out.println(list.toArray(arr).length);
//
//        Set<Integer> emptySet = Collections.emptySet();
//        System.out.println(emptySet.remove(4));
//
//
//        Set<Integer> set = new HashSet<>();
//        set.addAll(Arrays.asList(ar));
//        System.out.println(set.size());
//        set.remove(4);
//        System.out.println(set.size());
//        System.out.println(set.toArray(ar).length);
//        //sList.addAll(Arrays.asList(s.toCharArray()));

//        if (!list.contains(5))
//        //list.add(5);
//            System.out.println("works");

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
