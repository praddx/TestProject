package ru.plahotin.regex;

public class ContainsTest {

    static final String CROSS = "\u00a5";

    public static void main(String[] args) {
        String test = "WPASU" + CROSS + "FINVOICE*UQW123415" + CROSS + "KP0" + CROSS + "RQ";

        System.out.println(test.contains(CROSS + "F"));
    }
}
