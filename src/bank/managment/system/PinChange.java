package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinText1,pinText2;
    JButton change,back;
    String pinNUmber;
    PinChange(String pinNUmber){
        this.pinNUmber=pinNUmber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("Railway",Font.BOLD,16));
        text.setForeground(Color.white);
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pinText=new JLabel("New Pin:");
        pinText.setFont(new Font("Railway",Font.BOLD,16));
        pinText.setForeground(Color.white);
        pinText.setBounds(165,320,180,25);
        image.add(pinText);

        pinText1=new JPasswordField();
        pinText1.setFont(new Font("Railway",Font.BOLD,16));
        pinText1.setForeground(Color.white);
        pinText1.setBounds(330,320,180,25);
        image.add(pinText1);



        JLabel rePin=new JLabel("Re-Enter New Pin:");
        rePin.setFont(new Font("Railway",Font.BOLD,16));
        rePin.setForeground(Color.white);
        rePin.setBounds(165,375,180,25);
        image.add(rePin);
        pinText2=new JPasswordField();
        pinText2.setFont(new Font("Railway",Font.BOLD,16));
        pinText2.setForeground(Color.white);
        pinText2.setBounds(330,375,180,25);
        image.add(pinText2);

        change=new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==change) {
            try {
                String pin = pinText1.getText();
                String pin2 = pinText2.getText();
                if (!pin.equals(pin2)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }
                if(pin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new pin");
                    return;
                }
                if(pin2.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new pin");
                    return;
                }
                if (!pin.matches("\\d{4}")) {
                    JOptionPane.showMessageDialog(null, "PIN must be exactly 4 digits");
                    return;
                }
                Conn conn=new Conn();
                String q1="update bank set pin='"+pin2+"' where pin='"+pinNUmber+"'";
                String q2="update  login set pin='"+pin2+"' where pin='"+pinNUmber+"'";
                String q3="update signupThree set pin='"+pin2+"' where pin='"+pinNUmber+"'";
                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new Transactions(pin2).setVisible(true);


            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(pinNUmber).setVisible(true);
        }
    }

    static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
