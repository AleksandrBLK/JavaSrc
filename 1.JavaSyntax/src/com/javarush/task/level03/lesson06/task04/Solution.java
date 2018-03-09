package com.javarush.test.level03.lesson06.task04;

/* Экранирование символов
Про экранирование символов в Java читайте в дополнительном материале к лекции.
Вывести на экран следующий текст - две строки:

It's Windows path: "C:\Program Files\Java\jdk1.7.0\bin"
It's Java string: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        String quotes = new String ("\"");
        String slash = new String ("\\");


        System.out.println("It's Windows path: " + quotes + "C:" + slash + "Program Files" + slash + "Java" + slash + "jdk1.7.0" + slash + "bin" + quotes);
        System.out.println("It's Java string: " + slash + quotes + "C:" + slash + slash + "Program Files" + slash + slash + "Java" + slash + slash + "jdk1.7.0" + slash + slash + "bin" + slash + quotes);

    }
}