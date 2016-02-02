import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Afens on 30/01/2016.
 */
public class Ejer09 {
    public static void main(String[] args) {
        try {

        String select = "select idCliente, telefonos from cliente;", update;
        PreparedStatement sentencia;
        ResultSet result, resultTlf = null;
        Telefono tel;
        ArrayList<Telefono> listaTlf = new ArrayList<>();
        Connection conexion = BddConnection.getConnection();
        int idCliente;

            sentencia = conexion.prepareStatement(select);
            result = sentencia.executeQuery();
            while(result.next()) {
                idCliente = result.getInt(1);
                resultTlf = result.getArray(2).getResultSet();
                listaTlf.clear();
                while (resultTlf.next()){
                    tel = Telefono.getObject(resultTlf.getString(2));
                    listaTlf.add(tel);
                    if (tel.numeroTlf.numero.equals("444444444"))
                        tel.numeroTlf.prefijoPais="+23";
                }
                update = "update cliente set telefonos = " + Telefono.newArray(listaTlf)+ " where idCliente = ?";
                sentencia = conexion.prepareStatement(update);
                sentencia.setInt(1,idCliente);
                sentencia.executeUpdate();
            }
            resultTlf.close();
            sentencia.close();
            result.close();
            conexion.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
