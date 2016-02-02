import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejer8{
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection=null;
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "openpg", "openpgpwd");
		String sql, sql2;
		PreparedStatement preparedStatement;
		ResultSet rs, rs2;
		int res;
		
		System.out.print("Número: ");
		String numero=Lectura.cadena();
		
		sql="select idcliente, telefonos from cliente";
		preparedStatement=connection.prepareStatement(sql);
		rs=preparedStatement.executeQuery();
		while(rs.next()){ 
			res=rs.getString(2).indexOf(numero);
			if(res!=-1){
				sql2="select nombre from cliente where idcliente="+rs.getInt(1);
				preparedStatement=connection.prepareStatement(sql2);
				rs2=preparedStatement.executeQuery();
				while(rs2.next()){
					System.out.println(rs2.getString(1));
				}
			}
		}
		
		connection.close();
	}
}