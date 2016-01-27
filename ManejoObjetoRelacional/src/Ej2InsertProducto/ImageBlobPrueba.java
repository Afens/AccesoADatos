package Ej2InsertProducto;

import BddConnection.BddConnection;
import java.io.*;
import java.sql.*;


public class ImageBlobPrueba {
    //Crea un archivo imagen desde el archivo BLOB
    public static void main(String[] args) {
        Connection connection;
        File image;
        FileOutputStream out = null;
        InputStream is = null;
        try {
            connection = BddConnection.getConnection("Ventas", "Admin", "Admin");
            Statement statement = connection.createStatement();
            ResultSet rs;

            rs = statement.executeQuery("SELECT imgprod FROM Producto WHERE idproducto = '1'");

            while(rs.next()){
                image = new File("src\\nuevaImagen.jpg");
                out = new FileOutputStream(image);

                byte[] buffer = new byte[1];
                is = rs.getBinaryStream(1);

                while (is.read(buffer) > 0) {
                    out.write(buffer);
                }
            }
            if(out!=null){
                out.close();
                is.close();
            }
            connection.close();

        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }
}
