import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Afens on 14/11/2015.
 */
//Falta obtener codigo tramo
public class PR014 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            ResultSet rs;
            String codProf, codTramo="L1";

            System.out.println("Introduce el codProf");
            codProf = Teclado.cadena();


            rs = PR013.situacionProf(codTramo, codProf, connection);
            while (rs.next()) {
                System.out.printf("%s %s %s", rs.getString(1), rs.getString(2), rs.getString(3));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
