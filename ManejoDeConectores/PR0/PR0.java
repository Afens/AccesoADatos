import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Afens on 14/11/2015.
 */
public class PR0 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
