package ui;

import model.Player;
import service.PlayerService;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    private PlayerService playerService;

    public LoginFrame() {

        playerService = new PlayerService();

        setTitle("Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2,10,10));

        panel.add(new JLabel("Username"));

        txtUsername = new JTextField();
        panel.add(txtUsername);

        panel.add(new JLabel("Password"));

        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        btnLogin = new JButton("Login");

        panel.add(new JLabel(""));
        panel.add(btnLogin);

        add(panel);

        btnLogin.addActionListener(e -> login());
    }

    private void login() {

        String username =
                txtUsername.getText();

        String password =
                new String(
                        txtPassword.getPassword()
                );

        Player player =
                playerService.login(
                        username,
                        password
                );

        if(player != null){

            JOptionPane.showMessageDialog(
                    this,
                    "Login Success"
            );

            new MainMenuFrame(player);

            dispose();

        }else{

            JOptionPane.showMessageDialog(
                    this,
                    "Login Failed"
            );
        }
    }
}