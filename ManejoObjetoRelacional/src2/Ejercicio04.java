import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio04 {
	
	/*
	 * 4. Realiza un programa que dado un cliente muestre:
	 * 	4.1. La población (campo compuesto)
	 * 	4.2. La población (campo simple)
	 * 	4.3. La provincia (campo compuesto)
	 * 	4.4. La provincia (campo simple)
	 * 	4.5. La comunidad autónoma
	 * 	4.6. La lista de teléfonos
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
			
			//Poblacion compuesto
			System.out.printf("--- Poblacion (Compuesto) ---\n");
			select = "SELECT (direccion).poblacion FROM cliente WHERE id_cliente = 1";
			sentencia = conexion.prepareStatement(select);
			resultado = sentencia.executeQuery();
			while (resultado.next()){
				System.out.printf("%s\n\n", resultado.getString(1));
			}
			
			//Poblacion simple
			System.out.printf("--- Poblacion (Simple) ---\n");
			select = "SELECT (direccion).poblacion.poblacion FROM cliente WHERE id_cliente = 1";
			sentencia = conexion.prepareStatement(select);
			resultado = sentencia.executeQuery();
			while (resultado.next()){
				System.out.printf("%s\n\n", resultado.getString(1));
			}
			
			//Provincia compuesto
			System.out.printf("--- Provincia (Compuesto) ---\n");
			select = "SELECT (direccion).poblacion.provincia FROM cliente WHERE id_cliente = 1";
			sentencia = conexion.prepareStatement(select);
			resultado = sentencia.executeQuery();
			while (resultado.next()){
				System.out.printf("%s\n\n", resultado.getString(1));
			}
			
			//Provincia simple
			System.out.printf("--- Provincia (Simple) - Comunidad autonoma ---\n");
			select = "SELECT (direccion).poblacion.provincia.comunidad FROM cliente WHERE id_cliente = 1";
			sentencia = conexion.prepareStatement(select);
			resultado = sentencia.executeQuery();
			while (resultado.next()){
				System.out.printf("%s\n\n", resultado.getString(1));
			}
			
			//Lista de telefonos
			System.out.printf("--- Lista de Telefonos ---\n");
			select = "SELECT unnest(telefonos) FROM cliente WHERE id_cliente = 1";
			sentencia = conexion.prepareStatement(select);
			resultado = sentencia.executeQuery();
			while (resultado.next()){
				System.out.printf("%s\n\n", resultado.getString(1));
			}
			
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e){
		}
	}

}
