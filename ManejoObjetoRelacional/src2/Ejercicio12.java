import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio12 {
	
	/*
	 * 12. Realiza un programa que actualice la provincia.
	 */
	
	public static void main(String[] args) {
		String select = "";
		PreparedStatement sentencia;
			
		try {
			//Cargar driver
			Class.forName("org.postgresql.Driver");
			
			//Establecer conexion
			Connection conexion;
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost/tienda", "openpg", "openpgpwd");
			
			//Clientes que tienen el mismo telefono
			System.out.printf("---------- Actualizacion de la Provincia Cadiz a Malaga ----------\n");
			select = "UPDATE cliente SET direccion.poblacion.provincia.provincia = 'Malaga' WHERE id_cliente=1";
			
			//Ejecutamos la sentencia
			sentencia = conexion.prepareStatement(select);
			System.out.printf("Filas actualizadas: %d\n", sentencia.executeUpdate());
			
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e){
		}
	}
}
