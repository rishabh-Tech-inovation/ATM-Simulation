package bank.managment.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankManagementSystem", "root", "Rishabh#2006");
            s=c.createStatement();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
