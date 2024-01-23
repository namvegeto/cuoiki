package view;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {

    public JFrame frame = new JFrame();
    public JTextField textField = new JTextField();
    public JPasswordField passwordField = new JPasswordField();

    public void initialize() {
        frame = new JFrame("Login Page");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setBounds(36, 65, 86, 20);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(134, 62, 130, 26);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(36, 115, 86, 20);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(134, 112, 130, 26);
        frame.getContentPane().add(passwordField);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBounds(184, 171, 89, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = textField.getText();
                String pass = new String(passwordField.getPassword());
                if (user.equals("admin") && pass.equals("admin")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials");
                }
            }
        });
    }
}