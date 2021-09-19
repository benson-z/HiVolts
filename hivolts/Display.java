package hivolts;

import java.security.Key;
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Display extends JPanel {
    private Board board;
    private Player player;
    private Vector<Mho> mhos = new Vector<Mho>();
    private int[][] mholist = new int[12][2];
    private BufferedImage image = null;
    private boolean playerDeath = false;
    private int moves;
    public Display() {
        setup();
        try {
            image = ImageIO.read(new File("hivolts/fence.png"));
        } catch (IOException e) {
        }
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = 0;
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    player.move(-1, -1);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    player.move(0, -1);
                } else if (e.getKeyCode() == KeyEvent.VK_E) {
                    player.move(1, -1);
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    player.move(-1, 0);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    player.move(0, 0);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    player.move(1, 0);
                } else if (e.getKeyCode() == KeyEvent.VK_Z) {
                    player.move(-1, 1);
                } else if (e.getKeyCode() == KeyEvent.VK_X) {
                    player.move(0, 1);
                } else if (e.getKeyCode() == KeyEvent.VK_C) {
                    player.move(1, 1);
                } else if (e.getKeyCode() == KeyEvent.VK_J) {
                    player.moveToRandom();
                    code = 1;
                } else if (e.getKeyCode() == KeyEvent.VK_R) {
                    setup();
                    code = 1;
                }
                moves ++;
                if (code == 0) {
                    for (int a = 0; a < mhos.size(); a++) {
                        if (!mhos.get(a).update()) {
                            mhos.remove(a);
                            mholist[a][0] = 0;
                            mholist[a][1] = 0;
                        } else {
                            mholist[a][0] = mhos.get(a).getX();
                            mholist[a][1] = mhos.get(a).getY();
                        }
                    }
                }
                for (int a = 0; a < mhos.size(); a++)
                    if (player.getX() == mholist[a][0] && player.getY() == mholist[a][1])
                        playerDeath = true;

                if (board.getCell(player.getX(), player.getY()) == 1)
                    playerDeath = true;

                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public Dimension getPreferredSize() {
        return new Dimension(240, 240);
    }

    private void setup() {
        this.board = new Board();
        this.player = new Player(0, 0, board);
        this.player.moveToRandom();
        this.playerDeath = false;
        this.moves = 0
        mhos = new Vector<Mho>();
        for (int a = 0; a < 12; a++) {
            int x = ThreadLocalRandom.current().nextInt(1, 11);
            int y = ThreadLocalRandom.current().nextInt(1, 11);
            if (board.getCell(x, y) != 1) {
                int c = 0;
                for (Mho b : mhos) {
                    if (b.getX() == x && b.getY() == y) {
                        c = 1;
                        break;
                    }
                }
                if (c == 0) {
                    mhos.add(new Mho(x, y, player, board, mholist));
                    mholist[a][0] = x;
                    mholist[a][1] = y;
                } else {
                    a--;
                }
            } else {
                a--;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        if (playerDeath) {
            g2d.setColor(Color.RED);
            g2d.fillRect(0, 0, 240, 240);
            Font font = new Font("Serif", Font.PLAIN, 24);
            g2d.setFont(font);
            g2d.setColor(Color.BLACK);
            g2d.drawString("You lose!", 80, 120);
        } else if (mhos.size() == 0) {
            g2d.setColor(Color.GREEN);
            g2d.fillRect(0, 0, 240, 240);
            Font font = new Font("Serif", Font.PLAIN, 24);
            g2d.setFont(font);
            g2d.setColor(Color.BLACK);
            g2d.drawString("You win!", 80, 120);
        } else {
            for (int y = 0; y < 12; y++) {
                for (int x = 0; x < 12; x++) {
                    if (board.getCell(x, y) == 1) {
                        g2d.drawImage(image, x * 20, y * 20, null);
                    }
                }
            }
            g2d.setColor(Color.RED);
            g2d.fillRect(player.getX() * 20, player.getY() * 20, 20, 20);
            for (Mho a : mhos) {
                g2d.setColor(Color.GREEN);
                g2d.fillRect(a.getX() * 20, a.getY() * 20, 20, 20);
            }
        }
    }
}