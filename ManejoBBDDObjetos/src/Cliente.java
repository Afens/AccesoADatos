import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by Usuario on 16/02/2016.
 */
@Entity
public class Cliente {
    @Id
    private String idCliente;
    private String nombre;
    private String nif;
    private Direccion direccion;
    private ArrayList<Telefono> listTelefonos;



}
