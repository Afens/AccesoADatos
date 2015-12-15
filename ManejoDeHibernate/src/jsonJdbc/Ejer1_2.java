package jsonJdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utiles.Teclado;

public class Ejer1_2 {

	public static void main(String[] args) {
		BufferedReader lector;
        Pattern pattern;
        Matcher matcher;
        String linea;
        String codProf;
        boolean vacio=true;
        File ruta=new File("src\\jsonJdbc\\salida.json");
        try {
            lector = new BufferedReader(new FileReader(ruta));

            System.out.println("Introduce el codigo del profesor");
            codProf=Teclado.cadena().toUpperCase();
            linea=String.format("\\{(\"codProf\":\"%s\".+?)\\}",codProf);
            pattern = Pattern.compile(linea);
            matcher = pattern.matcher(lector.readLine());

            while (matcher.find()) {
                for (String s : matcher.group(1).split("\",")) {
                    System.out.println(s.replace('"',' '));
                }
                System.out.println();
                vacio=false;
            }
            if(vacio)
            	System.out.println("No hay ningun profesor con ese codigo");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
