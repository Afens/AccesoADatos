import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Afens on 14/11/2015.
 */
public class PR004 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            Statement sentencia = connection.createStatement();
            String sql = "update asignatura set horasSemanales=horassemanales+1.10 , horastotales=horastotales*1.10 where nombre like 'M%' and codAsignatura in (select codAsignatura from reparto where codOe='FPB');";
            int i = sentencia.executeUpdate(sql);
            System.out.println(sql);
            System.out.printf("%d Filas afectadas",i);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
