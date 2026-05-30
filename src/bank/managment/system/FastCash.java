package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends  JFrame implements ActionListener {
    JButton five,thousand,two,fiveThousand,ten,twenty,exit;
    String pinNUmber;
    FastCash (String pinNUmber){
        this.pinNUmber=pinNUmber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Select withdrawal amount");
        text.setFont(new Font("Railway",Font.BOLD,16));
        text.setForeground(Color.white);
        text.setBounds(220,300,700,35);
        image.add(text);

        five=new JButton("Rs 500");
        five.setBounds(170,415,150,30);
        five.addActionListener(this);
        image.add(five);

        thousand =new JButton("Rs 1000");
        thousand.setBounds(355,415,150,30);
        thousand.addActionListener(this);
        image.add(thousand );

        two=new JButton("Rs 2000");
        two.setBounds(170,450,150,30);
        two.addActionListener(this);
        image.add(two);

        fiveThousand=new JButton("Rs 5000");
        fiveThousand.setBounds(355,450,150,30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        ten=new JButton("Rs 10000");
        ten.setBounds(170,485,150,30);
        ten.addActionListener(this);
        image.add(ten);

        twenty=new JButton("Rs 20000");
        twenty.setBounds(355,485,150,30);
        twenty.addActionListener(this);
        image.add(twenty);


        exit=new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add( exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit){
            setVisible(false);
            new Transactions(pinNUmber).setVisible(true);
        } else  {
            String amount=((JButton)e.getSource()).getText().substring(3);
            Conn c=new Conn();

            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNUmber+"'");
                int balance=0;

                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return; // 🚀 critical fix
                }

                Date date=new Date();
                String query="insert into bank values('"+pinNUmber+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinNUmber).setVisible(true);

            } catch (Exception e1){
                System.out.println(e1);
            }
        }
    }
    static void main(String[] args) {
        new FastCash ("");
    }
}

