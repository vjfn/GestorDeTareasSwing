package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Login extends JFrame {
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField txtUsuario;
    private JButton loginButton;
    private JLabel info;

    public Login() {
        this.setResizable(false);
        this.setSize(300,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        loginButton.addActionListener(e -> {loginUser();});
    }

    private void loginUser(){
        String user = txtUsuario.getText();
        String pass = new String(passwordField1.getPassword());

        System.out.println(user+pass);
        if (!validateUser(user,pass)){
            info.setText("Usuario Incorrecto");
            info.setForeground(Color.RED);
            txtUsuario.setText(" ");
            passwordField1.setText(" ");
        }else {
            this.dispose();
            Principal ventana = new Principal();
            ventana.load();
        };
    }

    private Boolean validateUser(String user, String pass) {
        return (("victor".equals(user)&&("1234".equals(pass))));
    }


    public void load(){
        this.setVisible(true);
    }
}
