import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Afens on 14/11/2015.
 */
public class PR005 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            Statement sentencia = connection.createStatement();
            String sql = "delete from asignatura where codAsignatura in (select codAsignatura from reparto where codOe='FPB') and codAsignatura not in (select codAsignatura from reparto where codOe!='FPB');";
            System.out.println(sql);
            int i = sentencia.executeUpdate(sql);
            sql = "delete from ofertaEducativa where codOe='FPB';";
            System.out.println(sql);
            i += sentencia.executeUpdate(sql);
            System.out.printf("%d Filas afectadas",i);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
