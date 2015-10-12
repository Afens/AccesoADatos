/**
 * Created by Usuario on 07/10/2015.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PR007 {

    public static void main(String[] args) {

        File fichero = new File("fichero.txt");
        File encriptado = new File("Encriptado.txt");
        File desencriptado = new File("Desencriptado.txt");
        FileReader leerFich, leerEncrp;
        FileWriter escribirEncrip, escribirDesen;
        String clave;
        int i, codLetra, cont = 0;

        System.out.print("- Introduzca la clave de encriptación: ");
        clave = Teclado.cadena();
        try {
            escribirEncrip = new FileWriter(encriptado);
            escribirDesen = new FileWriter(desencriptado);

            leerFich = new FileReader(fichero);
            while ((i = leerFich.read()) != -1) {
                codLetra = i - clave.charAt(cont);
                if (codLetra < 0) {
                    codLetra += 255;
                } else {
                    codLetra += 32;
                }
                escribirEncrip.write(codLetra);
                cont++;
                if (cont >= clave.length()) cont = 0;

            }
            leerFich.close();
            escribirEncrip.close();

            cont = 0;
            leerEncrp = new FileReader(encriptado);
            while ((i = leerEncrp.read()) != -1) {
                if (i > 126)
                    codLetra = i - 255;
                else
                    codLetra = i - 32;
                codLetra = codLetra + clave.charAt(cont);


                escribirDesen.write(codLetra);
                cont++;
                if (cont >= clave.length()) cont = 0;
            }
            leerEncrp.close();
            escribirDesen.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
}
