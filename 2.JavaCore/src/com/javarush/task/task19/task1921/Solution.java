package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        if (args[0].length() > 0){
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));

            while (reader.ready()){
                String str = reader.readLine();
                String [] str1 = str.split(" ");
                int day = Integer.parseInt(str1[str1.length - 3]);
                int month = Integer.parseInt(str1[str1.length - 2]);
                int year = Integer.parseInt(str1[str1.length - 1]);
                String str2 = "";
                for (int i = 0; i < str1.length - 3; i++){
                    str2 = str2.concat(str1[i] + " ");
                }
                Date date = new GregorianCalendar(year, month - 1, day).getTime();

                PEOPLE.add(new Person(str2.trim(), date));
            }

            reader.close();
        }

    }
}
