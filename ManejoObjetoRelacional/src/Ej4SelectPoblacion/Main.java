package Ej4SelectPoblacion;


import BddConnection.BddConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection;
        Statement statement;
        ResultSet rs;

        try {
            connection = BddConnection.getConnection("Ventas", "Afens", "Admin");
            statement = connection.createStatement();

            rs = statement.executeQuery("SELECT (direccion).poblacion FROM cliente");
            System.out.println("4.1 La población (Compuesto)");
            while (rs.next())
                System.out.println("\t"+rs.getString(1));

            System.out.println("4.2 La población (Simple)");
            rs = statement.executeQuery("SELECT (direccion).poblacion.poblacion FROM Cliente");
            while (rs.next())
                System.out.println("\t"+rs.getString(1));

            System.out.println("4.3 La provincia (Compuesto)");
            rs = statement.executeQuery("SELECT (direccion).poblacion.provincia FROM Cliente");
            while(rs.next())
                System.out.println("\t" + rs.getString(1));

            System.out.println("4.4 La provincia (Simple)");
            rs = statement.executeQuery("SELECT (direccion).poblacion.provincia.provincia FROM Cliente");
            while(rs.next())
                System.out.println("\t" + rs.getString(1));

            System.out.println("4.5 La comunidad autónoma");
            rs = statement.executeQuery("SELECT (direccion).poblacion.provincia.comunidadautonoma FROM Cliente");
            while(rs.next())
                System.out.println("\t" + rs.getString(1));

            System.out.println("4.6 La lista de teléfonos");
            rs = statement.executeQuery("SELECT (telefonos) FROM Cliente");
            while(rs.next()){
                System.out.println("\t" + rs.getString(1));
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
