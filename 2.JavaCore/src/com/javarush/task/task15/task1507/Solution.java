package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, double value) {

    }

    public static void printMatrix(int m, short n, double value) {

    }

    public static void printMatrix(short m, short n, double value) {

    }

    public static void printMatrix(double m, short n, double value) {

    }

    public static void printMatrix(double m, double n, double value) {

    }

    public static void printMatrix(double m, Integer n, double value) {

    }

    public static void printMatrix(Integer m, Integer n, double value) {

    }

    public static void printMatrix(Object m, Integer n, double value) {

    }
}