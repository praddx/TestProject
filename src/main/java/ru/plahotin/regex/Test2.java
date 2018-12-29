package ru.plahotin.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

    public static void main(String[] args) {


        String s = "I[0-9]{2}";


        String test = "AIR CORPORATEDEALS / SU - ALT01";

        Pattern PATTERN = Pattern.compile("AIR\\sCORPORATEDEALS\\s/\\s(?<airlineCode>[0-9A-Z]{2})\\s-\\s(?<corpDeal>[A-Z]{3}[0-9]{2})");

        Matcher matcher = PATTERN.matcher(test);

        System.out.println(matcher.matches());
        System.out.println(matcher.group("corpDeal"));

        A a = null;

        List<String> sList = Optional.ofNullable(a)
                .map(var -> var.getList())
                .orElse(null);

        Map<String, List<Summary>> pqVarMap = new HashMap<>();
        String pqVarKey = "1";
        Summary summary = new Summary();

        pqVarMap.compute(pqVarKey, (k,v) -> {
            if (v == null) {
                List<Summary> summariesList = new ArrayList<>();
                summariesList.add(summary);
            } else {
                v.add(summary);
            }
            return v;
        });


    }

    public static class Summary {

    }

    public static class A {
          List<String> list;

        public List<String> getList() {
            return list;
        }
    }
}
