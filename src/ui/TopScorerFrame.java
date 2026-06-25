package ui;

import model.Player;
import service.PlayerService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TopScorerFrame extends JFrame {

    private JTable table;

    public TopScorerFrame() {

        setTitle("Top 5 Scorers");
        setSize(600,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();

        loadData();

        setVisible(true);
    }

    private void initComponents() {

        String[] columns = {
                "Username",
                "Wins",
                "Losses",
                "Draws",
                "Score"
        };

        DefaultTableModel model =
                new DefaultTableModel(
                        columns,
                        0
                );

        table =
                new JTable(model);

        JScrollPane scrollPane =
                new JScrollPane(table);

        add(scrollPane);
    }

    private void loadData() {

        PlayerService ps =
                new PlayerService();

        ArrayList<Player> players =
                ps.getTopFiveScorers();

        DefaultTableModel model =
                (DefaultTableModel)
                        table.getModel();

        for(Player player : players){

            model.addRow(
                    new Object[]{
                            player.getUsername(),
                            player.getWins(),
                            player.getLosses(),
                            player.getDraws(),
                            player.getScore()
                    }
            );
        }
    }
}