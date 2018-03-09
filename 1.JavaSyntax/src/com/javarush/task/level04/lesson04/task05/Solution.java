package com.javarush.test.level04.lesson04.task05;

/* Положительное и отрицательное число
Ввести с клавиатуры число. Если число положительное, то увеличить его в два раза. Если число отрицательное, то прибавить единицу.
Вывести результат на экран.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        number = getNumber(number);

        System.out.println(number);

    }

    private static int getNumber(int number)
    {
        if (number >= 0){
            number = number *2;
        }else{
            number = number + 1;
        }
        return number;
    }

}