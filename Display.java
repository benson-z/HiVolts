package hivolts;

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

public class Display extends JPanel {
    private Board board;
    private Player player;
    private Vector<Mho> mhos = new Vector<Mho>();
    public Display(Board board) {
        this.board = board;
        player = new Player(0, 0, board);
        for (int a=0; a<12; a++) {
            int x = ThreadLocalRandom.current().nextInt(0, 12);
            int y = ThreadLocalRandom.current().nextInt(0, 12);
            if (board.getCell(x, y) != 1) {
                int c = 0;
                for (Mho b : mhos) {
                    if (b.getX() == x && b.getY() == y) {
                        c = 1;
                        break;
                    }
                }
                if (c == 0) {
                    mhos.add(new Mho(x, y, player));
                }
                else {
                    a--;
                }
            }
            else {
                a--;
            }
        }
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
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
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    public Dimension getPreferredSize () {
        return new Dimension(240, 240);
    }
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 12; x++) {
                if (board.getCell(x, y) == 1) {
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(x * 20, y * 20, 20, 20);
                }
            }
        }
        g2d.setColor(Color.RED);
        g2d.fillRect(player.getX()*20, player.getY()*20, 20, 20);
        for (Mho a : mhos) {
            g2d.setColor(Color.GREEN);
            g2d.fillRect(a.getX()*20, a.getY()*20, 20, 20);
        }
    }
}