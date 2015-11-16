import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Afens on 14/11/2015.
 */
public class PR011 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            String sql = "SELECT CodAsignatura FROM reparto where CodProf=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs;

            System.out.println("Introduce codProf");
            statement.setString(1, Teclado.cadena());
            rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
