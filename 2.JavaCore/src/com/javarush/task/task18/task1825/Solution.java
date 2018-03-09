package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String str = reader.readLine();
            if (str.equals("end")) {
                break;
            }
            list.add(str);
        }

        reader.close();

        int lastIndexDirectory = list.get(0).lastIndexOf('/'); //ищем индекс последнего вхождения косой черты
        int lastIndexFileName = list.get(0).lastIndexOf('.');//ищем индекс последнего вхождения точки
        String directory = list.get(0).subSequence(0, lastIndexDirectory + 1).toString();//выдёргиваем подстроку директории
        String fileName = list.get(0).subSequence(lastIndexDirectory + 1, lastIndexFileName).toString();//выдёргиваем подстроку файла (можно было в одну переменную выдернуть директорию и имя, но так нагляднее)

        FileOutputStream fileOutputStream = new FileOutputStream(directory + fileName);

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            FileInputStream fileInputStream = new FileInputStream(list.get(i));
            byte[] bufffer = new byte[fileInputStream.available()];
            fileInputStream.read(bufffer);
            fileOutputStream.write(bufffer);
            fileInputStream.close();
        }


        fileOutputStream.close();

    }
}

