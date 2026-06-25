package ui;

import logic.GameLogic;
import model.Player;
import service.PlayerService;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private Player currentPlayer;

    private GameLogic gameLogic;
    private PlayerService playerService;

    private JButton[] buttons;

    private JLabel lblStatus;

    private JButton btnBack;

    public GameFrame(Player player) {

        this.currentPlayer = player;

        gameLogic = new GameLogic();
        playerService = new PlayerService();

        setTitle("Tic Tac Toe");
        setSize(500, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {

        setLayout(new BorderLayout());

        lblStatus =
                new JLabel(
                        "You are X",
                        SwingConstants.CENTER
                );

        add(lblStatus, BorderLayout.NORTH);

        JPanel boardPanel =
                new JPanel();

        boardPanel.setLayout(
                new GridLayout(3, 3)
        );

        buttons = new JButton[9];

        for (int i = 0; i < 9; i++) {

            buttons[i] = new JButton("");

            buttons[i].setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            40
                    )
            );

            final int index = i;

            buttons[i].addActionListener(e -> {

                handlePlayerMove(index);

            });

            boardPanel.add(buttons[i]);
        }

        add(boardPanel, BorderLayout.CENTER);

        btnBack =
                new JButton("Back To Menu");

        btnBack.addActionListener(e -> {

            dispose();

            new MainMenuFrame(currentPlayer);

        });

        add(btnBack, BorderLayout.SOUTH);
    }

    private void handlePlayerMove(int position) {

        boolean success =
                gameLogic.makeMove(
                        position,
                        'X'
                );

        if (!success) {
            return;
        }

        buttons[position].setText("X");

        if (gameLogic.checkWinner('X')) {

            finishGame("WIN");

            return;
        }

        if (gameLogic.isDraw()) {

            finishGame("DRAW");

            return;
        }

        int cpuMove =
                gameLogic.computerMove();

        buttons[cpuMove].setText("O");

        if (gameLogic.checkWinner('O')) {

            finishGame("LOSE");

            return;
        }

        if (gameLogic.isDraw()) {

            finishGame("DRAW");
        }
    }

    private void finishGame(String result) {

        // Update database
        playerService.updateStatistics(
                currentPlayer,
                result
        );

        // Update object di memory
        if (result.equals("WIN")) {

            currentPlayer.setWins(
                    currentPlayer.getWins() + 1
            );

            currentPlayer.setScore(
                    currentPlayer.getScore() + 10
            );

        } else if (result.equals("DRAW")) {

            currentPlayer.setDraws(
                    currentPlayer.getDraws() + 1
            );

            currentPlayer.setScore(
                    currentPlayer.getScore() + 3
            );

        } else if (result.equals("LOSE")) {

            currentPlayer.setLosses(
                    currentPlayer.getLosses() + 1
            );
        }

        // Tampilkan hasil
        if (result.equals("WIN")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Congratulations! You Win!"
            );

        } else if (result.equals("LOSE")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Computer Wins!"
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "It's a Draw!"
            );
        }

        dispose();

        new MainMenuFrame(currentPlayer);
    }
}