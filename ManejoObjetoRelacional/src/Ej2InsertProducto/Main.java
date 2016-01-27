package Ej2InsertProducto;


import BddConnection.BddConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection;
        String sql = "INSERT INTO Producto VALUES (?,?,?,?,?,?)";
        FileInputStream out ;
        File img ;

        try {
            connection = BddConnection.getConnection("Ventas", "Afens", "Admin");
            PreparedStatement statement = connection.prepareStatement(sql);
            img = new File("src\\imgPrueba.jpg");
            out=   new FileInputStream(img);
            //ID
            statement.setString(1,"1");
            //Descripción
            statement.setString(2, "Descripcion");
            //pvp
            statement.setDouble(3,433);
            //Stock
            statement.setInt(4, 111);
            //Web clob
            statement.setString(5,"www.clob.com");
            //Image blob
            statement.setBinaryStream(6,out,img.length());
            statement.execute();
            System.out.println("Inserci�n realizada");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
