package hivolts;

class Mho {
    private int x;
    private int y;
    private Player player;
    public Mho(x, y, player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }
    private move(x, y) {
        this.x += x;
        this.y += y;
    }
    public update() {
        int xdif = player.getX() - x;
        int ydif = player.getY() - y;
        /*if (xdif == 0) {
            if (ydif >= 1)
        }*/
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}