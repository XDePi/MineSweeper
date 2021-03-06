package ru.depi.game;

import ru.depi.game.sweeper.Coord;
import ru.depi.game.sweeper.Game;
import ru.depi.game.sweeper.Ranges;
import ru.depi.game.sweeper.enums.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

/**
 * @author DePi
 **/

public class MineSweeper extends JFrame {

    private Game game;

    private JPanel panel;
    private JLabel label;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int BOMBS = 10;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new MineSweeper();
    }

    private MineSweeper() {
        game = new Game(COLS, ROWS, BOMBS);
        game.start();
        Ranges.setSize(new Coord(COLS, ROWS));
        setImages();
        initLabel();
        initPanel();
        initFrame();
    }

    private void initLabel() {
        label = new JLabel("Welcome!");
        add(label, BorderLayout.SOUTH);
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoords()) {
                    g.drawImage((Image)game.getBox(coord).image,
                            coord.getX() * IMAGE_SIZE, coord.getY() * IMAGE_SIZE,this);
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Coord coord = new Coord(x, y);
                if (e.getButton() == MouseEvent.BUTTON1)
                    game.pressLeftButton(coord);
                if (e.getButton() == MouseEvent.BUTTON3)
                    game.pressRightButton(coord);
                if (e.getButton() == MouseEvent.BUTTON2)
                    game.start();
                label.setText(getMessage());
                panel.repaint();
            }
        });

        panel.setPreferredSize(new Dimension(
                Ranges.getSize().getX() * IMAGE_SIZE,
                Ranges.getSize().getY() * IMAGE_SIZE));
        add(panel);
    }

    private String getMessage() {
        switch (game.getState()) {
            case PLAYED : return "In progress..";
            case BOMBED : return "Mission failed";
            case WINNER : return "Mission success";
            default : return "Welcome";
        }
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("MineSweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
        pack();
    }

    private void setImages() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name());
        }
    }
    
    private Image getImage(String name) {
        String fileName = "src/resources/img/" + name.toLowerCase(Locale.ROOT) + ".png";
        ImageIcon icon = new ImageIcon(fileName);
        return icon.getImage();
    }

}
