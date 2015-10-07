/**
 * Created by Usuario on 07/10/2015.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File fichero = new File("fichero.txt"), encriptado = new File("./Encriptado.txt");
        FileReader lectorF, lectorEn;
        FileWriter wriEn, wriDes;
        String clave;
        int i, codLetra, cont = 0;

        System.out.print("- Introduzca la clave de encriptación: ");
        clave = Teclado.cadena();
        try {
            wriEn = new FileWriter(encriptado);
            wriDes = new FileWriter("./Desencriptado.txt");
            try {

                lectorF = new FileReader(fichero);
                while ((i = lectorF.read()) != -1) {
                    codLetra = i - clave.charAt(cont);
                    if (codLetra < 0) {
                        codLetra += 255;
                    } else {
                        codLetra += 32;
                    }
                    wriEn.write(codLetra);
                    cont++;
                    if (cont >= clave.length()) cont = 0;

                }
                cont = 0;
                i = 0;
                lectorF.close();
                wriEn.close();
                lectorEn = new FileReader(encriptado);
                while ((i = lectorEn.read()) != -1) {
                    if (i > 126)
                        codLetra = i - 255;
                    else
                        codLetra = i - 32;
                    codLetra = codLetra + clave.charAt(cont);


                    wriDes.write(codLetra);
                    cont++;
                    if (cont >= clave.length()) cont = 0;
                }
                lectorEn.close();
                wriDes.close();
            } catch (FileNotFoundException e) {
            }
        } catch (IOException e) {
        }
    }
}
