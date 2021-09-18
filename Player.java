package hivolts;

import java.lang.Math;

public class Player {
    private int x;
    private int y;
    private Board board;
    public Player(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
    }
    public void move(int x, int y) {
        if (board.getCell(this.x + x, this.y + y) != 1){
            this.x += x;
            this.y += y;
        }
    }
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}