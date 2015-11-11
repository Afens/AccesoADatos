import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Afens on 02/11/2015.
 */

public class PR016 {
    public static void main(String[] args) {
        BufferedReader lector;
        Pattern pattern;
        Matcher matcher;
        String linea;
        try {
            lector = new BufferedReader(new FileReader("PR016\\fich.json"));
            /*
            while ((linea = lector.readLine()) != null) {
                //json += linea + "\n"; Modo Bonito
                //json+=linea.trim(); Modo Compacto
                json += linea.trim(); //Nesesitamos el modo compacto para el pattern

            }*/

            System.out.println("Introduce el nombre del contacto:");
            linea=String.format("[\\{\\[](\".+?%s.+?)[\\}\\]]",Teclado.cadena());
            pattern = Pattern.compile(linea);
            matcher = pattern.matcher(lector.readLine());//.replace('"',' ')

            while (matcher.find()) {
                for (String s : matcher.group(1).split(",")) {
                    System.out.println(s.replace('"',' '));
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
