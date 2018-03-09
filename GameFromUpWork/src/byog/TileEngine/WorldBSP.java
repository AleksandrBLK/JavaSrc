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
import java.util.ListIterator;

public class WorldBSP {
    private final int MAX_LEAF_SIZE = 20;



    public TETile[][] createLeafs(int WIDTH, int HEIGHT) {
        ArrayList<Leaf> leafs = new ArrayList<Leaf>();
        Leaf root = new Leaf(0, 0, WIDTH, HEIGHT);
        leafs.add(root);

        boolean didSplit = true;

        while (didSplit) {
            didSplit = false;
            ListIterator<Leaf> iterator = leafs.listIterator();
            while (iterator.hasNext()) {
                Leaf currentLeaf = iterator.next();
                if (currentLeaf.leftChild == null && currentLeaf.rightChild == null) {
                    if (currentLeaf.width > MAX_LEAF_SIZE || currentLeaf.height > MAX_LEAF_SIZE || Math.random() > 0.25) {
                        if (currentLeaf.Split()) {
                            iterator.add(currentLeaf.leftChild);
                            iterator.add(currentLeaf.rightChild);
                            didSplit = true;
                        }
                    }
                }
            }
        }
        root.CreateRooms();


        TETile[][] teTiles = new TETile[WIDTH][HEIGHT];

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                teTiles[x][y] = Tileset.NOTHING;
            }
        }

        for (Leaf l : leafs) {
            if (l.room != null) {
                for (int x = l.room.x; x < l.room.width + l.room.x; x++) {
                    for (int y = l.room.y; y < l.room.height + l.room.y; y++) {
                        teTiles[x][y] = Tileset.FLOOR;
                    }
                }
            }

            if (l.halls != null) {
                for (Rectangle r : l.halls) {
                    for (int x1 = (int) (r.getX()); x1 < r.getWidth() + r.getX(); x1++) {
                        for (int y1 = (int) (r.getY()); y1 < r.getHeight() + r.getY(); y1++) {
                            teTiles[x1][y1] = Tileset.FLOOR;
                        }
                    }
                }
            }

        }

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (teTiles[x][y] == Tileset.FLOOR) {
                    if (teTiles[x + 1][y - 1] == Tileset.NOTHING) {
                        teTiles[x + 1][y - 1] = Tileset.WALL;
                    }
                    if (teTiles[x - 1][y + 1] == Tileset.NOTHING) {
                        teTiles[x - 1][y + 1] = Tileset.WALL;
                    }
                    if (teTiles[x - 1][y - 1] == Tileset.NOTHING) {
                        teTiles[x - 1][y - 1] = Tileset.WALL;
                    }
                    if (teTiles[x + 1][y + 1] == Tileset.NOTHING) {
                        teTiles[x + 1][y + 1] = Tileset.WALL;
                    }
                    if (teTiles[x + 1][y] == Tileset.NOTHING) {
                        teTiles[x + 1][y] = Tileset.WALL;
                    }
                    if (teTiles[x - 1][y] == Tileset.NOTHING) {
                        teTiles[x - 1][y] = Tileset.WALL;
                    }

                    if (teTiles[x][y + 1] == Tileset.NOTHING) {
                        teTiles[x][y + 1] = Tileset.WALL;
                    }
                    if (teTiles[x][y - 1] == Tileset.NOTHING) {
                        teTiles[x][y - 1] = Tileset.WALL;
                    }
                }
            }
        }

        for (int x = 1; x < WIDTH - 1; x++) {
            for (int y = 1; y < HEIGHT - 1; y++) {
                if (teTiles[x][y] == Tileset.WALL) {
                    if (teTiles[x][y + 1] == Tileset.FLOOR) {
                        if (teTiles[x][y - 1] == Tileset.FLOOR) {
                            teTiles[x][y] = Tileset.FLOOR;
                        }


                    }
                    if (teTiles[x + 1][y] == Tileset.FLOOR) {
                        if (teTiles[x - 1][y] == Tileset.FLOOR) {
                            teTiles[x][y] = Tileset.FLOOR;
                        }
                    }
                }
            }
        }

        exitlabel:
        for (int x = WIDTH / 2; x < WIDTH - 5; x++) {
            for (int y = HEIGHT / 2; y < HEIGHT - 5; y++) {
                if (teTiles[x][y] == Tileset.WALL) {
                    if (teTiles[x][y - 1] == Tileset.FLOOR || teTiles[x + 1][y] == Tileset.FLOOR) {
                        if (teTiles[x][y + 1] == Tileset.NOTHING || teTiles[x + 1][y] == Tileset.NOTHING) {
                            teTiles[x][y] = Tileset.LOCKED_DOOR;
                            break exitlabel;
                        }
                    }
                }

            }
        }


        return teTiles;
    }


}
