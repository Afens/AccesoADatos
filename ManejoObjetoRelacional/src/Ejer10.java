import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Afens on 30/01/2016.
 */
public class Ejer10 {
    public static void main(String[] args) {
        try {

        String dirBuscar = "Calle clavel";
        String select = "select idCliente, nombre, direccion from cliente;";
        Connection conexion = BddConnection.getConnection();
        PreparedStatement sentencia;
        ResultSet resul;
        Direccion dirCliente;


            sentencia = conexion.prepareStatement(select);
            resul = sentencia.executeQuery();
            while (resul.next()){
                dirCliente = Direccion.getObject(resul.getString(3));
                if (dirCliente.calle.equals(dirBuscar))
                    System.out.printf("idCliente: %d, Nombre: %s\n", resul.getInt(1), resul.getString(2));
            }
            sentencia.close();
            resul.close();
            conexion.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
