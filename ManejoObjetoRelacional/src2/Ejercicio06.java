import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio06 {
	
	/*
	 * 6. Realiza un programa que actualice todos los teléfonos de un cliente.
	 */
	
	public static void main(String[] args) {

		String select = "";
		PreparedStatement sentencia;
		ResultSet resultado;
		int cont = 0;
		
		try {
			//Cargar driver
			Class.forName("org.postgresql.Driver");
			
			//Establecer conexion
			Connection conexion;
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost/tienda", "openpg", "openpgpwd");
			
			//Datos del cliente
			System.out.printf("--- Telefonos del Cliente ---\n");
			select = "SELECT (unnest(telefonos)).numero.numero FROM cliente WHERE id_cliente = 2";
			
			//Ejecutamos la sentencia
			sentencia = conexion.prepareStatement(select);
			resultado = sentencia.executeQuery();
			
			//Contamos cuantos telefonos tiene almacenados
			while (resultado.next()){
				cont++;
				System.out.println(resultado.getString(1));
			}
			
			//Con un bucle los cambiamos todos
			for (int i = 1; i <= cont; i++) {
				//Sentencia de actualizacion
				select = "UPDATE cliente SET telefonos["+ i +"].numero.numero = 636052479 WHERE id_cliente=2";
				
				//Ejecutamos la sentencia
				sentencia = conexion.prepareStatement(select);
				sentencia.executeUpdate();
			}
			
			System.out.printf("\nNumero de telefonos del cliente actualizados: %d", cont);
			
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e){
		}
		
	}
}
