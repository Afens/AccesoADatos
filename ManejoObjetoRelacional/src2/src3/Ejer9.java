import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejer9{
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection=null;
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "openpg", "openpgpwd");
		String sql, sql2, sql3;
		PreparedStatement preparedStatement;
		ResultSet rs, rs2;
		int res, index=1;
		
		System.out.print("Número: ");
		String numero=Lectura.cadena();
		System.out.print("Nuevo prefijo: ");
		String prefijo=Lectura.cadena();
		
		sql="select idcliente, telefonos from cliente order by idcliente";
		preparedStatement=connection.prepareStatement(sql);
		rs=preparedStatement.executeQuery();
		while(rs.next()){ 
			res=rs.getString(2).indexOf(numero);
			if(res!=-1){
				sql2="select ((unnest(telefonos)).numerotelefono).numero from cliente where idcliente="+rs.getInt(1);
				preparedStatement=connection.prepareStatement(sql2);
				rs2=preparedStatement.executeQuery();
				index=1;
				while(rs2.next()){ 
					if(rs2.getString(1).equals(numero)){
						sql3="update cliente set telefonos["+index+"].numerotelefono.prefijo="+prefijo+" where idcliente="+rs.getInt(1);
						Statement statement=connection.createStatement();
						statement.executeUpdate(sql3);
					}
					index++;
				}
			}
		}
		
		connection.close();
	}
}