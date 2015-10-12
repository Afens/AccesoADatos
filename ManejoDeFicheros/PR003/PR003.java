import java.io.File;

/**
 * Created by Afens on 12/10/2015.
 */
public class PR003 {
    public static void main(String[] args) {
        String ruta;
        File dir;
        System.out.println("Introduce la ruta del directorio");
        ruta = Teclado.cadena();
        dir = new File(ruta);
        Teclado.cerrar();
        if (dir.isDirectory()) {
            System.out.println(dir.getName());
            recursiva(dir, 1);
        } else {
            System.out.println("La ruta introducida no existe o no es un directorio.");
        }

    }

    private static void recursiva(File dir, int cont) {
        String tab = "";
        for (int i = 0; i < cont; i++) {
            tab += "\t";
        }
        for (int i = 0; i < dir.list().length; i++) {
            System.out.printf("%s%s\n", tab, dir.listFiles()[i].getName());
            if (dir.listFiles()[i].isDirectory()){
                recursiva(dir.listFiles()[i],cont+1);
            }
        }
        System.out.println();

    }

}
