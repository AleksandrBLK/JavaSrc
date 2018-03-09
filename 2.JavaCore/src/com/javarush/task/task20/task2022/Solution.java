package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution sol = new Solution("D:\\JavaRush_new\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\test");
        String str = "Hello";
        sol.writeObject(str);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\JavaRush_new\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\test2"));
        oos.writeObject(sol);
        oos.close();

        FileInputStream fiStream = new FileInputStream("D:\\JavaRush_new\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\test2");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();
        fiStream.close();
        objectStream.close();

        String str1 = "Good buy";

        loadedObject.writeObject(str1);

    }
}
