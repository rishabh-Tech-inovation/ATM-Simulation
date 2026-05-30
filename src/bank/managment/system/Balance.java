package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener {
    JButton back;
    String pinNUmber;
    Balance(String pinNUmber) {
        this.pinNUmber=pinNUmber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);



        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        Conn c=new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pinNUmber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        JLabel balanceLabel=new JLabel("Your current Account balance is "+balance);
        balanceLabel.setForeground(Color.white);
        balanceLabel.setBounds(170,300,400,30);
        image.add(balanceLabel);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent e) {
          setVisible(false);
          new Transactions(pinNUmber).setVisible(true);
    }
    static void main(String[] args) {
        new Balance("");
    }
}
