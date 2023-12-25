package class_files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn{
    Connection c;
    Statement s;

    public Conn (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///librarymanagementsystem", "root", "12345678");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}