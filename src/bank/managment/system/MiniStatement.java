package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;


public class MiniStatement extends  JFrame {
    String pinNUmber;
    MiniStatement(String pinNUmber){
        this.pinNUmber = pinNUmber;
              setTitle("Mini Statement");
              setLayout(null);

              JLabel text=new JLabel();
              text.setBounds(20,140,400,200);
              add(text);

              JLabel bank=new JLabel("State Bank of India");
              bank.setBounds(150,20,150,20);
              add(bank);

              JLabel card=new JLabel();
              card.setBounds(20,80,300,20);
              add(card);

              JLabel balance=new JLabel();
              balance.setBounds(20,400,300,20);
              add(balance);
              try{
                  Conn conn=new Conn();
                  ResultSet rs= conn.s.executeQuery("select * from login where pin='"+pinNUmber+"'");
                  while(rs.next()){
                      card.setText("Card Number:"+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
                  }
              }catch(Exception ex){
                  System.out.println(ex);
              }
        try{
            Conn conn=new Conn();
            int bal=0;
            ResultSet rs= conn.s.executeQuery("select * from bank where pin='"+pinNUmber+"'");
            while(rs.next()){
                text.setText(text.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>");
                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }else{
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your account balance is Rs."+bal);
        }catch(Exception ex){
            System.out.println(ex);
        }



              setSize(400,600);
              setLocation(20,20);
              getContentPane().setBackground(Color.WHITE);
              setVisible(true);
    }
    public static void main(){
        new MiniStatement("");
    }
}
