import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ejercicio07 {
	
	/*
	 * 7. Realiza un programa que actualice un teléfono de un cliente. Hay que 
	 * preguntarle al usuario el teléfono antiguo y el nuevo y sustituir uno por otro.
	 */
	
	public static void main(String[] args) {

		String select = "", tlfNuevo, tlfAntiguo;
		PreparedStatement sentencia;
		ResultSet resultado;
		ArrayList<String> telefonos = new ArrayList<String>();
			
		tlfAntiguo = ES.introString("Introduce el numero que deseas actualizar: ");
		tlfNuevo = ES.introString("Introduce el numero nuevo: ");
		
		try {
			//Cargar driver
			Class.forName("org.postgresql.Driver");
			
			//Establecer conexion
			Connection conexion;
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost/tienda", "openpg", "openpgpwd");
			
			//Select que desglosa los diferentes telefonos del cliente
			select = "SELECT (unnest(telefonos)).numero.numero FROM cliente WHERE id_cliente = 2";
			
			//Ejecutamos la sentencia
			sentencia = conexion.prepareStatement(select);
			resultado = sentencia.executeQuery();
			
			//Guardamos los telefonos en una lista
			while (resultado.next()){
				telefonos.add(resultado.getString(1));
			}
			
			//Comprobamos que el tlfono introducido por el usuario existe
			if (telefonos.contains(tlfAntiguo)) {
				//Sentencia de actualizacion
				select = "UPDATE cliente SET telefonos["+ (telefonos.indexOf(tlfAntiguo) + 1) +"].numero.numero = " + tlfNuevo + " WHERE id_cliente=2";
				
				//Ejecutamos la sentencia
				sentencia = conexion.prepareStatement(select);
				sentencia.executeUpdate();
			
				System.out.printf("\nEl cambio del numero %s por el numero %s se ha realizado satisfactoriamente", tlfAntiguo, tlfNuevo);
			}
			else {
				System.out.printf("El telefono introducido no es correcto");
			}
			
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e){
		}
	}
}
