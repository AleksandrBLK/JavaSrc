package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");


    }

    public static void printDate(String date) {
        //напишите тут ваш код
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy H:m:s");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d.M.yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("H:m:s");

        LocalDate localDate = null;
        LocalTime localTime = null;

        try {
            LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
            String[] dateSplit = date.split(" ");
            localDate = LocalDate.parse(dateSplit[0], formatter1);
            localTime = LocalTime.parse(dateSplit[1], formatter2);
        } catch (DateTimeParseException e) {

        }

        try {
            localDate = LocalDate.parse(date, formatter1);

        } catch (DateTimeParseException e) {

        }


        try {
            localTime = LocalTime.parse(date, formatter2);
        } catch (DateTimeParseException e) {

        }

        if (localDate != null) {
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
            System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
            System.out.println("Месяц: " + localDate.getMonthValue());
            System.out.println("Год: " + localDate.getYear());
        }
        if (localTime != null) {
            System.out.println("AM или PM: " + (localTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
            System.out.println("Часы: " + localTime.get(ChronoField.HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());
        }


    }
}
