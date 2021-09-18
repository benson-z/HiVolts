package hivolts;

public class Mho {
    private int x;
    private int y;
    private Player player;
    public Mho(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }
    private void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
    public void update() {
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