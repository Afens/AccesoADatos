import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejer121 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection=null;
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "openpg", "openpgpwd");
		String sql;
		PreparedStatement preparedStatement;
		ResultSet rs;
		String provincia, comunidadautonoma;
		
		System.out.print("Provincia: ");
		provincia=Lectura.cadena();
		System.out.print("Comunidad Autónoma: ");
		comunidadautonoma=Lectura.cadena();
		
		sql="select (direccion).calle, (direccion).numero, (direccion).poblacion.poblacion, (direccion).poblacion.pais, (direccion).codigopostal from cliente where idcliente=1";
		preparedStatement=connection.prepareStatement(sql);
		rs=preparedStatement.executeQuery();
		while(rs.next()){ 
			sql="update cliente set direccion=('"+rs.getString(1)+"',"+rs.getInt(2)+",('"+rs.getString(3)+"',('"+provincia+"','"+comunidadautonoma+"')::provincia,'"+rs.getString(4)+"')::poblacion,"+rs.getInt(5)+")::direccion where idcliente=1";
			Statement statement=connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Provincia actualizada");
		}
		
		connection.close();
	}
}