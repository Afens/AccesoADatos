import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio02 {

	/*
	 * 2. Realiza un programa que inserte un nuevo producto.
	 */
	
	public static void main(String[] args) {
		
		//Cargar driver
		try {
			Class.forName("org.postgresql.Driver");
		
			//Establecer conexion
			Connection conexion;
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost/tienda", "openpg", "openpgpwd");

			
			//Agregar producto
			System.out.printf("--- Agregar Producto ---\n");
			String insert = "INSERT INTO producto VALUES (?, ?, ?, ?, ?, ?)";
			
			//Imagen del producto
			File file = new File("logo.png");
			FileInputStream fis = new FileInputStream(file);
									
			//Preparar sentencia
			PreparedStatement sentencia = conexion.prepareStatement(insert);
				sentencia.setInt(1, 2);
				sentencia.setString(2, "Descripcion del producto 1");
				sentencia.setInt(3, 25);
				sentencia.setInt(4, 5);
				sentencia.setBinaryStream(5, fis, (int)file.length());
				sentencia.setString(6, "aqui el clob");
				
			System.out.printf("Filas insertadas: %d\n\n", sentencia.executeUpdate());
			
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e){
		} catch (FileNotFoundException e) {
		}
	}
}
