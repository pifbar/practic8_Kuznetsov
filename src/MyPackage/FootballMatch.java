package MyPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FootballMatch extends JFrame {

    private int milanScore = 0;
    private int madridScore = 0;
    private String lastScorer = "N/A";
    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    public FootballMatch() {
        setTitle("AC Milan vs Real Madrid");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JButton milanButton = new JButton("AC Milan");
        JButton madridButton = new JButton("Real Madrid");
        resultLabel = new JLabel("Result: 0 X 0");
        lastScorerLabel = new JLabel("Last Scorer: N/A");
        winnerLabel = new JLabel("Winner: DRAW");

        milanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanScore++;
                updateResult();
            }
        });

        madridButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                madridScore++;
                updateResult();
            }
        });

        add(milanButton);
        add(madridButton);
        add(resultLabel);
        add(lastScorerLabel);
        add(winnerLabel);

        setVisible(true);
    }

    private void updateResult() {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);

        if (milanScore > madridScore) {
            winnerLabel.setText("Winner: AC Milan");
            lastScorer = "AC Milan";
        } else if (madridScore > milanScore) {
            winnerLabel.setText("Winner: Real Madrid");
            lastScorer = "Real Madrid";
        } else {
            winnerLabel.setText("Winner: DRAW");
            lastScorer = "N/A";
        }
        lastScorerLabel.setText("Last Scorer: " + lastScorer);
    }

    public static void main(String[] args) {
        new FootballMatch();
    }
}