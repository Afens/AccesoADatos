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
            String sql = "SELECT codAsignatura from horario where codOe = ? and CodCurso = ? and codAsignatura not like '@%' " +
                    "order by substring(codTramo, 2), substring(codTramo, 1) like 'L%' desc, substring(codTramo, 1) like 'M%' desc, " +
                    "substring(codTramo, 1) like 'X%' desc, substring(codTramo, 1) like 'J%' desc;";
            String codCurso;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs;

            System.out.println("Introduce codOe");
            statement.setString(1, Teclado.cadena());
            System.out.println("Introduce codCurso");
            codCurso = Teclado.cadena();

            if (!codCurso.matches("\\dA"))
                codCurso+="A";

            statement.setString(2, codCurso);
            rs = statement.executeQuery();

            System.out.printf("\t%-9s%-9s%-12s%-10s%-10s\n", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes");
            for (int i = 1; i <= 6; i++) {
                System.out.printf("%dª\t", i);
                for (int j = 0; j < 5 && rs.next(); j++) {

                    System.out.printf("%-10s", rs.getString(1));
                }
                System.out.println();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
