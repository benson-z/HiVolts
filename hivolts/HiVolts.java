//package hivolts;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.*;

import hivolts.*;

public class HiVolts {
    public static void main(String[] args) {
        new HiVolts();
    }
    public HiVolts() {
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
                //JButton button = new JButton("Quit");
                //frame.add(button);
                Display display = new Display();
                frame.add(display);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                /*button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        frame.dispose();
                    }
                });*/
            }
        });
    }
}