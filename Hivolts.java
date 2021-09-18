import hivolts.*;

class Hivolts {
    public static void hivolts(String[] args) {
        Board game = new Board();
        new Hivolts(game);
    }
    public Hivolts(Board game) {
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