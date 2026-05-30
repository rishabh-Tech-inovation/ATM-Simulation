package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/*
 * =========================================
 *           ATM LOGIN CLASS
 * =========================================
 * This class creates the Login page of the
 * Bank Management System.
 * It handles user input for:
 *  - Card Number
 *  - PIN
 *  - Button Actions (Sign In, Clear, Sign Up)
 * =========================================
 */

public class login extends JFrame implements ActionListener {

    // ================== DECLARATION SECTION ==================
    JButton login, signUp, clear;
    JTextField cardNo;
    JPasswordField pinNo;

    // ================== CONSTRUCTOR ==================
    login() {

        // Frame Settings
        setLayout(null);
        setSize(800, 500);
        getContentPane().setBackground(Color.WHITE);
        setLocation(350, 50);
        setTitle("Automated Teller Machine");

        // ================== LOGO SECTION ==================
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l1 = new JLabel(i3);
        l1.setBounds(70, 10, 100, 100);
        add(l1);

        // ================== HEADING TEXT ==================
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Times New Roman", Font.BOLD, 35));
        text.setBounds(200, 40, 400, 40);
        add(text);

        // ================== CARD NUMBER FIELD ==================
        JLabel text1 = new JLabel("Card No.:");
        text1.setFont(new Font("Raleway", Font.BOLD, 25));
        text1.setBounds(120, 150, 150, 30);
        add(text1);

        cardNo = new JTextField();
        cardNo.setBounds(250, 150, 250, 30);
        cardNo.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardNo);

        // ================== PIN FIELD ==================
        JLabel text2 = new JLabel("PIN:");
        text2.setFont(new Font("Raleway", Font.BOLD, 25));
        text2.setBounds(120, 220, 150, 30);
        add(text2);

        pinNo = new JPasswordField();
        pinNo.setBounds(250, 220, 250, 30);
        pinNo.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinNo);

        // ================== BUTTON SECTION ==================
        login = new JButton("Sign In");
        login.setBounds(250, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(400, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(250, 350, 250, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        setVisible(true);
    }

    // ================== BUTTON ACTION LOGIC ==================
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clear) {
            // Clear input fields
            cardNo.setText("");
            pinNo.setText("");

        } else if (e.getSource() == login) {
            // Login logic will be implemented here
            Conn conn=new Conn();
            String cardNo1=cardNo.getText();
            String pinNo1=pinNo.getText();
            String query="select* from login where cardNumber ='"+cardNo1+"' and pin ='"+pinNo1+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNo1).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or Pin");
                }
            }catch (Exception ex){
                System.out.println(ex);
            }

        } else if (e.getSource() == signUp) {
            // Sign up navigation logic will be implemented here
            setVisible(false);
            new SignUp().setVisible(true);
        }
    }

    // ================== MAIN METHOD ==================
    static void main(String[] args) {
        new login();
    }
}
