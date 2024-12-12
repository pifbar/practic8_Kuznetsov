package MyPackage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Animation extends JPanel implements Runnable {

    private List<BufferedImage> frames = new ArrayList<>();
    private int currentFrame = 0;

    public Animation() throws IOException {

        for (int i = 1; ; i++) {
            try {
                BufferedImage frame = ImageIO.read(new File("frame" + i + ".png"));
                frames.add(frame);
            } catch (IOException e) {
                break;
            }
        }

        new Thread(this).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!frames.isEmpty()) {
            g.drawImage(frames.get(currentFrame), 0, 0, this);
        }
    }

    @Override
    public void run() {
        while (true) {
            currentFrame = (currentFrame + 1) % frames.size();
            repaint();
            try {
                Thread.sleep(100);
            } catch (ArithmeticException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        try {
            frame.add(new Animation());
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setVisible(true);
    }
}