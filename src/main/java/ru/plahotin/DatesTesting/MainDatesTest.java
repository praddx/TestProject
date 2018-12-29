package ru.plahotin.DatesTesting;

import sun.usagetracker.UsageTrackerClient;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.ZoneOffset.UTC;

public class MainDatesTest {

    public static void main(String[] args) {
        LocalDateTime testDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0, 0));
        LocalDateTime testDate2 = LocalDateTime.now();
        ZonedDateTime time = ZonedDateTime.now(UTC);

        LocalTime time1 = LocalTime.of(9, 0, 0);
        LocalTime time2 = LocalTime.of(8, 30, 0);

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss");
//
//        System.out.println(LocalDate.parse("2018-02-17"));
//
//        System.out.println(testDate);
//        System.out.println(testDate2.toString());
//        System.out.println(formatter.format(testDate2));
//
//        System.out.println(LocalDateTime.now(ZoneId.of("Europe/Moscow")));
//
//        ZoneOffset zof = ZoneOffset.from(time);

        Map<String, String> map = new HashMap<>();
        List<LocalTime> times = new ArrayList<>();
        times.add(time1);
        times.add(time2);

        times.stream().sorted().forEach(System.out::print);

        Duration duration1 = Duration.of(30, ChronoUnit.MINUTES);
        Duration duration2 = Duration.of(15, ChronoUnit.MINUTES);
        Duration duration3 = Duration.of(15, ChronoUnit.MINUTES);

        System.out.println(String.valueOf(Duration.between(time1, time2).toMinutes()));
        System.out.println(String.valueOf(duration1.minus(duration2).toMinutes()));
        System.out.println(String.valueOf(duration2.minus(duration1).toMinutes()));
        System.out.println(duration2.compareTo(duration1));
        System.out.println(duration2.equals(duration3));


        for(int i = 0; i < 10; i++) {
            if (i == i) {
                if (i == 5) {
                    break;
                }
            }
            System.out.println(i);
        }


    }

}
