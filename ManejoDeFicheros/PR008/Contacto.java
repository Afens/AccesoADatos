import java.io.Serializable;

/**
 * Created by Afens on 13/10/2015.
 */
public class Contacto implements Serializable {
    String nombre;
    int phone;
    String direc;
    int codPostal;
    boolean debo=false;
    float cant;

    public Contacto(String nombre, int phone, String direc, int codPostal, float cant) {
        this.nombre = nombre;
        this.phone = phone;
        this.direc = direc;
        this.codPostal = codPostal;
        this.cant = cant;
        if (cant>0)
            debo=true;
    }

    public String toString() {
        return String.format("Nombre: %s\n\tTelefono: %d\n\tDireccion: %s\n\tCodigo Postal: %d\n\t%s\n",
                nombre, phone, direc, codPostal, debo ? String.format("Le debo %.2f $", cant) : "No le debo dinero");
    }


}
