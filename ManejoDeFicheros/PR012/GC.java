import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Afens on 27/10/2015.
 */
public class GC extends DefaultHandler {
    private String guardar = "";
    private BufferedWriter writer;

    public GC() {
        super();
    }


    public void startDocument() throws SAXException {
        try {
            writer = new BufferedWriter(new FileWriter("PR012\\file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void endDocument() throws SAXException {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startElement(String uri, String nombre, String nombreC, Attributes atts) throws SAXException {

        if (!nombre.matches("DatosContacto") && !nombre.matches("Agenda"))
            guardar += nombre + ": ";


        for (int i = 0; i < atts.getLength(); i++) {
            guardar += String.format("(%s: %s) ", atts.getLocalName(i), atts.getValue(i));
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.matches("DatosContacto")) {
            try {
                //guardar = guardar.replaceAll("[\t\n]", "");
                writer.write(guardar);
                writer.newLine();
                guardar = "";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void characters(char[] chars, int inicio, int longitud) throws SAXException {
        String car = new String(chars, inicio, longitud);
        car = car.trim();
        if (car.length() > 0)
            guardar += String.format("%s ", car);
    }

}
