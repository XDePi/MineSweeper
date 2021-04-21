package ru.depi.game;

import javax.swing.*;
import java.awt.*;

/**
 * @author DePi
 **/

public class MineSweeper extends JFrame {

    private JPanel panel;

    public static void main(String[] args) {
        new MineSweeper();
    }

    private MineSweeper() {
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        add(panel);
    }

    private void initFrame() {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("MineSweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
