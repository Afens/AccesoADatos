package PruebaJimena;

import BddConnection.BddConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Usuario on 25/01/2016.
 */
public class Main {
    public static void main(String[] args) {
        Connection connection;
        Statement statement;

        try {
            connection = BddConnection.getConnection("Ventas","Admin","Admin");
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT (telefono).prefijoPais  FROM Cliente");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
