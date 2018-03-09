package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleSteam = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream steam = new PrintStream(outputStream);

        System.setOut(steam);

        testString.printSomething();
        String result = outputStream.toString();


        System.setOut(consoleSteam);
        String[] str = result.split("\\n");

        ArrayList<String> list = new ArrayList<>();

        for (String str1 : str){
            list.add(str1);
        }

        for (int i = 2; i < list.size(); i+=3){
            list.add(i, "JavaRush - курсы Java онлайн");
        }

        for (String str1 : list ){
            System.out.println(str1);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
