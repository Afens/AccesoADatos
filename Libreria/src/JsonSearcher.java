import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Afens on 02/11/2015.
 */

public class JsonSearcher {
    public static ArrayList<Mapa> obtenerClaveValor() {
        ArrayList<Mapa> array = new ArrayList<Mapa>();
        do {
            System.out.println("Introduce la clave");
            String clave=Teclado.cadena();
            System.out.println("Introduce el valor");
            String valor=Teclado.cadena();
            array.add(new Mapa(clave,valor));
        } while (Teclado.cierto("¿Añadir otra Clave-Valor?", "Si", "No"));
        return array;
    }

    public static String obtenerJson(String rutaJson) {
        BufferedReader lector;
        String salida = "";
        try {
            lector = new BufferedReader(new FileReader(rutaJson));

            salida = lector.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salida;
    }

    public static String buscar(String json, ArrayList<Mapa> a) {
        return buscar(json, a, 0);
    }

    private static String buscar(String json, ArrayList<Mapa> a, int indice) {
        Pattern pattern;
        Matcher matcher;
        String linea;
        String salida = "";
//[^\d].*?
        System.out.println(json);
        linea = String.format("[\\{\\[]+([^\\{]*?\"%s\":\"?%s\"?[,\\}\\]].*?)[\\}\\]]?", a.get(indice).clave, a.get(indice).valor);
        pattern = Pattern.compile(linea);
        matcher = pattern.matcher(json);

        while (matcher.find()) {
            if (indice + 1 == a.size()) {
                for (String s : matcher.group(1).replaceAll("\\}","").split(",")) {
                    salida += s + "\n";
                }

            } else {
                salida += buscar(String.format("{%s}", matcher.group(1).replaceAll("\\}","")), a, indice + 1);
            }
            salida += "\n";
        }

        return salida;
    }

}
