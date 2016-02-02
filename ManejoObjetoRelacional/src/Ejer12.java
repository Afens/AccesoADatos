import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Afens on 30/01/2016.
 */
public class Ejer12 {
    public static void main(String[] args) {
        try {
        String select = "select direccion from cliente where idCliente = 3;", update;
        Connection conexion = BddConnection.getConnection();
        PreparedStatement sentencia;
        Direccion dirCliente;
        ResultSet resul;


            sentencia = conexion.prepareStatement(select);
            resul = sentencia.executeQuery();
            if (resul.next()){
                dirCliente = Direccion.getObject(resul.getString(1));
                dirCliente.poblacion.provincia.provincia="Granada update";
                update = "update cliente set direccion = " + dirCliente.getSQL() + " where idCliente = 3";
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
