import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Afens on 30/01/2016.
 */
public class Datos {

    public static void main(String[] args) {
        try {
            Connection connection = BddConnection.getConnection();
            String sql = "INSERT INTO Producto VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            File img = new File("imgPrueba.jpg");
            FileInputStream in = new FileInputStream(img);
            //ID
            statement.setString(1,"1");
            //Stock
            statement.setInt(2, 111);
            //Web clob
            statement.setString(3,"www.clob.com");
            //Image blob
            statement.setBinaryStream(4,in,img.length());
            statement.execute();
            System.out.println("Insercion realizada");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
