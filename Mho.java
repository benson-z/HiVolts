package hivolts;

import java.lang.Math;

public class Mho {
    private int x;
    private int y;
    private Player player;
    private Board board;
    public Mho(int x, int y, Player player, Board board) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.board = board;
    }
    private void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
    public Boolean update() {
        int xdif = player.getX() - x;
        int ydif = player.getY() - y;
        if (xdif == 0 && ydif >= 0 && board.getCell(x, y+1) != 1) {
            y++;
        }
        else if (xdif == 0 && ydif <= 0 && board.getCell(x, y-1) != 1) {
            y--;
        }
        else if (ydif == 0 && xdif >= 0 && board.getCell(x+1, y) != 1) {
            x++;
        }
        else if (ydif == 0 && xdif <= 0 && board.getCell(x-1, y) != 1) {
            x--;
        }
        else if (Math.abs(xdif) == Math.abs(ydif) && board.getCell(x + xdif/Math.abs(xdif), y + ydif/Math.abs(ydif)) != 1) {
            x += xdif/Math.abs(xdif);
            y += ydif/Math.abs(ydif);
        }
        else if (Math.abs(xdif) > Math.abs(ydif) && board.getCell(x + xdif/Math.abs(xdif), y) != 1){
            x += xdif/Math.abs(xdif);
        }
        else if (Math.abs(xdif) < Math.abs(ydif) && board.getCell(x, y + ydif/Math.abs(ydif)) != 1){
            y += ydif/Math.abs(ydif);
        }
        else {
            return false;
        }
        return true;
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