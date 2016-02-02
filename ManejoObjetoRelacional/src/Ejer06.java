
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Afens on 30/01/2016.
 */
public class Ejer06 {
    public static void main(String[] args) {
        try {
            Connection conexion = BddConnection.getConnection();
            PreparedStatement sentencia;
            ResultSet result, aux;
            String select = "select telefonos from cliente where idCliente = 3;", update, cadenaArrayTelef = "";
            ArrayList<Telefono> listaTlf = new ArrayList<>();

            sentencia = conexion.prepareStatement(select);
            result = sentencia.executeQuery();
            if (result.next()) {
                aux = result.getArray(1).getResultSet();
                while (aux.next())
                    listaTlf.add(Telefono.getObject(aux.getString(2)));
                aux.close();
            }

            for (int i = 0; i < listaTlf.size(); i++)
                listaTlf.get(i).numeroTlf.numero = "555";

            cadenaArrayTelef = Telefono.newArray(listaTlf);

            update = "update cliente set telefonos = " + cadenaArrayTelef + " where idcliente = 3;";
            sentencia = conexion.prepareStatement(update);
            sentencia.executeUpdate();
            result.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
