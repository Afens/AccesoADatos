import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Afens on 26/10/2015.
 */
public class FactoryContacto {
    public static Contacto crearContacto(RandomAccessFile a) throws IOException {
        String nombre = "";
        String telf = "";
        String dir = "";
        char temp;
        int codPostal;
        float debo;

        a.readBoolean();
        a.readInt();
        for (int i = 0; i < PR009.CHAR_NOMBRE; i++) {
            temp = a.readChar();
            if (temp != 0)
                nombre += temp;
        }
        for (int i = 0; i < PR009.CHAR_TELF; i++) {
            temp = a.readChar();
            if (temp != 0)
                telf += temp;
        }

        for (int i = 0; i < PR009.CHAR_DIR; i++) {
            temp = a.readChar();
            if (temp != 0)
                dir += temp;
        }
        codPostal = a.readInt();
        a.readBoolean();
        debo = a.readFloat();
        return new Contacto(nombre, telf, dir, codPostal, debo);
    }
}
