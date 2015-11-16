import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Afens on 14/11/2015.
 */
public class PR013 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            ResultSet rs;
            String codTramo, codProf;

            System.out.println("Introduce el codTramo");
            codTramo = Teclado.cadena();
            System.out.println("Introduce el codProf");
            codProf = Teclado.cadena();

            rs = situacionProf(codTramo, codProf, connection);

            while (rs.next()) {
                System.out.printf("%s %s %s", rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet situacionProf(String codTramo, String codProf, Connection connection) throws SQLException, ClassNotFoundException {

        String sql = "select h.CodCurso, h.codOE, h.CodAsignatura from horario h, reparto r where CodTramo=? and CodProf=? and h.codAsignatura=r.codAsignatura;";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, codTramo);
        statement.setString(2, codProf);

        return statement.executeQuery();
    }
}
