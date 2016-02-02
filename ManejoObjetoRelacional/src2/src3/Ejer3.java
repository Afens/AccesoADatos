import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejer3{
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection=null;
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "openpg", "openpgpwd");
		String insertTableSQL;
		PreparedStatement preparedStatement;
		
		insertTableSQL = "INSERT INTO cliente VALUES (?,?,?,CAST (('Aleluya',20,('Montilla',('Córdoba','Andalucía'),'España'),14550) AS direccion),CAST (ARRAY[('movil_personal',(34,'689156220')),('movil_casa',(34,'679118823'))] AS telefono ARRAY))";
		preparedStatement=connection.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(2, "Joaquín Raya Urbano");
		preparedStatement.setString(3, "15452723N");
		preparedStatement.executeUpdate();
		
		insertTableSQL = "INSERT INTO cliente VALUES (?,?,?,CAST (('Agustín Morcihe',2,('Algeciras',('Cádiz','Andalucía'),'España'),11206) AS direccion),CAST (ARRAY[('movil_personal',(34,'717160015'))] AS telefono ARRAY))";
		preparedStatement=connection.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, 2);
		preparedStatement.setString(2, "Nerea Díaz Camacho");
		preparedStatement.setString(3, "36955448V");
		preparedStatement.executeUpdate();
		
		insertTableSQL = "INSERT INTO venta VALUES (?,?,?,?)";
		preparedStatement=connection.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, 2);
		preparedStatement.setDate(2, new Date(1));
		preparedStatement.setBoolean(3, true);
		preparedStatement.setInt(4, 1);
		preparedStatement.executeUpdate();
		
		insertTableSQL = "INSERT INTO lineaventa VALUES (?,?,?,?)";
		preparedStatement=connection.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, 2);
		preparedStatement.setInt(2, 2);
		preparedStatement.setInt(3, 1);
		preparedStatement.setInt(4, 2);
		preparedStatement.executeUpdate();
		
		connection.close();
	}
}