import java.io.File;

/**
 * Created by Afens on 06/10/2015.
 */
public class Pr001 {
    public static void main(String[] args) {
        String fichero;
        File file;

        System.out.println("Introduce el la ruta absoluta del fichero");
        fichero=Teclado.cadena();
        Teclado.cerrar();
        file=new File(fichero);

        System.out.println("Nombre del Fichero:\t" + file.getName());
        System.out.println("Se puede ejecutar:\t" + file.canExecute());
        System.out.println("Esta oculto:\t" + file.isHidden());
        System.out.println("Ruta relativa:\t" + file.getPath());
        System.out.println("Ruta absoluta:\t" + file.getAbsolutePath());
        System.out.println("Tamaño:\t" + file.length());
    }
}
