import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Afens on 30/01/2016.
 */
public class Ejer07 {
    public static void main(String[] args) {
        try {
            PreparedStatement sentencia;
            Connection conexion = BddConnection.getConnection();
            ResultSet result, aux;
            int idCliente;
            String telefonoAntiguo, telefonoNuevo, update, select;
            ArrayList<Telefono> listaTlf = new ArrayList<>();

            System.out.print("Indique el id del cliente: ");
            idCliente = Teclado.numInt();
            System.out.print("Indique el número de teléfono antiguo: ");
            telefonoAntiguo = Teclado.cadena();
            System.out.print("Indique el nuevo número de teléfono: ");
            telefonoNuevo = Teclado.cadena();

            select = "select telefonos from cliente where idCliente = ?;";


            sentencia = conexion.prepareStatement(select);
            sentencia.setInt(1, idCliente);
            result = sentencia.executeQuery();

            if (result.next()) {
                aux = result.getArray(1).getResultSet();
                while (aux.next())
                    listaTlf.add(Telefono.getObject(aux.getString(2)));
                aux.close();
            }

            for (Telefono t : listaTlf)
                if (t.numeroTlf.numero.equals(telefonoAntiguo))
                    t.numeroTlf.numero = telefonoNuevo;

            update = "update cliente set telefonos = " + Telefono.newArray(listaTlf) + " where idCliente = ?;";
            sentencia = conexion.prepareStatement(update);
            sentencia.setInt(1, idCliente);
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
