package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String date = reader.readLine();

        Date x = new Date(date);

        SimpleDateFormat newDate = new SimpleDateFormat("MMMM dd, yyyy", myDateFormatSymbols);
        System.out.println(newDate.format(x));


    }


    public static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols() {

        @Override
        public String[] getMonths() {
            return new String[]{
                    "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY", "AUG", "SEPT", "OCT", "NOV", "DEC"
            };
        }
    };
}
