package Ej6UpdateTelefonos;

import BddConnection.BddConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        Connection connection;
        PreparedStatement statement;
        String sql = "UPDATE telefonos VALUES [{?},{?}]";

        try {
            connection = BddConnection.getConnection("Ventas","Admin","Admin");



        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
