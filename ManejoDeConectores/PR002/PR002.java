import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Afens on 10/11/2015.
 */
public class PR002 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            String sql = "INSERT INTO OfertaEducativa VALUES (?, ?, ?, ?)";
            PreparedStatement sentencia=connection.prepareStatement(sql);

            System.out.println("Introduce el CodOE:");
            sentencia.setString(1, Teclado.cadena());
            System.out.println("Introduce el Nombre:");
            sentencia.setString(2, Teclado.cadena());
            System.out.println("Introduce la Descripcion:");
            sentencia.setString(3, Teclado.cadena());
            System.out.println("Introduce el Tipo:");
            sentencia.setString(4,Teclado.cadena());

            int filas=sentencia.executeUpdate();
            System.out.printf("%d Filas añadidas", filas);

            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
