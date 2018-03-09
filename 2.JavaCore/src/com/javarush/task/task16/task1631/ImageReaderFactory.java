/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by info on 03.06.2017.
 */
public class ImageReaderFactory implements ImageReader {

    public static ImageReader getImageReader(ImageTypes image) {

        if (image == ImageTypes.BMP) {
            return new BmpReader();
        }
        if (image == ImageTypes.JPG) {
            return new JpgReader();
        }
        if (image == ImageTypes.PNG) {
            return new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }


    }
}
