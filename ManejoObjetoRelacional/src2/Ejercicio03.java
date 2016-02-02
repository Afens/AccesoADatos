import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio03 {
	
	/*
	 * 3. Realiza un programa que inserte dos clientes. A continuación, insértale dos nuevas 
	 * ventas a cada uno con tres productos en cada venta.
	 */
	
	public static void main(String[] args) {
		
		String insert;

		//Cargar driver
		try {
			Class.forName("org.postgresql.Driver");

			//Establecer conexion
			Connection conexion;
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost/tienda", "openpg", "openpgpwd");

			//Ejecucion de sentencias
			Statement sentencia = conexion.createStatement();

			//Agregar cliente 1
			System.out.printf("--- Agregar Cliente 1 ---\n");
			insert = "INSERT INTO cliente VALUES (1, 'Ivan', '75960227J', "
					+ "('Isabel la Catolica', 12, 11300, ('La Linea', ('Cadiz', 'Andalucia'), 'España')), "
					+ "CAST (ARRAY[('movil', (34, 636052479)),('fijo', (34, 956175747)), ('trabajo', (34, 667238931))] "
					+ "AS t_telefono ARRAY))";
			
			//Ejecutamos y mostramos las filas afectadas
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			
			
			//Agregar cliente 2
			System.out.printf("--- Agregar Cliente 1 ---\n");
			insert = "INSERT INTO cliente VALUES (2, 'Pepe', '75949389P', "
					+ "('Los Olivos', 4, 11300, ('La Linea', ('Cadiz', 'Andalucia'), 'España')), "
					+ "CAST (ARRAY[('movil', (34, 635649857)),('fijo', (34, 956172548)), ('trabajo', (34, 648578459))] "
					+ "AS t_telefono ARRAY))";
			
			//Ejecutamos y mostramos las filas afectadas
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			
			
			//Agregar venta 1 al cliente 1
			System.out.printf("--- Venta 1 Cliente 1 ---\n");
			insert = "INSERT INTO venta VALUES (1, now(), true, 1)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			
			//Agregar venta 2 al cliente 1
			System.out.printf("--- Venta 2 Cliente 1 ---\n");
			insert = "INSERT INTO venta VALUES (2, now(), false, 1)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			
			//Agregar venta 1 al cliente 2
			System.out.printf("--- Venta 1 Cliente 1 ---\n");
			insert = "INSERT INTO venta VALUES (3, now(), true, 2)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			
			//Agregar venta 2 al cliente 2
			System.out.printf("--- Venta 2 Cliente 1 ---\n");
			insert = "INSERT INTO venta VALUES (4, now(), false, 2)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			
			//Agregar productos a venta 1 del cliente 1
			System.out.printf("--- Venta 1 Cliente 1 Producto 1 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (1, 1, 1, 1)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			System.out.printf("--- Venta 1 Cliente 1 Producto 2 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (1, 2, 5, 3)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			System.out.printf("--- Venta 1 Cliente 1 Producto 3 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (1, 3, 8, 4)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			
			//Agregar productos a venta 2 del cliente 1
			System.out.printf("--- Venta 2 Cliente 1 Producto 1 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (2, 1, 1, 1)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			System.out.printf("--- Venta 2 Cliente 1 Producto 2 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (2, 2, 2, 2)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			System.out.printf("--- Venta 2 Cliente 1 Producto 3 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (2, 3, 4, 3)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			
			//Agregar productos a venta 1 del cliente 2
			System.out.printf("--- Venta 1 Cliente 2 Producto 1 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (3, 1, 3, 2)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			System.out.printf("--- Venta 1 Cliente 2 Producto 2 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (3, 2, 5, 3)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			System.out.printf("--- Venta 1 Cliente 2 Producto 3 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (3, 3, 1, 4)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			
			//Agregar productos a venta 2 del cliente 2
			System.out.printf("--- Venta 2 Cliente 2 Producto 1 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (4, 1, 1, 1)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			System.out.printf("--- Venta 2 Cliente 2 Producto 2 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (4, 2, 2, 2)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			System.out.printf("--- Venta 2 Cliente 2 Producto 3 ---\n");
			insert = "INSERT INTO lineas_venta VALUES (4, 3, 1, 3)";
			System.out.printf("Filas Afectadas: %s\n\n", sentencia.executeUpdate(insert));
			
			
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
	}
}
