import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejer6{
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection=null;
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "openpg", "openpgpwd");
		String sql;
		PreparedStatement preparedStatement;
		ResultSet rs;
		int nt=0, prefijo;
		String tipo, numero;
		
		sql="select array_length(telefonos, 1) from cliente where idcliente=1";
		preparedStatement=connection.prepareStatement(sql);
		rs=preparedStatement.executeQuery();
		while(rs.next()){  
			System.out.println("Este cliente tiene "+rs.getInt(1)+" teléfonos.");
			nt=rs.getInt(1);
		}
		for(int i=1; i<=nt; i++){
			System.out.println("\nNuevo teléfono "+i);
			System.out.print("\tTipo: ");
			tipo=Lectura.cadena();
			System.out.print("\tPrefijo: ");
			prefijo=Lectura.numeroInt();
			System.out.print("\tNúmero: ");
			numero=Lectura.cadena();
			
			sql="update cliente set telefonos["+i+"]=('"+tipo+"',("+prefijo+",'"+numero+"')::numerotelefono)::telefono where idcliente=1";
			Statement statement=connection.createStatement();
			statement.executeUpdate(sql);
		}
		System.out.println("Teléfonos actualizados");
		connection.close();
	}
}