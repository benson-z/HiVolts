package hivolts;

import java.lang.Math;

public class Mho {
    private int x;
    private int y;
    private Player player;
    private Board board;
    private int[][] mholist;
    public Mho(int x, int y, Player player, Board board, int[][] mholist) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.board = board;
        this.mholist = mholist;
    }
    private Boolean availible(int x, int y) {
        if (board.getCell(x, y) == 1) {
            return false;
        }
        for (int[] a : mholist) {
            if (a[0] == x && a[1] == y) {
                return false;
            }
        }
        return true;
    }
    private Boolean availible2(int x, int y) {
        for (int[] a : mholist) {
            if (a[0] == x && a[1] == y) {
                return false;
            }
        }
        return true;
    }
    public Boolean update() {
        int xdif = player.getX() - x;
        int ydif = player.getY() - y;
        if (xdif == 0 && ydif >= 0 && availible(x, y+1)) {
            y++;
        }
        else if (xdif == 0 && ydif <= 0 && availible(x, y-1)) {
            y--;
        }
        else if (ydif == 0 && xdif >= 0 && availible(x+1, y)) {
            x++;
        }
        else if (ydif == 0 && xdif <= 0 && availible(x-1, y)) {
            x--;
        }
        else if (Math.abs(ydif) == Math.abs(xdif) && availible(x + (xdif/Math.abs(xdif)), y + (ydif/Math.abs(ydif)))) {
            x += xdif/Math.abs(xdif);
            y += ydif/Math.abs(ydif);
        }
        else if (Math.abs(xdif) > Math.abs(ydif) && availible(x + (xdif/Math.abs(xdif)), y)){
            x += xdif/Math.abs(xdif);
        }
        else if (Math.abs(xdif) < Math.abs(ydif) && availible(x, y + (ydif/Math.abs(ydif)))){
            y += ydif/Math.abs(ydif);
        }
        else {
            if (xdif == 0 && ydif >= 0 && availible2(x, y+1)) {
                return false;
            }
            else if (xdif == 0 && ydif <= 0 && availible2(x, y-1)) {
                return false;
            }
            else if (ydif == 0 && xdif >= 0 && availible2(x+1, y)) {
                return false;
            }
            else if (ydif == 0 && xdif <= 0 && availible2(x-1, y)) {
                return false;
            }
            else if (Math.abs(xdif) == Math.abs(ydif) && availible2(x + xdif/Math.abs(xdif), y + ydif/Math.abs(ydif))) {
                return false;
            }
            else if (Math.abs(xdif) > Math.abs(ydif) && availible2(x + xdif/Math.abs(xdif), y)){
                return false;
            }
            else if (Math.abs(xdif) < Math.abs(ydif) && availible2(x, y + ydif/Math.abs(ydif))){
                return false;
            }
        }
        return true;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}