import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio09 {
	
	/*
	 * 9. Realiza un programa que dado un teléfono modifique el prefijo del país a 
	 * todos los clientes que disponen de dicho teléfono.
	 */
	
	public static void main(String[] args) {
		String select = "";
		PreparedStatement sentencia;
		ResultSet resultado;
		int cliente = 0, cont = 0, tlf = 956175747;
			
		try {
			//Cargar driver
			Class.forName("org.postgresql.Driver");
			
			//Establecer conexion
			Connection conexion;
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost/tienda", "openpg", "openpgpwd");
			
			//Clientes que tienen el mismo telefono
			System.out.printf("---------- Cambio de Prefijo ----------\n");
			select = "SELECT id_cliente, (unnest(telefonos)).numero.numero FROM cliente";
			
			//Ejecutamos la sentencia
			sentencia = conexion.prepareStatement(select);
			resultado = sentencia.executeQuery();
			
			//Guardamos los telefonos en una lista
			while (resultado.next()){
				//Comprobacion del cliente actual para reinicializar los contadores
				if (resultado.getInt(1) != cliente) {
					//Guardar cliente y posicion del tlf
					cliente = resultado.getInt(1);
					cont = 1;
				}
				
				//Si el telefono es igual al que queremos actualizar
				if (tlf == resultado.getInt(2)) {
					//Sentencia de actualizacion
					select = "UPDATE cliente SET telefonos["+ cont +"].numero.prefijo = 30 WHERE id_cliente=" + cliente;
					
					//Ejecutamos la sentencia
					sentencia = conexion.prepareStatement(select);
					sentencia.executeUpdate();
				
					System.out.printf("\nEl prefijo del telefono del cliente %d ha sido cambiado correctamente", cliente);
					
					//Aumentamos el contador
					cont++;
				}
				else cont++;
			}
			
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e){
		}
	}
}
