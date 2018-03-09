package com.javarush.test.level03.lesson05.task03;

/* Конвертер времени
Добавьте метод public static int convertToSeconds(int hour) который будет конвертировать часы в секунды.
Вызовите его дважды в методе main с любыми параметрами. Результаты выведите на экран, каждый раз с новой строки.
*/

public class Solution
{

    //напишите тут ваш код
    public static int convertToSeconds (int hour){
        int sec = hour * 3600;
        System.out.println(sec);
        return sec;
    }

    public static void main(String[] args) {
        //напишите тут ваш код

        convertToSeconds (5);
        convertToSeconds (2);
    }
}