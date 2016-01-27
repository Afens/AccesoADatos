package Ej7UpdateTelefono;

import BddConnection.BddConnection;
import BddObjects.Telefono;

import java.sql.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        //EN MANTENIMIENTO !!!!!!!!!!!!!!
        Connection connection;
        PreparedStatement statement;
        String sql = "UPDATE cliente.telefonos VALUES ? ";
        String sqlPrueba= "SELECT (telefonos)[2].tipo FROM Cliente";
        ResultSet rs;

        Telefono t;
        try {
            connection= BddConnection.getConnection("Ventas", "Afens", "");
            statement = connection.prepareStatement(sqlPrueba);


            rs = statement.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString(1));
                /*Array arraySqlTlf = rs.getArray(1);

                Object[] telefonos = (Object[]) arraySqlTlf.getArray();

                for (Object s : telefonos) {
                   // t= (Telefono) s;
                    System.out.println(s.toString());
                }*/
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
