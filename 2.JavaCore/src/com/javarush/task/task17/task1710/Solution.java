package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd/MM/y");
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);

        if (args[0].equals("-c")) {
            Date date = oldDateFormat.parse(args[3]);
            String newDate = newDateFormat.format(date);
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], new Date(newDate)));
                System.out.println(allPeople.indexOf(allPeople.get(allPeople.size() - 1)));
            }
            if (args[2].equals("ж")) {
                allPeople.add(Person.createFemale(args[1], new Date(newDate)));
                System.out.println(allPeople.indexOf(allPeople.get(allPeople.size() - 1)));
            }
        }
        if (args[0].equals("-u")) {
            int id = Integer.parseInt(args[1]);
            Date date = oldDateFormat.parse(args[4]);
            String newDate = newDateFormat.format(date);
            allPeople.get(id).setBirthDay(new Date(newDate));
            allPeople.get(id).setName(args[2]);
            if (args[3].equals("м")) {
                allPeople.get(id).setSex(Sex.MALE);
            }
            if (args[3].equals("ж")) {
                allPeople.get(id).setSex(Sex.FEMALE);
            }
        }

        if (args[0].equals("-d")) {
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
        }

        if (args[0].equals("-i")) {
            int id = Integer.parseInt(args[1]);
            String sex;
            if (allPeople.get(id).getSex().equals(Sex.MALE)) {
                sex = "м";
            } else {
                sex = "ж";
            }

            String newDate = newDateFormat.format(allPeople.get(id).getBirthDay());

            System.out.println(allPeople.get(id).getName() + " " + sex + " " + newDate);
        }
    }
}

