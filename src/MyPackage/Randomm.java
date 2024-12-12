package MyPackage;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Randomm extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int type = random.nextInt(2); // 0 - circle, 1 - rectangle
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            int x = random.nextInt(getWidth());
            int y = random.nextInt(getHeight());
            int size = random.nextInt(50) + 10; // Size between 10 and 60

            Shape shape;
            if (type == 0) {
                shape = new Circle(color, x, y, size);
            } else {
                shape = new Rectangle(color, x, y, size, size);
            }
            shape.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new Randomm());
        frame.setVisible(true);
    }
}