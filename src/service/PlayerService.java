package service;

import database.DatabaseManager;
import model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlayerService {

    public Player login(String username, String password) {

        String sql =
                "SELECT * FROM players " +
                        "WHERE username = ? AND password = ?";

        try {

            Connection conn =
                    DatabaseManager.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs =
                    stmt.executeQuery();

            if (rs.next()) {

                Player player =
                        new Player(
                                rs.getInt("id"),
                                rs.getString("username"),
                                rs.getInt("wins"),
                                rs.getInt("losses"),
                                rs.getInt("draws"),
                                rs.getInt("score")
                        );

                conn.close();

                return player;
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public void updateStatistics(Player player,
                                 String result) {

        String sql = "";

        if (result.equals("WIN")) {

            sql =
                    "UPDATE players " +
                            "SET wins = wins + 1, " +
                            "score = score + 10 " +
                            "WHERE id = ?";

        } else if (result.equals("DRAW")) {

            sql =
                    "UPDATE players " +
                            "SET draws = draws + 1, " +
                            "score = score + 3 " +
                            "WHERE id = ?";

        } else if (result.equals("LOSE")) {

            sql =
                    "UPDATE players " +
                            "SET losses = losses + 1 " +
                            "WHERE id = ?";
        }

        try {

            Connection conn =
                    DatabaseManager.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(1, player.getId());

            stmt.executeUpdate();

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public ArrayList<Player> getTopFiveScorers() {

        ArrayList<Player> players =
                new ArrayList<>();

        String sql =
                "SELECT * FROM players " +
                        "ORDER BY score DESC, wins DESC " +
                        "LIMIT 5";

        try {

            Connection conn =
                    DatabaseManager.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery();

            while (rs.next()) {

                players.add(

                        new Player(
                                rs.getInt("id"),
                                rs.getString("username"),
                                rs.getInt("wins"),
                                rs.getInt("losses"),
                                rs.getInt("draws"),
                                rs.getInt("score")
                        )
                );
            }

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return players;
    }
}