package hivolts;

import java.lang.Math;

class Player {
    private x;
    private y;
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public move(int x, int y) {
        this.x += x;
        this.y += y;
    }
    public moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}