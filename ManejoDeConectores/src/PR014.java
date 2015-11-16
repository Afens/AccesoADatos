import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Usuario on 16/11/2015.
 */
public class PR014 {
    public static void main(String[] args) {
        try {
            Connection connection=CargarConexion.cargar();
            PreparedStatement ps=connection.prepareStatement("SELECT CodTramo FROM tramohorario where dia =? and ? between HoraInicio and HoraFin ;");
            SimpleDateFormat formateador = new SimpleDateFormat("EEEE");
            Date fecha=new Date();
            Time time=new Time(fecha.getTime());
            ps.setString(1, formateador.format(fecha));
            ps.setTime(2, time);

            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                System.out.println(rs.getString(1));
            }




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
