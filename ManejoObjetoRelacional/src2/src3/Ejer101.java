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
		System.out.print("N�mero: ");
		numero=Lectura.numeroInt();
		System.out.print("Poblaci�n: ");
		poblacion=Lectura.cadena();
		System.out.print("Provincia: ");
		provincia=Lectura.cadena();
		System.out.print("Comunidad Aut�noma: ");
		comunidadautonoma=Lectura.cadena();
		System.out.print("Pa�s: ");
		pais=Lectura.cadena();
		System.out.print("C�digo Postal: ");
		codigopostal=Lectura.numeroInt();
		
		sql="select nombre from cliente where direccion=('"+calle+"',"+numero+",('"+poblacion+"',('"+provincia+"','"+comunidadautonoma+"')::provincia,'"+pais+"')::poblacion,"+codigopostal+")::direccion";
		preparedStatement=connection.prepareStatement(sql);
		rs=preparedStatement.executeQuery();
		while(rs.next()){ 
			System.out.println("\nAh� vive "+rs.getString(1));
		}
		
		connection.close();
	}
}