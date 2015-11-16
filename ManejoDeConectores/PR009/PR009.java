import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Afens on 14/11/2015.
 */
public class PR009 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            Statement sentencia = connection.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT c.codCurso, c.CodOe, o.nombre, p.Nombre FROM curso c, ofertaeducativa o, profesor p where tutor=codProf and c.codOE=o.codOE;");

            while (rs.next()){
                System.out.printf("%s %s\t %-60s\t %s", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                System.out.println();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
