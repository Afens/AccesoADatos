import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio10 {
	
	/*
	 * 10. Realiza un programa que dada una dirección muestre todos los clientes que tienen dicha dirección.
	 */
	
	public static void main(String[] args) {
		String select = "";
		PreparedStatement sentencia;
		ResultSet resultado;
			
		try {
			//Cargar driver
			Class.forName("org.postgresql.Driver");
			
			//Establecer conexion
			Connection conexion;
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost/tienda", "openpg", "openpgpwd");
			
			//Clientes que tienen el mismo telefono
			System.out.printf("---------- Clientes con Direccion en Isabel la Catolica ----------\n");
			select = "SELECT id_cliente, nombre FROM cliente WHERE (direccion).calle = 'Isabel la Catolica'";
			
			//Ejecutamos la sentencia
			sentencia = conexion.prepareStatement(select);
			resultado = sentencia.executeQuery();
			
			//Guardamos los telefonos en una lista
			while (resultado.next()){
				System.out.printf("- ID: %s\n", resultado.getString(1));
				System.out.printf("- Nombre: %s\n\n", resultado.getString(2));
			}
			
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e){
		}
	}
}
