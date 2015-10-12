import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Afens on 12/10/2015.
 */
public class PR004 {
    public static void main(String[] args) {
        String extension;
        File dir;
        String[] validos;

        System.out.println("Introduce el directorio");
        dir = new File(Teclado.cadena());
        System.out.println("Introduce la extension");
        extension = Teclado.cadena();

        validos= dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.matches(".*\\."+extension))
                    return true;
                return false;
            }
        });

        if (validos.length >0 ){
            System.out.println("Se han encontrado los siguientes ficheros con la extension introducida");
            for (int i = 0; i < validos.length; i++) {
                System.out.println("\t"+validos[i]);
            }
        }else{
            System.out.println("No se han encontrado ficheros con la extension introducida");
        }

    }
}
