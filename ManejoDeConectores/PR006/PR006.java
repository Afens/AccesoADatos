import java.sql.*;

/**
 * Created by Afens on 14/11/2015.
 */
public class PR006 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM profesor order by ?;");
            ResultSet rs;
            ResultSetMetaData rsmd;
            String sql1 = "FechaDeNacimiento";
            String sql2 = "Alta desc";

            if (Teclado.cierto("Ordenar por:", "Fecha de Nacimiento", "Fecha de Alta"))
                preparedStatement.setString(1, sql1);
            else
                preparedStatement.setString(1, sql2);

            rs = preparedStatement.executeQuery();

            rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.printf("%-22s", rsmd.getColumnName(i));
            }
            System.out.println();

            while (rs.next()) {
                System.out.printf("%-10s %-30s %-25s %-20s",rs.getString(1),rs.getString(2),rs.getTimestamp(3),rs.getDate(4));
                System.out.println();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
