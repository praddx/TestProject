package ru.plahotin.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String s1 = "WPASU\u00a5FCA\u00a5UITN1123545\u00a5RQ";
        String s2 = "UB*TTDN9847";
        String s3 = "UN*IT15723497";
        String s4 = "UK*IT15723497";
        String s5 = "WPASU\u00a5UN*IT15723497\u00a5FCA\u00a5KP1\u00a5RQ";
        String s6 = "asd\u00a5789";

        System.out.println(s5);

        //Pattern pattern = Pattern.compile("WP[A-Z0-9\\u00a5]+(?<prefix>U[BINX]?\\*?)(?<tourCode>[A-Z0-9]+)[A-Z0-9\\u00a5]*");
        Pattern pattern = Pattern.compile("WP[A-Z0-9\\u00a5]+U([BINX]\\*)?(?<tourCode>[A-Z0-9]+)[A-Z0-9\\u00a5]*");
        //Pattern pattern = Pattern.compile("(?<prefix>U[BINX]?\\*?)(?<tourCode>[A-Z0-9]+)");
        //(?<pqNumbers>[0-9\\/\\-]+)

        Pattern pattern1 = Pattern.compile("[a-z\\u00a50-9]+");


        String s = s1;
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            System.out.println(true);
            //System.out.println(matcher.group("prefix"));
            System.out.println(matcher.group("tourCode"));
            s = s.replace(matcher.group("tourCode"), "NEWSTRING");
            System.out.println(s);
        } else {
            System.out.println(false);
        }

        matcher = pattern1.matcher(s6);
        System.out.println(matcher.matches());

    }
}
