package MyPackage;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class Circle extends Shape {
    int radius;

    public Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius * 2, radius * 2);
    }
}
