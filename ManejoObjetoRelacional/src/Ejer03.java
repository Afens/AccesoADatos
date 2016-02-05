import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Afens on 30/01/2016.
 */
public class Ejer03 {
    public static void main(java.lang.String[] args) {
        Connection connection;
        Statement statement;
        PreparedStatement preparedStatement;

        ArrayList<Object> listaTelefonos = new ArrayList<>();

        try {
            connection = BddConnection.getConnection();
            statement = connection.createStatement();
            //CLIENTES
            statement.execute("INSERT INTO cliente values ('1', 'Ale', '12345678p', CAST (ARRAY [('FIJO_TRABAJO',('+34', '956789547')), ('MOVIL_PERSONAL',('+34', '147852369'))] as t_telefono ARRAY), ('Calle clavel', '105', ('La Línea', ('Cádiz', 'Andalucía'), 'España'), '11300'))");
            statement.execute("INSERT INTO cliente values ('2', 'Pepe', '1221378p', CAST (ARRAY [('FIJO_PERSONAL',('+34', '956744547'))] as t_telefono ARRAY), ('Calle clavel', '105', ('La Línea', ('Cádiz', 'Andalucía'), 'España'), '11300'))");

            String sql = "INSERT INTO cliente VALUES (?,?,?,CAST (ARRAY[('MOVIL_PERSONAL',(34,'664080752')),('MOVIL_PERSONAL',(34,'666666666'))] AS t_telefono ARRAY),CAST (('Aleluya',20,('Montilla',('Cadiz','Andalucía'),'España'),14550) AS t_direccion))";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "Manuel Espinosa");
            preparedStatement.setString(3, "1235468");
            preparedStatement.executeUpdate();

            //VENTAS
            statement.execute("INSERT INTO VENTA VALUES ('1',now(),true,'1')");
            statement.execute("INSERT INTO VENTA VALUES ('2',now(),true,'1')");
            statement.execute("INSERT INTO VENTA VALUES ('3',now(),true,'3')");
            statement.execute("INSERT INTO VENTA VALUES ('4',now(),false,'3')");
            //PRODUCTOS
            statement.execute("INSERT INTO Lineaventa VALUES ('1','1',3,'1')");
            statement.execute("INSERT INTO Lineaventa VALUES ('1','2',4,'1')");
            statement.execute("INSERT INTO Lineaventa VALUES ('1','3',2,'1')");
            statement.execute("INSERT INTO Lineaventa VALUES ('2','1',1,'1')");
            statement.execute("INSERT INTO Lineaventa VALUES ('2','2',5,'1')");
            statement.execute("INSERT INTO Lineaventa VALUES ('2','3',1,'1')");




            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
