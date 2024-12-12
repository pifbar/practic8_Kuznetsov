package MyPackage;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

abstract class Shape {
    Color color;
    int x, y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    abstract void draw(Graphics g);
}