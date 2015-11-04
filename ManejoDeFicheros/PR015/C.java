import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Afens on 13/10/2015.
 */
public class C implements Serializable {
    String nombre;
    String phone;
    String direc;
    int codPostal;
    boolean debo=false;
    float cant;
    Date fecha;

    public C(String nombre, String phone, String direc, int codPostal, float cant,Date fecha) {
        this.nombre = nombre;
        this.phone = phone;
        this.direc = direc;
        this.codPostal = codPostal;
        this.cant = cant;
        if (cant>0)
            debo=true;
        this.fecha=fecha;
    }

    public String toString() {
        SimpleDateFormat e=new SimpleDateFormat("dd/MM/yyyy");
        return String.format("\tNombre: %s\n\tTelefono: %s\n\tDireccion: %s\n\tCodigo Postal: %d\n\tFecha Nacimiento: %s\n" +
                        "\t%s\n",
                nombre, phone, direc, codPostal, e.format(fecha), debo ? String.format("Le debo %.2f $", cant) : "No le debo dinero");
    }


}
