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
        String json = "";
        Pattern pattern;
        Matcher matcher;
        String linea; //comodin
        try {
            lector = new BufferedReader(new FileReader("PR016\\fich.json"));
/*
            while ((linea = lector.readLine()) != null) {
                //json += linea + "\n"; Modo Bonito
                //json+=linea.trim(); Modo Compacto
                json += linea.trim(); //Nesesitamos el modo compacto para el pattern

            }*/

            System.out.println("Introduce el nombre del contacto:");
            linea=String.format("(\"nombre\":\"%s\"),(\"phone\":\".*?\"),(\"direc\":\".*?\"),(\"codPostal\":.*?),(\"debo\":.*?),(\"cant\":.+?),(\"fecha\":\"\\d{2}/\\d{2}/\\d{4}\")",Teclado.cadena());
            //pattern = Pattern.compile("\"nombre\":\"(Pepe)\",\"phone\":\"(.*?)\",\"direc\": \"(.*?)\",\"codPostal\": (.*?),\"debo\": (.*?),\"cant\": (.+?),\"fecha\": \"(\\d{2}/\\d{2}/\\d{4})\"");
            //pattern = Pattern.compile("(\"nombre\": \"Pepe\"),(\"phone\": \".*?\"),(\"direc\": \".*?\"),(\"codPostal\": .*?),(\"debo\": .*?),(\"cant\": .+?),(\"fecha\": \"\\d{2}/\\d{2}/\\d{4}\")");
            pattern = Pattern.compile(linea);
            matcher = pattern.matcher(lector.readLine());
            while (matcher.find()) {
                System.out.println(matcher.group(1));
                System.out.println(matcher.group(2));
                System.out.println(matcher.group(3));
                System.out.println(matcher.group(4));
                System.out.println(matcher.group(5));
                System.out.println(matcher.group(6));
                System.out.println(matcher.group(7));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
