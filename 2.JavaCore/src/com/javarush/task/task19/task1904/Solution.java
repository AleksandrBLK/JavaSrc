package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

        String str = "31";
        String str1 = "12";
        String str2 = "1950";
        Date date = new GregorianCalendar(Integer.parseInt(str2), Integer.parseInt(str1) - 1, Integer.parseInt(str)).getTime();
        System.out.println(date);

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        PersonScannerAdapter (Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String personLine = fileScanner.nextLine();
            String[] personArray = personLine.split(" ");
            Date date = new GregorianCalendar(Integer.parseInt(personArray[5]), Integer.parseInt(personArray[4]) - 1, Integer.parseInt(personArray[3])).getTime();
            return new Person(personArray[1], personArray[2], personArray[0], date);
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
