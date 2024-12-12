package MyPackage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Задание 1
        SwingUtilities.invokeLater(FootballMatch::new);

        // Задание 2
        SwingUtilities.invokeLater(() -> {
            JFrame frame2 = new JFrame("Random Shapes");
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setSize(500, 500);
            frame2.add(new Randomm());
            frame2.setVisible(true);
        });

        // Задание 3:
        if (args.length == 1) {
            try {
                SwingUtilities.invokeLater(() -> {
                    try {
                        new Image(args[0]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                System.err.println("Ошибка при отображении изображения: " + e.getMessage());
            }
        } else {
            System.out.println("Для задания 3 укажите путь к изображению при запуске программы.");
        }

        // Задание 4
        String animationDirectory = "/matveyaleks/Загрузки/Джава/frame1.png";
        SwingUtilities.invokeLater(() -> {
            JFrame frame4 = new JFrame("Animation");
            frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame4.setSize(300, 300);
            try {
                frame4.add(new Animation());
            } catch (IOException e) {
                System.err.println("Ошибка при загрузке анимации: " + e.getMessage());
                frame4.dispose(); // Закрываем окно при ошибке
            }
            frame4.setVisible(true);
        });
    }
}