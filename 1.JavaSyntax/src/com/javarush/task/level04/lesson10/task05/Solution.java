package com.javarush.test.level04.lesson10.task05;

import java.io.*;

/* Таблица умножения
Вывести на экран таблицу умножения 10х10 используя цикл while.
Числа разделить пробелом.
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int a = 1;

        while (a <= 10)
        {
            System.out.println(1 * a + " " + 2 * a + " " + 3 * a + " " + 4 * a + " " + 5 * a + " " + 6 * a + " " + 7 * a + " " + 8 * a + " " + 9 * a + " " + 10 * a);
            a++;
        }

    }
}
