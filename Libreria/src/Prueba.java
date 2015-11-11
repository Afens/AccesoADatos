import java.util.ArrayList;

/**
 * Created by Usuario on 11/11/2015.
 */
public class Prueba {
    public static void main(String[] args) {
        System.out.println("Introduce la ruta");
        String ruta=Teclado.cadena();
        System.out.println("Introduce la clave");
        String clave=Teclado.cadena();
        System.out.println("Introduce el valor");
        String valor=Teclado.cadena();
        ArrayList<Mapa> array=new ArrayList<Mapa>();
        array.add(new Mapa(clave,valor));
        String json=JsonSearcher.obtenerJson(ruta);
        System.out.printf(JsonSearcher.buscar(json, array));
    }
}
