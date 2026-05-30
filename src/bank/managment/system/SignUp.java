package bank.managment.system;

// Importing Swing components (JFrame, JLabel, JButton, etc.)
import javax.swing.*;

// Importing AWT classes (Font, Color, etc.)
import java.awt.*;

// Importing utility classes (Random)
import java.util.*;

// Importing external library for date chooser (JCalendar)
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener {
    long random;
    JTextField n1,n2,n6,n8,n9,n10,n11;
    JRadioButton male,female,married,unmarried;
    JButton next;
    JDateChooser d4;

    // Constructor of SignUp class
    SignUp(){

        // Generate a random 4-digit application number
        Random ran = new Random();
         random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        // Label for displaying application form number
        JLabel formNo = new JLabel("Application Form No." + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(150, 20, 600, 40);
        add(formNo);

        // Page title label
        JLabel t1 = new JLabel("Page1:Personal Details");
        t1.setFont(new Font("Raleway", Font.BOLD, 20));
        t1.setBounds(290, 80, 400, 30);
        add(t1);

        // Name label and text field
        JLabel t2 = new JLabel("Name:");
        t2.setFont(new Font("Raleway", Font.BOLD, 20));
        t2.setBounds(100, 140, 100, 30);
        add(t2);

         n1 = new JTextField();
        n1.setBounds(300, 140, 400, 30);
        add(n1);

        // Father's Name label and text field
        JLabel t3 = new JLabel("Father's Name:");
        t3.setFont(new Font("Raleway", Font.BOLD, 20));
        t3.setBounds(100, 190, 200, 30);
        add(t3);

         n2 = new JTextField();
        n2.setBounds(300, 190, 400, 30);
        add(n2);

        // Date of Birth label and date chooser
        JLabel t4 = new JLabel("Date of Birth:");
        t4.setFont(new Font("Raleway", Font.BOLD, 20));
        t4.setBounds(100, 230, 200, 30);
        add(t4);

         d4 = new JDateChooser();
        d4.setBounds(300, 230, 200, 30);
        d4.setForeground(new Color(105, 105, 105));
        add(d4);

        // Gender label and radio buttons
        JLabel t5 = new JLabel("Gender:");
        t5.setFont(new Font("Raleway", Font.BOLD, 20));
        t5.setBounds(100, 280, 200, 30);
        add(t5);

         male = new JRadioButton("Male");
        male.setBounds(300, 280, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

         female = new JRadioButton("Female");
        female.setBounds(450, 280, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        // Grouping gender buttons so only one can be selected
        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        // Email label and text field
        JLabel t6 = new JLabel("Email Address:");
        t6.setFont(new Font("Raleway", Font.BOLD, 20));
        t6.setBounds(100, 330, 200, 30);
        add(t6);

         n6 = new JTextField();
        n6.setBounds(300, 330, 400, 30);
        add(n6);

        // Marital Status label and radio buttons
        JLabel t7 = new JLabel("Marital Status:");
        t7.setFont(new Font("Raleway", Font.BOLD, 20));
        t7.setBounds(100, 380, 200, 30);
        add(t7);

         married = new JRadioButton("Married");
        married.setBounds(300, 380, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

         unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 380, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        // Grouping marital status buttons
        ButtonGroup status = new ButtonGroup();
        status.add(married);
        status.add(unmarried);

        // Address label and text field
        JLabel t8 = new JLabel("Address:");
        t8.setFont(new Font("Raleway", Font.BOLD, 20));
        t8.setBounds(100, 430, 200, 30);
        add(t8);

         n8 = new JTextField();
        n8.setBounds(300, 430, 400, 30);
        add(n8);

        // City label and text field
        JLabel t9 = new JLabel("City:");
        t9.setFont(new Font("Raleway", Font.BOLD, 20));
        t9.setBounds(100, 480, 200, 30);
        add(t9);

         n9 = new JTextField();
        n9.setBounds(300, 480, 400, 30);
        add(n9);

        // State label and text field
        JLabel t10 = new JLabel("State:");
        t10.setFont(new Font("Raleway", Font.BOLD, 20));
        t10.setBounds(100, 530, 200, 30);
        add(t10);

         n10 = new JTextField();
        n10.setBounds(300, 530, 400, 30);
        add(n10);

        // Pin code label and text field
        JLabel t11 = new JLabel("Pin code:");
        t11.setFont(new Font("Raleway", Font.BOLD, 20));
        t11.setBounds(100, 580, 200, 30);
        add(t11);

        n11 = new JTextField();
        n11.setBounds(300, 580, 400, 30);
        add(n11);

        // Next button
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 20));
        next.setBounds(300, 650, 100, 30);
        next.addActionListener(this);
        add(next);

        // Set background color of frame
        getContentPane().setBackground(Color.WHITE);

        // Using null layout for manual positioning
        setLayout(null);

        // Set window size
        setSize(850, 800);

        // Set window position on screen
        setLocation(350, 10);

        // Make frame visible
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String formno=""+random;
        String name=n1.getText();
        String fname=n2.getText();
        String dob=((JTextField) d4.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        String email=n6.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }
        String address=n8.getText();
        String city=n9.getText();
        String state=n10.getText();
        String pincode=n11.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }else{
                Conn c=new Conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date of birth is required");
            }else{
                Conn c=new Conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father Name is required");
            }else{
                Conn c=new Conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"Gender is required");
            }else{
                Conn c=new Conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is required");
            }else{
                Conn c=new Conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            if(marital.equals("")){
                JOptionPane.showMessageDialog(null,"Marital Status is required");
            }else{
                Conn c=new Conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is required");
            }else{
                Conn c=new Conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State is required");
            }else{
                Conn c=new Conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City is required");
            }else{
                Conn c=new Conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            if(pincode.equals("")){
                JOptionPane.showMessageDialog(null,"Pin code is required");
            }else{
                Conn c=new Conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    // Main method (entry point)
    public static void main(String[] args){
        new SignUp();
    }
}