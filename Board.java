package hivolts;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int[][] board = new int[12][12];
    public Board() {
        initFences();
    }
    public void initFences() {
        for (int a=0; a<20; a++) {
            int x = ThreadLocalRandom.current().nextInt(0, 12);
            int y = ThreadLocalRandom.current().nextInt(0, 12);
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