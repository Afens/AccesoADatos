package Ej5çSelectCliente;


import BddConnection.BddConnection;
import BddObjects.TelefonoSQLData;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final int CLIENTE = 1;
        Connection connection;
        PreparedStatement statement;
        String sql = "SELECT * FROM Cliente WHERE idCliente = ?";
        ResultSet rs,rs2;

        try {
            connection= BddConnection.getConnection("Ventas", "Admin", "Admin");
            statement = connection.prepareStatement(sql);
            statement.setInt(1,CLIENTE);
            rs = statement.executeQuery();



            while(rs.next()){
                System.out.println("  CLIENTE");
                System.out.println("ID: " + rs.getString(1));
                System.out.println("Nombre: " + rs.getString(2));
                System.out.println("NIF: " + rs.getString(3));
                //Teléfonos
                System.out.println("Teléfonos");
                rs2 = rs.getArray(4).getResultSet();
                while (rs2.next())
                    System.out.println("\t"+rs2.getString(2));

                //Direccion
                System.out.println("Dirección: ");
                System.out.println(rs.getString(5));




            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
