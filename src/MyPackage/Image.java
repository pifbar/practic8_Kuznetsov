package MyPackage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends JFrame {

    public Image(String imagePath) throws IOException {
        setTitle("Image Viewer");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage image = ImageIO.read(new File(imagePath));
        JLabel label = new JLabel(new ImageIcon(image));
        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ImageViewer <image_path>");
            return;
        }
        try {
            new Image(args[0]);
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
    }
}