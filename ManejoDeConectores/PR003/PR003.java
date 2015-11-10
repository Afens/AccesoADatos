import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Afens on 10/11/2015.
 */
public class PR003 {
    public static void main(String[] args) {
        try {
            Connection connection = CargarConexion.cargar();
            String oferta, curso;
            int i=0;

            System.out.println("Introduce el CodOE:");
            oferta = Teclado.cadena();
            System.out.println("Introduce el curso:");
            curso = Teclado.cadena();

            if (curso.matches("\\d"))
                curso += "A";

            System.out.println("\nVamos a Asignar el Tutor");
            i+=setTutor(connection, oferta, curso);
            System.out.println("\nVamos a añadir las Asignaturas");
            i+=setAsignatura(connection);
            System.out.println("\nVamos a Asignar las Asignaturas");
            i+=setReparto(connection, oferta, curso);

            System.out.printf("\n%d Filas Afectadas",i);
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int setTutor(Connection connection, String oferta, String curso) throws SQLException {
        String sqlCurso = String.format("INSERT INTO Curso VALUES ('%s', '%s', ?)", oferta, curso);
        System.out.printf(sqlCurso);
        PreparedStatement sentencia = connection.prepareStatement(sqlCurso);
        int i = 0;

        System.out.println("Introduce el CodPRof del tutor:");
        sentencia.setString(1, Teclado.cadena());

        i += sentencia.executeUpdate();

        return i;
    }

    private static int setAsignatura(Connection connection) throws SQLException {
        String sqlAsignatura = "INSERT INTO Asignatura VALUES (?, ?, ?, ?)";
        PreparedStatement sentencia = connection.prepareStatement(sqlAsignatura);
        int i = 0;

        do {

            System.out.println("Introduce el CodAsignatura:");
            sentencia.setString(1, Teclado.cadena());
            System.out.println("Introduce el Nombre:");
            sentencia.setString(2, Teclado.cadena());
            System.out.println("Introduce las HorasSemanales:");
            sentencia.setInt(3, Teclado.numInt());
            System.out.println("Introduce las HorasTotales:");
            sentencia.setInt(4, Teclado.numInt());

            i += sentencia.executeUpdate();

        } while (Teclado.cierto("¿Añadir otra Asignatura?", "Si", "No"));

        return i;
    }

    private static int setReparto(Connection connection, String oferta, String curso) throws SQLException {
        String sqlReparto = String.format("INSERT INTO Reparto VALUES ('%s', '%s', ?, ?)", oferta, curso);
        PreparedStatement sentencia = connection.prepareStatement(sqlReparto);
        int i = 0;

        do {
            System.out.println("Introduce el CodAsignatura:");
            sentencia.setString(1, Teclado.cadena());

            System.out.println("Introduce el CodProf:");
            sentencia.setString(2, Teclado.cadena());

            i += sentencia.executeUpdate();
        } while (Teclado.cierto("¿Añadir otra Asignatura?", "Si", "No"));

        return i;
    }
}
