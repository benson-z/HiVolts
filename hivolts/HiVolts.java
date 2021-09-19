import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Scanner;

import hivolts.*;

public class HiVolts {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        new HiVolts(myObj.nextInt(), myObj.nextInt());
    }
    public HiVolts(int boardx, int boardy) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                JFrame frame = new JFrame("HiVolts");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Display display = new Display(boardx, boardy);
                frame.add(display);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}