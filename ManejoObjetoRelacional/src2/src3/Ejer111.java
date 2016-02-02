import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejer111 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection=null;
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "openpg", "openpgpwd");
		String sql;
		PreparedStatement preparedStatement;
		ResultSet rs;
		String poblacion, provincia, pais, comunidadautonoma;
		
		System.out.print("Poblaci�n: ");
		poblacion=Lectura.cadena();
		System.out.print("Provincia: ");
		provincia=Lectura.cadena();
		System.out.print("Comunidad Aut�noma: ");
		comunidadautonoma=Lectura.cadena();
		System.out.print("Pa�s: ");
		pais=Lectura.cadena();
		
		sql="select (direccion).calle, (direccion).numero, (direccion).codigopostal from cliente where idcliente=1";
		preparedStatement=connection.prepareStatement(sql);
		rs=preparedStatement.executeQuery();
		while(rs.next()){ 
			sql="update cliente set direccion=('"+rs.getString(1)+"',"+rs.getInt(2)+",('"+poblacion+"',('"+provincia+"','"+comunidadautonoma+"')::provincia,'"+pais+"')::poblacion,"+rs.getInt(3)+")::direccion where idcliente=1";
			Statement statement=connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Poblaci�n actualizada");
		}
		
		connection.close();
	}
}