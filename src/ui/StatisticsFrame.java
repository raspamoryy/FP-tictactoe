package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {

    private Player player;

    public StatisticsFrame(Player player) {

        this.player = player;

        setTitle("My Statistics");
        setSize(300,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {

        JPanel panel = new JPanel();

        panel.setLayout(
                new GridLayout(5,1,10,10)
        );

        JLabel lblUsername =
                new JLabel(
                        "Username : "
                                + player.getUsername()
                );

        JLabel lblWins =
                new JLabel(
                        "Wins : "
                                + player.getWins()
                );

        JLabel lblLosses =
                new JLabel(
                        "Losses : "
                                + player.getLosses()
                );

        JLabel lblDraws =
                new JLabel(
                        "Draws : "
                                + player.getDraws()
                );

        JLabel lblScore =
                new JLabel(
                        "Score : "
                                + player.getScore()
                );

        panel.add(lblUsername);
        panel.add(lblWins);
        panel.add(lblLosses);
        panel.add(lblDraws);
        panel.add(lblScore);

        add(panel);
    }
}