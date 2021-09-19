package hivolts;

import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Vector;

public class Player {
    private int x;
    private int y;
    private Board board;
    private int boardx;
    private int boardy;
    public Player(int x, int y, Board board, int boardx, int boardy) {
        this.x = x;
        this.y = y;
        this.board = board;
        this.boardx = boardx;
        this.boardy = boardy;
    }
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
    public void moveToRandom() {
        for (int a=0; a<1; a++) {
            x = ThreadLocalRandom.current().nextInt(1, boardx-1);
            y = ThreadLocalRandom.current().nextInt(1, boardy-1);
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