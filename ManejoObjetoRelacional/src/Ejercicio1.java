import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Afens on 03/02/2016.
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        int id, indicador;
        double precio;
        Connection conexion;
        PreparedStatement sentencia;
        String update;

        System.out.println("Introduce el id del producto que quieres modificar:");
        id=Teclado.numInt();

        System.out.println("Indica el precio que quieres modificar:");
        System.out.println("\t 1 - Precio Temporada Alta");
        System.out.println("\t 2 - Precio Tempodara Media");
        System.out.println("\t 3 - Precio Temporada Baja");
        indicador=Teclado.numInt(1, 3, Teclado.Opcion.AMBOS_INCLUIDOS);

        System.out.println("Introduce el nuevo precio:");
        precio=Teclado.numDouble();

        try{
            conexion = BddConnection.getConnection();
            update = "update producto set pvp[?] = ? where idProducto = ?";
            sentencia = conexion.prepareStatement(update);
            sentencia.setInt(1, indicador);
            sentencia.setDouble(2, precio);
            sentencia.setString(3,id+"");
            sentencia.executeUpdate();

            sentencia.close();
            conexion.close();

            System.out.println("Precio Modificado");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
