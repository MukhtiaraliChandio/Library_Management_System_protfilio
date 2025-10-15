package com.jframes.swing;

import java.awt.event.*;
import javax.swing.*;
import com.dao.LoginDao;
import com.dao.impl.LoginImpl;
import com.pojos.EmployeePojo;

public class LoginFrame implements ActionListener {

    LoginDao lo_dao = new LoginImpl();
    JFrame win;

    JLabel l1, l2, l3;
    JTextField userNametextField;
    JPasswordField passwordField;  // ✅ use JPasswordField instead of JTextField
    JButton loginBtn, resetBtn, exitBtn;

    public LoginFrame() {

        win = new JFrame("Login Form");
        win.setSize(500, 400);
        win.setLayout(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("LOGIN FORM");
        l1.setBounds(200, 30, 150, 30);
        win.add(l1);

        l2 = new JLabel("Username:");
        l2.setBounds(80, 100, 100, 30);
        win.add(l2);

        l3 = new JLabel("Password:");
        l3.setBounds(80, 150, 100, 30);
        win.add(l3);

        userNametextField = new JTextField();
        userNametextField.setBounds(160, 100, 230, 30);
        win.add(userNametextField);

        passwordField = new JPasswordField();  // ✅ hidden password input
        passwordField.setBounds(160, 150, 230, 30);
        win.add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(160, 220, 80, 30);
        win.add(loginBtn);

        resetBtn = new JButton("Reset");
        resetBtn.setBounds(250, 220, 80, 30);
        win.add(resetBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(340, 220, 80, 30);
        win.add(exitBtn);

        // ✅ Action listeners
        loginBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        win.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginBtn) {
            String username = userNametextField.getText().trim();
            String password = new String(passwordField.getPassword()); // ✅ get password safely

            EmployeePojo pojo = lo_dao.insertLogin(username); // your DAO should fetch data by username

            if (pojo == null) {
                JOptionPane.showMessageDialog(win, "❌ Username is Incorrect");
            } else {
                if (pojo.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(win, "✅ Login Successful");
                    win.dispose(); // close login window
                    new MainFrame(); // open next frame
                } else {
                    JOptionPane.showMessageDialog(win, "❌ Password is Incorrect");
                }
            }

        } else if (e.getSource() == resetBtn) {
            userNametextField.setText("");
            passwordField.setText("");

        } else if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
