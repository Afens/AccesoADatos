import java.sql.*;
/**
 * Created by Afens on 30/01/2016.
 */
public class Ejer05 {
    public static void main(String[] args) {
        try {
            Connection connection = BddConnection.getConnection();
            String sql, sql2;
            PreparedStatement preparedStatement;
            ResultSet rs, rs2;

            sql="select nombre, nif from cliente where idcliente=1";
            preparedStatement=connection.prepareStatement(sql);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString(1));
                System.out.println(", "+rs.getString(2));
            }

            sql="select * from venta where idcliente=1";
            preparedStatement=connection.prepareStatement(sql);
            rs=preparedStatement.executeQuery();
            while(rs.next()){
                System.out.print("\n  Venta "+rs.getInt(1));
                System.out.print(" "+rs.getDate(2));
                System.out.print(" "+rs.getBoolean(3));
                System.out.println(" "+rs.getInt(4));

                sql2="select idventa, numerolinea, cantidad, description from lineaventa, producto where idventa="+rs.getInt(1)+" and lineaventa.idproducto=producto.idproducto";
                preparedStatement=connection.prepareStatement(sql2);
                rs2=preparedStatement.executeQuery();
                while(rs2.next()){
                    System.out.print("    "+rs.getInt(1));
                    System.out.print(" "+rs2.getInt(2));
                    System.out.print(" "+rs2.getInt(3));
                    System.out.println(" "+rs2.getString(4));
                }
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }




    }
}
