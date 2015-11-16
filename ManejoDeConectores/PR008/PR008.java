import java.sql.*;

/**
 * Created by Afens on 14/11/2015.
 */
public class PR008 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            Statement sentencia = connection.createStatement();

            ResultSet rs = sentencia.executeQuery("SELECT profesor.*, CodOe, CodCurso FROM profesor left join curso on tutor=codProf;");
            ResultSetMetaData rsmd= rs.getMetaData();

            int colums=rsmd.getColumnCount();

            System.out.printf("Numero de columnas: %d\n",colums);
            for (int i = 1; i <= colums; i++) {
                System.out.printf("Columna: %-20s Tipo: %-15s Tamaño: %d\t ¿Puede ser null?: %s\n", rsmd.getColumnName(i), rsmd.getColumnTypeName(i), rsmd.getColumnDisplaySize(i), rsmd.isNullable(i)==0?"No":"Si" );

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
