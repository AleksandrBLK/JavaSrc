/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package byog.TileEngine;

public class Room {
    public int x;
    public int y;
    public int width;
    public int height;
    public Room(int x, int y, int width, int height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void place(TETile[][] tiles) {
        // Fill the room with floor tiles. Offsets are necessary
        // for walls.
        for (int xP = x + 1; xP < x + width - 1; xP++)
            for (int yP = y + 1; yP < y + height - 1; yP++)
                tiles[xP][yP] = Tileset.FLOOR;
    }
}
