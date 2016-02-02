import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BddConnection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost/Ventas", "Afens", "Afens");

    }
}
