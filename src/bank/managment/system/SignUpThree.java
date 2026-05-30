package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit ,cancel;
    String formno;
    SignUpThree(String formno) {
        this.formno = formno;
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 190, 150, 20);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(300, 190, 250, 20);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 230, 150, 20);
        add(r3);

        r4=new JRadioButton("Reoccurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(300, 230, 250, 20);
        add(r4);
        ButtonGroup st=new ButtonGroup();
        st.add(r1);
        st.add(r2);
        st.add(r3);
        st.add(r4);

        JLabel card=new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD,22));
        card.setBounds(100, 300, 200, 30);
        add(card);
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD,22));
        number.setBounds(330, 300, 300, 30);
        add(number);
        JLabel details=new JLabel("Your 16 digit card number");
        details.setFont(new Font("Raleway", Font.BOLD,12));
        details.setBounds(100, 320, 200, 30);
        add(details);

        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100, 350, 200, 30);
        add(pin);
        JLabel number1=new JLabel("XXXX");
        number1.setFont(new Font("Raleway", Font.BOLD,22));
        number1.setBounds(330, 350, 300, 30);
        add(number1);
        JLabel details1=new JLabel("Your 4 digit password");
        details1.setFont(new Font("Raleway", Font.BOLD,12));
        details1.setBounds(100, 370, 200, 30);
        add(details1);


        JLabel service=new JLabel("Services Required");
        service.setFont(new Font("Raleway", Font.BOLD,22));
        service.setBounds(100, 430, 200, 30);
        add(service);

        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBounds(100, 480, 200, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2=new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBounds(350, 480, 200, 30);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3=new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBounds(100, 540, 200, 30);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4=new JCheckBox("EMAIL & SMS ALERT");
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBounds(350, 540, 200, 30);
        c4.setBackground(Color.WHITE);
        add(c4);

        c5=new JCheckBox("CHEQUE BOOK");
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBounds(100, 600, 200, 30);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6=new JCheckBox("E-STATEMENT");
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBounds(350, 600, 200, 30);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        c7.setBounds(100, 670, 600, 30);
        c7.setBackground(Color.WHITE);
        add(c7);

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD,16));
        submit.setBounds(220 ,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD,16));
        cancel.setBounds(500 ,720,100,30);
        cancel.addActionListener(this);
        add(cancel);



        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
                String accountType=null;
                if(r1.isSelected()){
                    accountType="Saving Account";
                }else if(r2.isSelected()){
                    accountType="Fixed Deposit Account";
                }else if(r3.isSelected()){
                    accountType="Current Account";
                }else if(r4.isSelected()){
                    accountType="Reoccurring Deposit Account";
                }
                Random rand=new Random();
                String cordNumber=""+Math.abs((rand.nextLong()%90000000L)+5040936000000000L);
                String pinNUmber=""+Math.abs((rand.nextLong()%9000L)+1000L);
                String facilities="";
                if(c1.isSelected()){
                    facilities=facilities+" ATM CARD";
                }else if(c2.isSelected()){
                    facilities=facilities+" INTERNET BANKING";
                }else if(c3.isSelected()){
                    facilities=facilities+" EMAIL & SMS ALERT";
                }else if(c4.isSelected()){
                    facilities=facilities+" MOBILE BANKING";
                }else if(c5.isSelected()){
                    facilities=facilities+" CHEQUE BOOK";
                }else if(c6.isSelected()){
                    facilities=facilities+" E-STATEMENT";
                }
                try {
                    if(accountType.equals("")){
                        JOptionPane.showMessageDialog(this,"Please enter your Account Type");
                    }else{
                        Conn vonn=new Conn();
                        String query="insert into signupThree values ('"+formno+"','"+accountType+"','"+cordNumber+"','"+pinNUmber+"','"+facilities+"') ";
                        String query1="insert into login values ('"+formno+"','"+cordNumber+"','"+pinNUmber+"') ";
                        vonn.s.executeUpdate(query);
                        vonn.s.executeUpdate(query1);


                        JOptionPane.showMessageDialog(null,"Card NUmber:"+cordNumber+"\nPIN:"+pinNUmber);
                        setVisible(false);
                        new Deposit(pinNUmber).setVisible(true);
                    }

                }catch(Exception ex) {
                    System.out.println(ex);
                }
        }else if(e.getSource()==cancel){
               setVisible(false);
               new login().setVisible(true);
        }
    }
    static void main(String[] args) {
        new SignUpThree("");
    }
}
