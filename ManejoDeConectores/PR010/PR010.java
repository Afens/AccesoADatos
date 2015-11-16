import java.sql.*;

/**
 * Created by Afens on 14/11/2015.
 */
public class PR010 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            PreparedStatement statement = connection.prepareStatement("SELECT CodTramo FROM horario where CodAsignatura=? and codCurso=? and codOe=?;");
            ResultSet rs;

            System.out.println("Introduce el codAsignatura");
            statement.setString(1, Teclado.cadena());
            System.out.println("Introduce el codCurso");
            statement.setString(2, Teclado.cadena());
            System.out.println("Introduce el codOe");
            statement.setString(3,Teclado.cadena());

            rs=statement.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
