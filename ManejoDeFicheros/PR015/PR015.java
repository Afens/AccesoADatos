import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Afens on 02/11/2015.
 */
public class PR015 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader lector;
        BufferedWriter escritor;
        ArrayList<Contacto> contactos;
        Type tipoListaEmpleados = new TypeToken<ArrayList<Contacto>>() {
        }.getType();



        try {
            escritor=new BufferedWriter(new FileWriter("PR015\\salida.txt"));
            lector = new BufferedReader(new FileReader("PR014\\salida.json"));
            contactos = gson.fromJson(lector, tipoListaEmpleados);

            escritor.write("*************************************************************\n");
            escritor.write("                     Agenda Telefonica\n");
            escritor.write("*************************************************************\n");
            for (Contacto contacto : contactos) {
                escritor.write(contacto.toString());
                escritor.write("*************************************************************\n");
            }
            escritor.write("                  Fin de la Agenda Telefonica\n");
            escritor.write("*************************************************************\n");
            escritor.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
