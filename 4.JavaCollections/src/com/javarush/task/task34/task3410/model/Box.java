package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);

        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        int rightUpperCornerX = getX() + getWidth() / 2;
        int rightUpperCornerY = getY() + getHeight() / 2;

        int x = getX() - getWidth() / 2;
        int y = getY() + getHeight() / 2;

        int x1 = getX() + getWidth() / 2;
        int y1 = getY() - getHeight() / 2;

        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.drawLine(leftUpperCornerX, leftUpperCornerY, rightUpperCornerX, rightUpperCornerY);
        graphics.drawLine(x, y, x1, y1);
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
