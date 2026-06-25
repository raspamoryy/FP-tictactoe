package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    private Player currentPlayer;

    private JLabel lblWelcome;

    private JButton btnStartGame;
    private JButton btnStatistics;
    private JButton btnTopScorer;
    private JButton btnExit;

    public MainMenuFrame(Player player) {

        this.currentPlayer = player;

        setTitle("Tic Tac Toe - Main Menu");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        lblWelcome = new JLabel(
                "Welcome, " + currentPlayer.getUsername(),
                SwingConstants.CENTER
        );

        btnStartGame = new JButton("Start Game");

        btnStatistics = new JButton("My Statistics");

        btnTopScorer = new JButton("Top Scorers");

        btnExit = new JButton("Exit");

        panel.add(lblWelcome);
        panel.add(btnStartGame);
        panel.add(btnStatistics);
        panel.add(btnTopScorer);
        panel.add(btnExit);

        add(panel);

        // START GAME
        btnStartGame.addActionListener(e -> {

            new GameFrame(currentPlayer);

        });

        // STATISTICS
        btnStatistics.addActionListener(e -> {

            new StatisticsFrame(currentPlayer);

        });

        // TOP SCORERS
        btnTopScorer.addActionListener(e -> {

            new TopScorerFrame();

        });

        // EXIT
        btnExit.addActionListener(e -> {

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to exit?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {

                System.exit(0);

            }
        });
    }
}