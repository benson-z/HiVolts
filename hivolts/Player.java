package hivolts;

import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Vector;

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
        this.x += x;
        this.y += y;
    }
    public void moveToRandom() {
        for (int a=0; a<1; a++) {
            x = ThreadLocalRandom.current().nextInt(1, 11);
            y = ThreadLocalRandom.current().nextInt(1, 11);
            if (board.getCell(x, y) == 1) {
                a--;
            }
        }
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}