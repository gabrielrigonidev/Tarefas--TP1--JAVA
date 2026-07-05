import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
   private static final String URL = "jdbc:mysql://localhost:3306/dbtreinamentos";
   private static final String USER = "root";
   private static final String PASSWORD = "";

   public static Connection connect(){
      try {
         return DriverManager.getConnection(URL, USER, PASSWORD);
      } catch(SQLException e) {
         System.err.println(e.getMessage());
         return null;
      }
   }
}