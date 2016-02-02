import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio08 {
	
	/*
	 * 8. Realiza un programa que dado un teléfono muestre todos los clientes que tienen dicho teléfono.
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
			System.out.printf("---------- Clientes con el mismo Telefono ----------\n");
			select = "SELECT id_cliente, nombre FROM (SELECT id_cliente, nombre, unnest(telefonos) tlf FROM cliente) t WHERE ((t.tlf).numero).numero = 956175747";
			
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
