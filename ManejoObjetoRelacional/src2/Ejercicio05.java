import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio05 {
	
	/*
	 * 5. Realiza un programa que dado un cliente muestre todos sus datos y todos los datos 
	 * de sus ventas, líneas de ventas y productos.
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
			
			//Datos del cliente
			System.out.printf("--- Datos del Cliente ---\n");
			select = "SELECT * FROM cliente WHERE id_cliente = 1";
			sentencia = conexion.prepareStatement(select);
			resultado = sentencia.executeQuery();
			while (resultado.next()){
				System.out.printf("- ID: %s\n", resultado.getString(1));
				System.out.printf("- Nombre: %s\n", resultado.getString(2));
				System.out.printf("- NIF: %s\n", resultado.getString(3));
				System.out.printf("- Direccion: %s\n", resultado.getString(4));
				System.out.printf("- Telefonos: %s\n\n", resultado.getString(5));
			}
			
			//Datos de las ventas
			System.out.printf("--- Datos de las Ventas del Cliente ---\n");
			select = "SELECT v.id_venta, fecha_venta, facturada, numero_linea, cantidad, "
					+ "l.id_producto, descripcion, pvp, stock, imagen, web FROM cliente c, "
					+ "venta v, lineas_venta l, producto p "
					+ "WHERE c.id_cliente=v.id_cliente AND v.id_venta=l.id_venta AND "
					+ "l.id_producto=p.id_producto AND c.id_cliente=1";
			sentencia = conexion.prepareStatement(select);
			resultado = sentencia.executeQuery();
			while (resultado.next()){
				System.out.printf("- ID de la Venta: %s\n", resultado.getString(1));
				System.out.printf("- Fecha: %s\n", resultado.getString(2));
				System.out.printf("- Facturada: %s\n", resultado.getString(3));
				System.out.printf("- Numero de Linea: %s\n", resultado.getString(4));
				System.out.printf("- Cantidad: %s\n", resultado.getString(5));
				System.out.printf("- ID del Producto: %s\n", resultado.getString(6));
				System.out.printf("- Descripcion: %s\n", resultado.getString(7));
				System.out.printf("- PVP: %s\n", resultado.getString(8));
				System.out.printf("- Stock: %s\n", resultado.getString(9));
				System.out.printf("- Imagen: %s\n", resultado.getString(10));
				System.out.printf("- Web: %s\n\n", resultado.getString(11));
			}
			
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e){
		}
	}
}
