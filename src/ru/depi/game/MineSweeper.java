package ru.depi.game;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Objects;

/**
 * @author DePi
 **/

public class MineSweeper extends JFrame {

    private JPanel panel;
    private final int COLS = 15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new MineSweeper();
    }

    private MineSweeper() {
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(getImage("bomb"), 0, 0, this);
                g.drawImage(getImage("num1"), IMAGE_SIZE, 0, this);
            }
        };
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
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

    private Image getImage(String name) {
        String fileName = "resources/img/" + name.toLowerCase(Locale.ROOT) + ".png";
        ImageIcon icon = new ImageIcon(fileName);
        return icon.getImage();
    }

}
