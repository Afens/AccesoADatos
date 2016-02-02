import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejer7{
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection=null;
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "openpg", "openpgpwd");
		String sql;
		PreparedStatement preparedStatement;
		ResultSet rs;
		int nt=1, num=0, prefijo;
		String tipo, numero;
		
		sql="select (unnest(telefonos)::telefono).tipo, (unnest(telefonos)::telefono).numerotelefono.prefijo, (unnest(telefonos)::telefono).numerotelefono.numero from cliente where idcliente=2";
		preparedStatement=connection.prepareStatement(sql);
		rs=preparedStatement.executeQuery();
		System.out.println("Números:");
		while(rs.next()){  
			System.out.println("\tNúm "+nt+"-->");
			System.out.println("\tTipo: "+rs.getString(1));
			System.out.println("\tPrefijo: "+rs.getInt(2));
			System.out.println("\tNúmero: "+rs.getString(3)+"\n");
			nt++;
		}
		nt--;
		System.out.print("¿Qué número deseas actulizar?: ");
		num=Lectura.numeroInt();
		if(num<=nt && num>0){
			System.out.println("Nuevo teléfono "+num);
			System.out.print("Tipo: ");
			tipo=Lectura.cadena();
			System.out.print("Prefijo: ");
			prefijo=Lectura.numeroInt();
			System.out.print("Número: ");
			numero=Lectura.cadena();
			
			sql="update cliente set telefonos["+nt+"]=('"+tipo+"',("+prefijo+",'"+numero+"')::numerotelefono)::telefono where idcliente=2";
			Statement statement=connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Teléfono actualizado");
		}
		else{
			System.out.println("Número incorrecto");
		}
		connection.close();
	}
}