package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        String name = new String("Мама");
        String doing = new String("Мыла");
        String what = new String("Раму");

        System.out.println(name + doing + what);
        System.out.println(name + what + doing);
        System.out.println(doing + name + what);
        System.out.println(doing + what + name);
        System.out.println(what + name + doing);
        System.out.println(what + doing + name);


    }
}