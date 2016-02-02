import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejer2{
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		Class.forName("org.postgresql.Driver");
		Connection connection=null;
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "openpg", "openpgpwd");
		
		String insertTableSQL = "INSERT INTO producto VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1, 2);
		preparedStatement.setString(2, "Pantalla LCD 22\"");
		preparedStatement.setDouble(3, 205.95f);
		preparedStatement.setInt(4, 200);
		File file=new File("descarga.jpg");
		FileInputStream fis=new FileInputStream(file);
		preparedStatement.setBinaryStream(5, fis, (int)file.length());
		preparedStatement.setString(6, "<html><head></head><body>Pantalla LCD 22\"<b>Oferta</b></body></html>");
		preparedStatement.executeUpdate();
		  
		fis.close();
		connection.close();
	}
}