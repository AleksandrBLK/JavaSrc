package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner reader = new Scanner(System.in);
        int vvod = reader.nextInt();
        double summa = 0;
        int schet = 0;
        while (vvod != (-1))
        {
            summa += vvod;
            schet ++;
            vvod = reader.nextInt();
        }
        System.out.println(summa / schet);


    }
}

