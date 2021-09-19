package hivolts;

import java.lang.Math;

public class Mho {
    private int x;
    private int y;
    private Player player;
    public Mho(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }
    private void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
    public void update() {
        int xdif = player.getX() - x;
        int ydif = player.getY() - y;
        if (xdif == 0) {
            if (ydif >= 0) {
                y--;
            }
            else if (ydif <= 0) {
                y++;
            }
        }
        else if (ydif == 0) {
            if (xdif >= 0) {
                x--;
            }
            else if (xdif <= 0) {
                x++;
            }
        }
        /*else if (Math.abs(xdif) == Math.abs(ydif)) {
            x +=
        }*/
        /*If the Mho is perfectly diagonal to the player, move diagonally to the Player one space.
        If the Mho is not perfectly diagonal, horizontal, or vertical to the Player:
        1. If the Mho's horizontal distance is greater than its vertical distance to the Player, move horizontal towards the Player one space
        2. If the Mho's horizontal distance is less than its vertical distance to the Player, move vertical towards the Player one space
        */
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}