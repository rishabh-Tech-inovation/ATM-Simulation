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

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan,aadhar;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    JComboBox religion,category,educational,o,income;
    String formno;

    // Constructor of SignUp class
    SignupTwo(String formno){

        this.formno=formno;

        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE2");

        // Page title label
        JLabel t1 = new JLabel("Page2:Additional Details");
        t1.setFont(new Font("Raleway", Font.BOLD, 20));
        t1.setBounds(290, 80, 400, 30);
        add(t1);

        // Religion label and ComboBox field
        JLabel t2 = new JLabel("Religion:");
        t2.setFont(new Font("Raleway", Font.BOLD, 20));
        t2.setBounds(100, 140, 100, 30);
        add(t2);
        String rel[]= {"Hindu", "Muslim", "Sikh", "Parsi", "Christian", "Jain", "Buddhism","Other"};
        religion=new JComboBox(rel);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        // Category label and Jcombobox field
        JLabel t3 = new JLabel("Category:");
        t3.setFont(new Font("Raleway", Font.BOLD, 20));
        t3.setBounds(100, 190, 200, 30);
        add(t3);
        String cat[]={"General","EWS","SC/ST","OBC"};
         category=new JComboBox(cat);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        // income label and jcombo box
        JLabel t4 = new JLabel("Income:");
        t4.setFont(new Font("Raleway", Font.BOLD, 20));
        t4.setBounds(100, 230, 200, 30);
        add(t4);
        String in[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
         income=new JComboBox(in);
        income.setBounds(300, 230, 400, 30);
        income.setBackground(Color.white);
        add(income);


        JLabel t5 = new JLabel("Educational");
        t5.setFont(new Font("Raleway", Font.BOLD, 20));
        t5.setBounds(100, 280, 200, 30);
        add(t5);

        JLabel t6 = new JLabel("Qualification:");
        t6.setFont(new Font("Raleway", Font.BOLD, 20));
        t6.setBounds(100, 300, 200, 30);
        add(t6);

        String qulai[]={"Non-Graduate","Graduate","Post Graduate","Doctrate","Others"};
         educational=new JComboBox(qulai);
        educational.setBounds(300, 300, 400, 30);
        educational.setBackground(Color.white);
        add(educational);

        // Marital Status label and radio buttons
        JLabel t7 = new JLabel("Occupation:");
        t7.setFont(new Font("Raleway", Font.BOLD, 20));
        t7.setBounds(100, 380, 200, 30);
        add(t7);
        String occ[]={"Salaried","Self-Employee","Business","Student","Retired","Others"};
         o=new JComboBox(occ);
        o.setBounds(300, 380, 400, 30);
        o.setBackground(Color.white);
        add(o);





        JLabel t8 = new JLabel("PAN Number:");
        t8.setFont(new Font("Raleway", Font.BOLD, 20));
        t8.setBounds(100, 430, 200, 30);
        add(t8);

        pan = new JTextField();
        pan.setBounds(300, 430, 400, 30);
        add(pan);


        JLabel t9 = new JLabel("Aadhar Number:");
        t9.setFont(new Font("Raleway", Font.BOLD, 20));
        t9.setBounds(100, 480, 200, 30);
        add(t9);

        aadhar = new JTextField();
        aadhar.setBounds(300, 480, 400, 30);
        add(aadhar);


        JLabel t10 = new JLabel("Senior Citizen:");
        t10.setFont(new Font("Raleway", Font.BOLD, 20));
        t10.setBounds(100, 530, 200, 30);
        add(t10);

        syes=new JRadioButton("YES");
        syes.setBounds(300, 530, 100, 30);
        syes.setBackground(Color.white);
        add(syes);
        sno=new JRadioButton("NO");
        sno.setBounds(500, 530, 100, 30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup group = new ButtonGroup();
        group.add(syes);
        group.add(sno);

        // Pin code label and text field
        JLabel t11 = new JLabel("Existing Account:");
        t11.setFont(new Font("Raleway", Font.BOLD, 20));
        t11.setBounds(100, 580, 200, 30);
        add(t11);

        eyes=new JRadioButton("YES");
        eyes.setBounds(300, 580, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);
        eno=new JRadioButton("NO");
        eno.setBounds(500, 580, 100, 30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup status = new ButtonGroup();
        status.add(eyes);
        status.add(eno);


        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 20));
        next.setBounds(300, 650, 100, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);


        setLayout(null);


        setSize(850, 800);


        setLocation(350, 10);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
         String sreligion=(String) religion.getSelectedItem();
         String scategary=(String) category.getSelectedItem();
         String seducational=(String) educational.getSelectedItem();
         String sincome=(String) income.getSelectedItem();
         String so=(String) o.getSelectedItem();
         String scitizen=null;
         if(syes.isSelected()){
              scitizen="Yes";
         }else if(sno.isSelected()){
             scitizen="No";
         }
         String sexisting=null;
         if(eyes.isSelected()){
             sexisting="Yes";
         }else if(eno.isSelected()){
             sexisting="No";
         }
         String span=pan.getText();
         String saadhar=aadhar.getText();
         try{
             Conn c=new Conn();
             String q="insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategary+"','"+seducational+"','"+sincome+"','"+so+"','"+scitizen+"','"+sexisting+"','"+span+"','"+saadhar+"')";
             c.s.executeUpdate(q);
             setVisible(false);
             new SignUpThree(formno).setVisible(true);
         }catch(Exception ex){
             System.out.println(ex);
         }

    }


    // Main method (entry point)
    public static void main(String[] args){
        new SignupTwo("");
    }
}
