import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import hivolts.*;

public class HiVolts {
    public static void main(String[] args) {
        Board game = new Board();
        new HiVolts(game);
    }
    public HiVolts(Board game) {
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
                Display display = new Display(game);
                frame.add(display);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}