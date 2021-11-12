package pos_oct;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author danis
 */
public class DbLoader {
    
     public static ResultSet executestatment(String query) {
         System.out.println(query);
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loading done");

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pointofsale", "root", "system");
            System.out.println("Connection Created");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement Created");

            rs = stmt.executeQuery(query);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    public static void main(String[] args) {
        executestatment("select *from student");
    }
    
    
}
