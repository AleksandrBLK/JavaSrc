package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x = reader.readLine();
        ArrayList<Character> list = new ArrayList<Character>();
        ArrayList<Character> list1 = new ArrayList<Character>();
        char[] y = x.toCharArray();



        for (int i = 0; i < y.length; i++){
            if (isVowel(y[i])){
                list.add(y[i]);
            }else if (Character.isWhitespace(y[i])){

            }else{
                list1.add(y[i]);
            }
        }

        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

        System.out.print("\n" + list1.get(0) + " ");

        for (int i = 1; i < list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }


    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}