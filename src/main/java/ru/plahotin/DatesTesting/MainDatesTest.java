package ru.plahotin.DatesTesting;

import sun.usagetracker.UsageTrackerClient;

import java.time.*;

import static java.time.ZoneOffset.UTC;

public class MainDatesTest {

    public static void main(String[] args) {
        LocalDateTime testDate = LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0, 0));
        LocalDateTime testDate2 = LocalDateTime.now();
        ZonedDateTime time = ZonedDateTime.now(UTC);

        System.out.println(LocalDate.parse("2018-02-17"));

        System.out.println(testDate);
        System.out.println(testDate2);

        System.out.println(LocalDateTime.now(ZoneId.of("Europe/Moscow")));

        ZoneOffset zof = ZoneOffset.from(time);



    }

}
