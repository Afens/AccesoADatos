import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Afens on 14/11/2015.
 */
//Falta obtener codigo tramo
public class PR014 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            String sql = "select h.CodCurso, h.codOE, h.CodAsignatura from horario h, reparto r where CodProf=? and h.codAsignatura=r.codAsignatura and CodTramo=(SELECT CodTramo FROM tramohorario where dia =? and ? between HoraInicio and HoraFin );";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs;
            SimpleDateFormat formateador = new SimpleDateFormat("EEEE");
            Date fecha = new Date();
            Time time = new Time(fecha.getTime());


            System.out.println("Introduce el codProf");
            ps.setString(1, Teclado.cadena());
            ps.setString(2, formateador.format(fecha));
            ps.setTime(3, time);

            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.printf("%s %s %s", rs.getString(1), rs.getString(2), rs.getString(3));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
