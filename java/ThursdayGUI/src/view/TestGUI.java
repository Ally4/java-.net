package view;

import javax.swing.*;

/**
 *
 * @author jeremie
 */
public class TestGUI {
    public static void main(String[] args) {
        // container
        JFrame frame = new JFrame("Thursday");
        frame.setSize(300, 400);
        // add component on contation
        JButton btn = new JButton();
        btn.setText("SignUP");
        frame.add(btn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
