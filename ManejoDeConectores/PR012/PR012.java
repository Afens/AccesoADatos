import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Afens on 14/11/2015.
 */
//no esta bien
public class PR012 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            String sql = "SELECT * FROM horario where codOE=? and CodCurso=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs;

            System.out.println("Introduce codOe");
            statement.setString(1, Teclado.cadena());
            System.out.println("Introduce codCurso");
            statement.setString(2, Teclado.cadena());
            rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(4));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
