package ru.plahotin.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OptionalGroup {

    public static void main(String[] args) {
       final Pattern pattern = Pattern.compile(
                "WF<(?<feeAmount>[^>]{12})><(?<isTAX>[^>]{2})><(?<TTL>[^>])>(<(?<ZZTax>[^>]{12})>)?<(?<taxCompare>[^>])><(?<next>[^>])><(?<quit>[^>])>");

        List<String> groups = new ArrayList<>();
        groups.add("feeAmount");
        groups.add("isTAX");
        groups.add("TTL");
        groups.add("ZZTax");
        groups.add("taxCompare");
        groups.add("next");
        groups.add("quit");

        String optional = "WF<        1100><CP>< ><          95>< ><X>< >";
        String noOptional = "WF<        1100><CP>< >< ><X>< >";

        Matcher matcher;
        matcher = pattern.matcher(optional);
        System.out.println(matcher.matches());
        groups.stream()
                .map(g -> matcher.group(g))
                .map(s -> s.replaceAll(" ", "*"))
                .forEach(s -> System.out.print("\"" + s + "\"" + " | "));
        System.out.println();

        Matcher m;
        m = pattern.matcher(noOptional);
        System.out.println(m.matches());
        /*for (String g : groups) {
            if ()
            System.out.println(m.group(g));
        }*/
        groups.stream()
                .filter(s -> !s.equals("ZZTax"))
                .map(g -> m.group(g))
                .map(s -> s.replaceAll(" ", "*"))
                .forEach(s -> System.out.print("\"" + s + "\"" + " | "));
        System.out.println();

        System.out.println(m.groupCount());
        System.out.println(m.group("ZZTax"));
    }
}
