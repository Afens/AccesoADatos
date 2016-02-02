import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Afens on 30/01/2016.
 */
public class Ejer13 {
    public static void main(String[] args) {
        try {
            String select = "select direccion from cliente where idCliente = 1;", update;
            Connection conexion = BddConnection.getConnection();
            Direccion dirCliente;

            PreparedStatement sentencia = conexion.prepareStatement(select);
            ResultSet resul = sentencia.executeQuery();
            if (resul.next()){
                dirCliente = Direccion.getObject(resul.getString(1));
                dirCliente.poblacion.provincia.comunidadAutonoma="Comunidad update";
                update = "update cliente set direccion = CAST(" + dirCliente.getSQL() + " AS t_direccion) where idCliente = 1";
                sentencia = conexion.prepareStatement(update);
                sentencia.executeUpdate();
                System.out.println(dirCliente);
                System.out.println(dirCliente.getSQL());
            }
            resul.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
