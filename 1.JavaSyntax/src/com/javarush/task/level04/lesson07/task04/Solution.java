package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int[] arr = {a, b, c};

        int d = 0;
        int e = 0;

        d = plusDigits(arr, d);
        e = minusDigits (arr, e);
        System.out.println("количество отрицательных чисел: " + e);
        System.out.println("количество положительных чисел: " + d);



    }

    private static int plusDigits(int[] arr, int d)
    {
        for (int i : arr)
        {

            if (i > 0)
            {
                d++;


            }


        }
        return d;
    }

    private static int minusDigits(int[] arr, int e)
    {
        for (int i : arr)
        {

            if (i < 0)
            {
                e++;


            }


        }
        return e;
    }

}

