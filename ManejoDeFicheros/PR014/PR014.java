import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Afens on 02/11/2015.
 */
public class PR014 {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        FileWriter salida;
        ListaContactos contactos;
        Gson conversor=new GsonBuilder().setPrettyPrinting().create();

        try {
            salida = new FileWriter("PR014\\salida.json");

            xstream.alias("Agenda", ListaContactos.class);
            xstream.alias("DatosContacto", Contacto.class);
            xstream.aliasField("Telefono", Contacto.class, "phone");
            xstream.addImplicitCollection(ListaContactos.class, "lista");
            contactos = (ListaContactos) xstream.fromXML(new FileInputStream("PR010\\Agenda.xml"));

            salida.write(conversor.toJson(contactos.getListaContactos()));
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
