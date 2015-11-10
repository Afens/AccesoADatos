import java.sql.*;

/**
 * Created by Afens on 09/11/2015.
 */
public class PR001 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario", "root", "root");
            DatabaseMetaData dbmd = conexion.getMetaData();
            String tabla;
            ResultSet rs;

            System.out.println("Introduce el nombre de la tabla sobre la que quieres ver los datos:");
            tabla = Teclado.cadena();

            rs = dbmd.getTables(null, "horario", tabla, null);
if (!rs.next()){
    throw SQLException;
}




            rs = dbmd.getColumns(null, "horario", tabla, null);
            System.out.println("\nColumnas de la tabla:");
            System.out.println("=================================================");
            while (rs.next()){
                System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser null?: %s\n",rs.getString("COLUMN_NAME"),rs.getString("TYPE_NAME"),rs.getString("COLUMN_SIZE"),rs.getString("IS_NULLABLE"));
            }

            rs = dbmd.getPrimaryKeys(null, "horario", tabla);
            System.out.println("\nClaves Primarias:");
            System.out.println("=================================================");
            while (rs.next()){
                System.out.println(rs.getString("COLUMN_NAME"));
            }

            rs = dbmd.getImportedKeys(null, "horario", tabla);
            System.out.println("\nClaves Ajenas en esta tabla:");
            System.out.println("=================================================");
            while (rs.next()){
                System.out.println(rs.getString("FKCOLUMN_NAME"));
            }

            rs = dbmd.getExportedKeys(null, "horario", tabla);
            System.out.println("\nClaves Ajenas que utilizan la clave primaria:");
            System.out.println("=================================================");
            while (rs.next()){
                System.out.printf("En la Tabla: %s -> la Clave Ajena: %s\n", rs.getString("FKTABLE_NAME"),rs.getString("FKCOLUMN_NAME"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("No existe la tabla introducida");
        }
    }
}
