import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Afens on 30/01/2016.
 */
public class Ejer08 {
    public static void main(String[] args) {
        try {
        String select = "select idCliente, nombre, nif, telefonos from cliente;";
        PreparedStatement sentencia;
        ResultSet result, resultTlf = null;
        Telefono tel;
        Connection conexion = BddConnection.getConnection();
        boolean mostrado = false;


            sentencia = conexion.prepareStatement(select);
            result = sentencia.executeQuery();
            while(result.next()) {
                mostrado = false;
                resultTlf = result.getArray(4).getResultSet();
                while (!mostrado && resultTlf.next()){
                    tel = Telefono.getObject(resultTlf.getString(2));
                    if (tel.numeroTlf.numero.equals("444444444")) {
                        System.out.printf("- idCliente: %d, Nombre: %s, DNI: %s\n", result.getInt(1), result.getString(2), result.getString(3));
                        mostrado = true;
                    }
                }
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
