
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by Afens on 27/10/2015.
 */
public class PR012 {
    public static void main(String[] args) {
        XMLReader procesadorXML;
        GC gestor=new GC();
        InputSource fileXML=new InputSource("PR012\\SAX.xml");

        try {
            procesadorXML = XMLReaderFactory.createXMLReader();
            procesadorXML.setContentHandler(gestor);
            procesadorXML.parse(fileXML);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
