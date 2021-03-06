import java.sql.*;

/**
 * Created by Afens on 14/11/2015.
 */
public class PR007 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            Statement sentencia = connection.createStatement();

            ResultSet rs = sentencia.executeQuery("SELECT profesor.*, CodOe, CodCurso FROM profesor left join curso on tutor=codProf;");


            while (rs.next()) {
                System.out.printf("%-10s %-30s %-25s %s\t\t", rs.getString(1), rs.getString(2), rs.getTimestamp(3), rs.getDate(4));
                if (rs.getString(5)!=null)
                    System.out.printf("%s %s", rs.getString(6), rs.getString(5));
                else
                    System.out.printf("Este profesor no es tutor");
                System.out.println();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
