package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd/MM/y");
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; i += 3) {
                        Date date = oldDateFormat.parse(args[i + 3]);
                        String newDate = newDateFormat.format(date);
                        if (args[i + 2].equals("м")) {
                            allPeople.add(Person.createMale(args[i + 1], new Date(newDate)));
                            System.out.println(allPeople.indexOf(allPeople.get(allPeople.size() - 1)));
                        }
                        if (args[i + 2].equals("ж")) {
                            allPeople.add(Person.createFemale(args[i + 1], new Date(newDate)));
                            System.out.println(allPeople.indexOf(allPeople.get(allPeople.size() - 1)));
                        }
                    }
                    break;

                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 0; i < args.length - 1; i += 4) {
                        int id = Integer.parseInt(args[i + 1]);
                        Date date = oldDateFormat.parse(args[i + 4]);
                        String newDate = newDateFormat.format(date);
                        allPeople.get(id).setBirthDay(new Date(newDate));
                        allPeople.get(id).setName(args[i + 2]);
                        if (args[i + 3].equals("м")) {
                            allPeople.get(id).setSex(Sex.MALE);
                        }
                        if (args[i + 3].equals("ж")) {
                            allPeople.get(id).setSex(Sex.FEMALE);
                        }
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        allPeople.get(id).setBirthDay(null);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople){
                    for (int i = 1; i < args.length; i++){
                        int id = Integer.parseInt(args[i]);
                        String sex;
                        if (allPeople.get(id).getSex().equals(Sex.MALE)) {
                            sex = "м";
                        } else {
                            sex = "ж";
                        }

                        String newDate = newDateFormat.format(allPeople.get(id).getBirthDay());

                        System.out.println(allPeople.get(id).getName() + " " + sex + " " + newDate);
                    }
                    break;
                }
        }
    }
}

