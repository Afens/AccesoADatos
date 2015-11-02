import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Afens on 02/11/2015.
 */
//{"nombre": "Pepe","phone": "+3641","direc": "calle","codPostal": 123,"debo": false,"cant": 0.0}
public class PR016 {
    public static void main(String[] args) {
        BufferedReader lector;
        String json = "";
        Pattern pattern;
        Matcher matcher;
        try {
            lector = new BufferedReader(new FileReader("PR014\\salida.json"));
            String linea;
            while ((linea = lector.readLine()) != null) {
                json += linea + "\n";
            }
            //json+=linea.trim(); para sacarlo en modo compacto

            pattern = Pattern.compile("(\"nombre\": \".*\",\"phone\": \".*\",\"direc\": \".*\",\"codPostal\": .*,\"debo\": .*,\"cant\": .*)");
            matcher = pattern.matcher(json);
            while (matcher.find())
                System.out.println(matcher.group(1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
