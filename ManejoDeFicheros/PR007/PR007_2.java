/**
 * Created by Usuario on 07/10/2015.
 */

import java.io.*;

public class PR007_2 {

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
            while ((codLetra = leerFich.read()) != -1) {
                //System.out.printf("%d ",codLetra);
                codLetra += clave.charAt(cont)+2;
                if (codLetra > 126 && codLetra < 161) {
                    codLetra -= 95;
                }
                //System.out.printf("%d ",codLetra);
                escribirEncrip.write(codLetra);
                cont++;
                if (cont >= clave.length()) cont = 0;

            }
            leerFich.close();
            escribirEncrip.close();
            System.out.println();
            cont = 0;
            leerEncrp = new FileReader(encriptado);
            while ((codLetra = leerEncrp.read()) != -1) {
                //System.out.printf("%d ",codLetra);
                if (codLetra < 66)
                    codLetra += 95;

                codLetra -=  clave.charAt(cont)+2 ;

                //System.out.printf("%d ",codLetra);
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
