import java.util.ArrayList;

/**
 * Created by Usuario on 11/11/2015.
 */
public class Prueba {
    public static void main(String[] args) {
        System.out.println("Introduce la ruta");
        String ruta=Teclado.cadena();

        ArrayList<Mapa> array=JsonSearcher.obtenerClaveValor();
        String json=JsonSearcher.obtenerJson(ruta);
        System.out.printf(JsonSearcher.buscar(json, array).replace('"', ' '));
    }
}
