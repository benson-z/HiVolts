package hivolts;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int[][] board = new int[12][12];
    public Board() {
        initFences();
    }
    public void initFences() {
        for (int a=0; a<12; a++) {
            for (int b=0; b<12; b++) {
                if (a == 0 || b == 0 || a == 11 || b == 11) {
                    board[a][b] = 1;
                }
            }
        }
        for (int a=0; a<20; a++) {
            int x = ThreadLocalRandom.current().nextInt(1, 11);
            int y = ThreadLocalRandom.current().nextInt(1, 11);
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