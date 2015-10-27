import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by Afens on 27/10/2015.
 */
public class PR013 {
    public static void main(String[] args) {
        Source xsl = new StreamSource("PR013\\archivo.xsl"); // estilos
        Source xml = new StreamSource("PR012\\SAX.xml"); // datos
        FileOutputStream html; // fichero
        Result result; //resultado
        Transformer trans; //convertidor
        try {
            html = new FileOutputStream("PR013\\pagina.html");
            result = new StreamResult(html);
            trans = TransformerFactory.newInstance().newTransformer(xsl);
            trans.transform(xml, result);
            html.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
