import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Afens on 30/01/2016.
 */
public class Ejer11 {
    public static void main(String[] args) {
        try {
        String select = "select direccion from cliente where idCliente = 1;", update;
        Connection conexion = BddConnection.getConnection();
        PreparedStatement sentencia;
        Direccion dirCliente;
        ResultSet resul;

            sentencia = conexion.prepareStatement(select);
            resul = sentencia.executeQuery();
            if (resul.next()){
                dirCliente = Direccion.getObject(resul.getString(1));
                dirCliente.poblacion.poblacion="Los Barrios update";
                update = "update cliente set direccion = " + dirCliente.getSQL() + " where idCliente = 1";
                sentencia = conexion.prepareStatement(update);
                sentencia.executeUpdate();
            }
            resul.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
