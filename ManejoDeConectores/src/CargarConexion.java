import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Afens on 10/11/2015.
 */
public class CargarConexion {
    public static Connection cargar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/horario", "root", "root");

    }
}
