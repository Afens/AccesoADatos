import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Afens on 26/10/2015.
 */
public class PR010 {
    public static void main(String[] args) {
        ListaContactos lista = new ListaContactos();
        RandomAccessFile a;

        try {
            a = new RandomAccessFile("PR009\\file.dat", "r");

            while (a.getFilePointer() < a.length()) {
                lista.add(FactoryContacto.crearContacto(a));
            }
            a.close();


            XStream xstream = new XStream();
            xstream.alias("Agenda", ListaContactos.class);
            xstream.alias("DatosContacto", Contacto.class);
            xstream.aliasField("Telefono", Contacto.class, "phone");
            xstream.addImplicitCollection(ListaContactos.class, "lista");
            xstream.toXML(lista, new FileOutputStream("PR010\\Agenda.xml"));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
