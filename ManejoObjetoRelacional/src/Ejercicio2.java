import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Afens on 03/02/2016.
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        int id, indicador;
        Connection conexion;
        PreparedStatement sentencia;
        String update="";
        boolean vip=true;
        String valor="";

        System.out.println("Introduce el id del producto que quieres modificar:");
        id=Teclado.numInt();

        System.out.println("Indica la propiedad que quieres modificar:");
        System.out.println("\t 1 - Nombre");
        System.out.println("\t 2 - Descripcion");
        System.out.println("\t 3 - Producto Vip");
        indicador=Teclado.numInt(1, 3, Teclado.Opcion.AMBOS_INCLUIDOS);


        switch (indicador){
            case 1:
                System.out.println("Introduce el nuevo Nombre:");
                valor = Teclado.cadena();
                update = "update producto set descripcion.nombre = ? where idProducto = ?";
                break;
            case 2:
                System.out.println("Introduce la nueva Descripcion:");
                valor = Teclado.cadena();
                update = "update producto set descripcion.descripcion = ? where idProducto = ?";
                break;
            case 3:
                vip=Teclado.cierto("Introduce si es Producto Vip:","True","False");
                update = "update producto set descripcion.productovip = ? where idProducto = ?";
                break;
        }

        try{
            conexion = BddConnection.getConnection();
            sentencia = conexion.prepareStatement(update);

            if (indicador==3)
                sentencia.setBoolean(1, vip);
            else
                sentencia.setString(1, valor);

            sentencia.setString(2, id+"");
            sentencia.executeUpdate();

            sentencia.close();
            conexion.close();

            System.out.println("Valor Modificado");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
