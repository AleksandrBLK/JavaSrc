package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println(new Solution(4));

        Solution sol = new Solution(7);

        FileInputStream fileInputStream = new FileInputStream("D:\\JavaRush_new\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\fileInput");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\JavaRush_new\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\fileInput");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(sol);
        objectOutputStream.close();
        fileOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        Solution newSoution = (Solution) object;

        objectInputStream.close();
        fileInputStream.close();

        if (sol.string.equals(newSoution.string)){
            System.out.println("Yes");
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
