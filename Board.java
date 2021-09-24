package hivolts;

import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

public class Board {
    private int[][] board;
    private int boardx;
    private int boardy;
    public Board(int boardx, int boardy) {
        this.boardx = boardx;
        this.boardy = boardy;
        initFences();
    }
    public void initFences() {
        board = new int[boardx][boardy];
        for (int a=0; a<boardx; a++) {
            for (int b=0; b<boardy; b++) {
                if (a == 0 || b == 0 || a == boardx-1 || b == boardy-1) {
                    board[a][b] = 1;
                }
            }
        }
        for (int a=0; a<(int) Math.floor(boardx*boardy*0.2); a++) {
            int x = ThreadLocalRandom.current().nextInt(1, boardx-1);
            int y = ThreadLocalRandom.current().nextInt(1, boardy-1);
            if (board[x][y] != 1) {
                board[x][y] = 1;
            }
            else {
                a--;
            }
        }
    }
    public int getCell(int x, int y) {
        return board[x][y];
    }
}