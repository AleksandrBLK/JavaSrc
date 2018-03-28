package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

public class Solution {
    public static void main(String[] args) {
        Color[][] image = new Color[2][2];

        PhotoPaint photoPaint = new PhotoPaint();

        for (int i = 0; i < image.length; i++){
            for (int j = 0; j < image[0].length; j++){
                image[j][i] = Color.GREEN;
            }
        }

        System.out.println(photoPaint.paintFill(image, 1, 1, Color.BLUE));

    }
}
