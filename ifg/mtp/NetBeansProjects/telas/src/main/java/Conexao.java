import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    public static void main(String[] args) {
        
        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "123");
            
            System.out.println("it works");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
