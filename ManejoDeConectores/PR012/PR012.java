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
            String sql = "SELECT CodAsignatura FROM horario where codOE=? and CodCurso=? and CodAsignatura not Like '@%' and CodTramo = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs;

            System.out.println("Introduce codOe");
            statement.setString(1, Teclado.cadena());
            System.out.println("Introduce codCurso");
            statement.setString(2, Teclado.cadena());
            String dias="LMXJV";
            System.out.printf("\t%-9s%-9s%-12s%-10s%-10s\n","Lunes","Martes","Miercoles","Jueves","Viernes");
            for (int i = 1; i <= 6; i++) {
                System.out.printf("%dª\t",i);
                for (int j = 0; j < 5; j++) {
                    statement.setString(3, String.valueOf(dias.charAt(j))+i);
                    rs=statement.executeQuery();
                    rs.next();
                    System.out.printf("%-10s",rs.getString(1));
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
