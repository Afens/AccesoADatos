package BddConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BddConnection {

    public static Connection getConnection(String bdd,String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost/"+bdd, user, password);

    }
}
