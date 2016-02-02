import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejer4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection=null;
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "openpg", "openpgpwd");
		String sql, sql2;
		PreparedStatement preparedStatement;
		ResultSet rs, rs2;
		
		sql="select nombre, nif, (direccion).calle, (direccion).numero, (direccion).poblacion.poblacion, (direccion).poblacion.provincia.provincia, (direccion).poblacion.provincia.comunidadautonoma, (direccion).poblacion.pais, idcliente from cliente where idcliente=1";
		preparedStatement=connection.prepareStatement(sql);
		rs=preparedStatement.executeQuery();
		while(rs.next()){  
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.print(rs.getString(5));
			System.out.print(" ("+rs.getString(6)+")");
			System.out.print(", "+rs.getString(7));
			System.out.println(", "+rs.getString(8));
			/*Array tlfs=rs.getArray(9); 
			Object[] telefonos=(Object[])tlfs.getArray(); 
			for(int i=0; i<telefonos.length; i++){ 
				   System.out.println(" "+telefonos[i]);
			}*/
			sql2="select (unnest(telefonos)).tipo, ((unnest(telefonos)).numerotelefono).prefijo, ((unnest(telefonos)).numerotelefono).numero from cliente where idcliente="+rs.getInt(9);
			preparedStatement=connection.prepareStatement(sql2);
			rs2=preparedStatement.executeQuery();
			while(rs2.next()){  
				System.out.print(" "+rs2.getString(1));
				System.out.print(", "+rs2.getString(2));
				System.out.println(" "+rs2.getString(3));
			}
		}
		connection.close();
	}
}