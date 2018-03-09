/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package byog.TileEngine;

import java.awt.*;


import java.util.ArrayList;
import java.util.Random;


public class Leaf {
    private final int MIN_LEAF_SIZE = 6;

    public Leaf leftChild;
    public Leaf rightChild;
    public Rectangle room;
    public ArrayList<Rectangle> halls = new ArrayList<Rectangle>();

    public int x;
    public int y;
    public int width;
    public int height;

    public Leaf(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean Split() {
        if (leftChild != null || rightChild != null) {
            return false;
        }

        boolean splitH = Math.random() > 0.5;
        if (width > height && (width / height) >= 1.25) {
            splitH = false;
        } else if (height > width && (height / width) >= 1.25) {
            splitH = true;
        }

        int max;

        if (splitH) {
            max = height - MIN_LEAF_SIZE;
        } else {
            max = width - MIN_LEAF_SIZE;
        }

        if (max <= MIN_LEAF_SIZE) {
            return false;
        }

        int split = rnd(MIN_LEAF_SIZE, max);


        if (splitH) {
            leftChild = new Leaf(x, y, width, split);
            rightChild = new Leaf(x, y + split, width, height - split);
        } else {
            leftChild = new Leaf(x, y, split, height);
            rightChild = new Leaf(x + split, y, width - split, height);
        }

        return true;
    }

    public void CreateRooms() {
        if (leftChild != null || rightChild != null) {
            if (leftChild != null) {
                leftChild.CreateRooms();
            }
            if (rightChild != null) {
                rightChild.CreateRooms();
            }
            if (leftChild != null && rightChild != null) {
                createHall(leftChild.getRoom(), rightChild.getRoom());
            }


        } else {
            Point roomSize = new Point(rnd(3, width - 2), rnd(3, height - 2));
            Point roomPos = new Point(rnd(1, (width - roomSize.x) - 1), rnd(1, (height - roomSize.y) - 1));
            room = new Rectangle(x + roomPos.x, y + roomPos.y, roomSize.x, roomSize.y);
        }
    }

    public Rectangle getRoom() {
        if (room != null) {
            return room;
        } else {
            Rectangle lRoom = new Rectangle();
            Rectangle rRoom = new Rectangle();
            if (leftChild != null) {
                lRoom = leftChild.getRoom();
            }
            if (rightChild != null) {
                rRoom = rightChild.getRoom();
            }

            if (lRoom == null && rRoom == null) {
                return null;
            } else if (rRoom == null) {
                return lRoom;
            } else if (lRoom == null) {
                return rRoom;
            } else if (Math.random() > .5) {
                return lRoom;
            } else {
                return rRoom;
            }

        }


    }

    public void createHall(Rectangle l, Rectangle r) {

        Point point1 = new Point(rnd(l.x + 1, (l.x + l.width) - 2), rnd(l.y + 1, (l.y + l.height) - 2));
        Point point2 = new Point(rnd(r.x + 1, (r.x + r.width) - 2), rnd(r.y + 1, (r.y + r.height) - 2));

        int w = point2.x - point1.x;
        int h = point2.y - point1.y;

        if (w < 0)
        {
            if (h < 0)
            {
                if (Math.random() < 0.5)
                {
                    halls.add(new Rectangle(point2.x, point1.y, Math.abs(w), 1));
                    halls.add(new Rectangle(point2.x, point2.y, 1, Math.abs(h)));
                }
                else
                {
                    halls.add(new Rectangle(point2.x, point2.y, Math.abs(w), 1));
                    halls.add(new Rectangle(point1.x, point2.y, 1, Math.abs(h)));
                }
            }
            else if (h > 0)
            {
                if (Math.random() < 0.5)
                {
                    halls.add(new Rectangle(point2.x, point1.y, Math.abs(w), 1));
                    halls.add(new Rectangle(point2.x, point1.y, 1, Math.abs(h)));
                }
                else
                {
                    halls.add(new Rectangle(point2.x, point2.y, Math.abs(w), 1));
                    halls.add(new Rectangle(point1.x, point1.y, 1, Math.abs(h)));
                }
            }
            else if (h == 0)
            {
                halls.add(new Rectangle(point2.x, point2.y, Math.abs(w), 1));
            }
        }
        else if (w > 0)
        {
            if (h < 0)
            {
                if (Math.random() < 0.5)
                {
                    halls.add(new Rectangle(point1.x, point2.y, Math.abs(w), 1));
                    halls.add(new Rectangle(point1.x, point2.y, 1, Math.abs(h)));
                }
                else
                {
                    halls.add(new Rectangle(point1.x, point1.y, Math.abs(w), 1));
                    halls.add(new Rectangle(point2.x, point2.y, 1, Math.abs(h)));
                }
            }
            else if (h > 0)
            {
                if (Math.random() < 0.5)
                {
                    halls.add(new Rectangle(point1.x, point1.y, Math.abs(w), 1));
                    halls.add(new Rectangle(point2.x, point1.y, 1, Math.abs(h)));
                }
                else
                {
                    halls.add(new Rectangle(point1.x, point2.y, Math.abs(w), 1));
                    halls.add(new Rectangle(point1.x, point1.y, 1, Math.abs(h)));
                }
            }
            else if (h == 0)
            {
                halls.add(new Rectangle(point1.x, point1.y, Math.abs(w), 1));
            }
        }
        else if (w == 0)
        {
            if (h < 0)
            {
                halls.add(new Rectangle(point2.x, point2.y, 1, Math.abs(h)));
            }
            else if (h > 0)
            {
                halls.add(new Rectangle(point1.x, point1.y, 1, Math.abs(h)));
            }
        }
    }






    private static int rnd(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }



}
