import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejer101 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection=null;
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "openpg", "openpgpwd");
		String sql;
		PreparedStatement preparedStatement;
		ResultSet rs;
		int numero, codigopostal;
		String calle, poblacion, provincia, pais, comunidadautonoma;
		
		System.out.print("Calle: ");
		calle=Lectura.cadena();
		System.out.print("Número: ");
		numero=Lectura.numeroInt();
		System.out.print("Población: ");
		poblacion=Lectura.cadena();
		System.out.print("Provincia: ");
		provincia=Lectura.cadena();
		System.out.print("Comunidad Autónoma: ");
		comunidadautonoma=Lectura.cadena();
		System.out.print("País: ");
		pais=Lectura.cadena();
		System.out.print("Código Postal: ");
		codigopostal=Lectura.numeroInt();
		
		sql="select nombre from cliente where direccion=('"+calle+"',"+numero+",('"+poblacion+"',('"+provincia+"','"+comunidadautonoma+"')::provincia,'"+pais+"')::poblacion,"+codigopostal+")::direccion";
		preparedStatement=connection.prepareStatement(sql);
		rs=preparedStatement.executeQuery();
		while(rs.next()){ 
			System.out.println("\nAhí vive "+rs.getString(1));
		}
		
		connection.close();
	}
}