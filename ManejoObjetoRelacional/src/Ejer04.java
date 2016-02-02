import java.sql.*;
/**
 * Created by Afens on 30/01/2016.
 */
public class Ejer04 {
    public static void main(String[] args) {


        try {
            Connection connection = BddConnection.getConnection();
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT (direccion).poblacion FROM cliente");
            System.out.println("4.1 La poblacion (Compuesto)");
            while (rs.next())
                System.out.println("\t"+rs.getString(1));

            System.out.println("4.2 La poblacion (Simple)");
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

            System.out.println("4.5 La comunidad autonoma");
            rs = statement.executeQuery("SELECT (direccion).poblacion.provincia.comunidadautonoma FROM Cliente");
            while(rs.next())
                System.out.println("\t" + rs.getString(1));

            System.out.println("4.6 La lista de telefonos");
            rs = statement.executeQuery("SELECT (telefonos) FROM Cliente");
            while(rs.next()){
                System.out.println("\t" + rs.getString(1));
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
