package hivolts;

import java.lang.Math;

class Player {
    private x;
    private y;
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void move(int x, int y) {
        this.x += x;
        this.y += y;
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