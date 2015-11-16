import java.sql.*;

/**
 * Created by Afens on 14/11/2015.
 */
public class PR007 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            Statement sentencia = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement("SELECT codOE, codCurso FROM curso where tutor=? ");
            ResultSet rs = sentencia.executeQuery("SELECT * FROM profesor;");
            ResultSet psrs;

            while (rs.next()) {
                System.out.printf("%-10s %-30s %-25s %s", rs.getString(1), rs.getString(2), rs.getTimestamp(3), rs.getDate(4));
                ps.setString(1, rs.getString(1));
                psrs = ps.executeQuery();
                if (psrs.next())
                    System.out.printf("\t%s %s", psrs.getString(2), psrs.getString(1));
                else
                    System.out.printf("\tEste profesor no es tutor");
                System.out.println();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
