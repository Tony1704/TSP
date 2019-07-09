package app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * UI
 */
public class UI {
    public static void runUI(Node[] nodes, double totalDistance) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initializeUI(nodes, totalDistance);
            }
        });
    }

    private static void initializeUI(Node[] nodes, double totalDistance) {
        SwingUtilities.isEventDispatchThread();
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel(nodes, totalDistance));
        f.pack();
        f.setVisible(true);
    }
    
}