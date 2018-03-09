/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package byog.TileEngine;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class World {
    private int seed;
    private Random random;

    public void setSeed(int seed) {
        this.seed = seed;
        this.random = new Random(seed);
    }


    private static final int MAX_ROOM_WIDTH = 10;
    private static final int MAX_ROOM_HEIGHT = 8;
    private static final int MIN_ROOM_WIDTH = 5;
    private static final int MIN_ROOM_HEIGHT = 4;
    private static final double MIN_ROOM_RATIO = 0.1;
    private static final double MAX_ROOM_RATIO = 0.5;


    public TETile[][] buildMap(int width, int height) {
        TETile[][] tiles = new TETile[width][height];
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                tiles[x][y] = Tileset.NOTHING;
        List<Room> rooms = placeRooms(tiles);
        placeTunnels(tiles, rooms);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (tiles[x][y] == Tileset.FLOOR) {
                    if (tiles[x + 1][y - 1] == Tileset.NOTHING) {
                        tiles[x + 1][y - 1] = Tileset.WALL;
                    }
                    if (tiles[x - 1][y + 1] == Tileset.NOTHING) {
                        tiles[x - 1][y + 1] = Tileset.WALL;
                    }
                    if (tiles[x - 1][y - 1] == Tileset.NOTHING) {
                        tiles[x - 1][y - 1] = Tileset.WALL;
                    }
                    if (tiles[x + 1][y + 1] == Tileset.NOTHING) {
                        tiles[x + 1][y + 1] = Tileset.WALL;
                    }
                    if (tiles[x + 1][y] == Tileset.NOTHING) {
                        tiles[x + 1][y] = Tileset.WALL;
                    }
                    if (tiles[x - 1][y] == Tileset.NOTHING) {
                        tiles[x - 1][y] = Tileset.WALL;
                    }

                    if (tiles[x][y + 1] == Tileset.NOTHING) {
                        tiles[x][y + 1] = Tileset.WALL;
                    }
                    if (tiles[x][y - 1] == Tileset.NOTHING) {
                        tiles[x][y - 1] = Tileset.WALL;
                    }
                }
            }
        }


        exitlabel:
        for (int x = width / 2; x < width; x++) {
            for (int y = height / 2; y < height; y++) {
                if (tiles[x][y] == Tileset.WALL) {
                    if (tiles[x][y - 1] == Tileset.FLOOR || tiles[x + 1][y] == Tileset.FLOOR) {
                        if (tiles[x][y + 1] == Tileset.NOTHING || tiles[x + 1][y] == Tileset.NOTHING) {
                            tiles[x][y] = Tileset.LOCKED_DOOR;
                            break exitlabel;
                        }
                    }
                }

            }
        }


        return tiles;
    }

    private List<Room> placeRooms(TETile[][] tiles) {
        int mapWidth = tiles.length, mapHeight = tiles[0].length;
        int roomsAcross = mapWidth / MAX_ROOM_WIDTH, roomsDown = mapHeight
                / MAX_ROOM_HEIGHT;
        int maxRooms = roomsAcross * roomsDown;
        boolean[] usedRooms = new boolean[maxRooms];
        int totalRooms = rnd((int) (maxRooms * MIN_ROOM_RATIO), (int) (maxRooms * MAX_ROOM_RATIO));
        List<Room> rooms = new ArrayList<Room>();
        Room room;
        int roomCell;
        int width, height, x, y;
        for (int i = 0; i < totalRooms; i++) {
            do {
                roomCell = rnd(0, maxRooms - 1);
            } while (usedRooms[roomCell]);
            usedRooms[roomCell] = true;
            width = rnd(MIN_ROOM_WIDTH, MAX_ROOM_WIDTH);
            height = rnd(MIN_ROOM_HEIGHT, MAX_ROOM_HEIGHT);
            x = (roomCell % roomsAcross) * MAX_ROOM_WIDTH;
            x += rnd(0, MAX_ROOM_WIDTH - width);
            y = (roomCell / roomsAcross) * MAX_ROOM_HEIGHT;
            y += rnd(0, MAX_ROOM_HEIGHT - height);
            room = new Room(x, y, width, height);
            room.place(tiles);
            rooms.add(room);
        }
        return rooms;
    }

    private void placeTunnels(TETile[][] tiles, List<Room> rooms) {
        int deltaX, deltaY, deltaXSign, deltaYSign;
        int currentX, currentY;
        boolean movingInX;
        int carver, carveLength;
        Room currentRoom, goalRoom;
        Iterator<Room> iterator = rooms.iterator();
        currentRoom = iterator.next();
        while (iterator.hasNext()) {
            goalRoom = iterator.next();
            currentX = currentRoom.x + (currentRoom.width / 2);
            currentY = currentRoom.y + (currentRoom.height / 2);
            deltaX = (goalRoom.x + (goalRoom.width / 2)) - currentX;
            deltaY = (goalRoom.y + (goalRoom.height / 2)) - currentY;
            if (deltaX == 0) deltaXSign = 1;
            else deltaXSign = (int) (deltaX / Math.abs(deltaX));
            if (deltaY == 0) deltaYSign = 1;
            else deltaYSign = (int) (deltaY / Math.abs(deltaY));
            while (!(deltaX == 0 && deltaY == 0)) {
                movingInX = rnd(0, 1) == 1;
                if (movingInX && deltaX == 0) movingInX = false;
                if (!movingInX && deltaY == 0) movingInX = true;
                carveLength = rnd(1, (int) (Math.abs(movingInX ? deltaX : deltaY)));
                for (carver = 0; carver < carveLength; carver++) {
                    if (movingInX) currentX += deltaXSign;
                    else currentY += deltaYSign;

                    tiles[currentX][currentY] = Tileset.FLOOR;
                }
                if (movingInX) deltaX -= deltaXSign * carveLength;
                else deltaY -= deltaYSign * carveLength;
            }
            currentRoom = goalRoom;
        }


    }

    private int rnd(int min, int max) {
        return min + (int) (random.nextDouble() * ((max - min) + 1));
    }


}
