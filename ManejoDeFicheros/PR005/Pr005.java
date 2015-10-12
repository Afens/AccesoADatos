import java.io.*;

/**
 * Created by Afens on 07/10/2015.
 */
public class Pr005 {
    public static void main(String[] args) throws Exception {
        File origen;
        File destino;

        BufferedReader leer;
        PrintWriter escribir;

        String linea;
        boolean tf = true;

        System.out.println("Introduce la ruta de origen");
        origen = new File(Teclado.cadena());
        System.out.println("Introduce la ruta de destino");
        destino = new File(Teclado.cadena());

        try {
            leer = new BufferedReader(new FileReader(origen));


            if (destino.isDirectory()) {
                escribir = new PrintWriter(
                        destino.getAbsolutePath() + "\\" + origen.getName());
                while ((linea = leer.readLine()) != null) {
                    escribir.println(linea);
                }
                escribir.close();
                System.out.println("El fichero ha sido copiado");

            } else {
                if (destino.exists() && tf) {
                    escribir = new PrintWriter(destino);
                    while ((linea = leer.readLine()) != null) {
                        escribir.println(linea);
                    }
                    escribir.close();
                    System.out.println("El fichero ha sido copiado");

                } else if (destino.exists() && !tf) {
                    throw new Exception();
                }
            }
            leer.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
