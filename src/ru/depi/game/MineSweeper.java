package ru.depi.game;

import ru.depi.game.sweeper.Coord;
import ru.depi.game.sweeper.Game;
import ru.depi.game.sweeper.Ranges;
import ru.depi.game.sweeper.enums.Box;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

/**
 * @author DePi
 **/

public class MineSweeper extends JFrame {

    private Game game;

    private JPanel panel;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new MineSweeper();
    }

    private MineSweeper() {
        game = new Game(COLS, ROWS);
        Ranges.setSize(new Coord(COLS, ROWS));
        setImages();
        initPanel();
        initFrame();
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
        panel.setPreferredSize(new Dimension(
                Ranges.getSize().getX() * IMAGE_SIZE,
                Ranges.getSize().getY() * IMAGE_SIZE
        ));
        add(panel);
    }

    private void initFrame() {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("MineSweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
    }

    private void setImages() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name());
        }
    }
    
    private Image getImage(String name) {
        String fileName = "resources/img/" + name.toLowerCase(Locale.ROOT) + ".png";
        ImageIcon icon = new ImageIcon(fileName);
        return icon.getImage();
    }

}
