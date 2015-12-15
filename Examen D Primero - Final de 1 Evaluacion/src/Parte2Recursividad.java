/**
 * Created by Usuario on 14/12/2015.
 */
public class Parte2Recursividad {
    public static void main(String[] args) {
        String a="sda3a3d3a24df1a";
        System.out.println(funcion2(a));
    }

    public static int funcion(String cadena) {
        String valor="";
        if(cadena.matches("\\d.*"))
            valor+=cadena.charAt(0);
        if(cadena.length()-1>0)
            valor+=funcion(cadena.substring(1));
        if(valor.length()==0)
            valor+=0;
        return Integer.valueOf(valor);
    }
    public static int funcion2(String cadena) {
        int valor=0;
        int devuelto=0;
        if(cadena.length()-1>0)
            devuelto= funcion2(cadena.substring(0, cadena.length() - 1));
        if(cadena.matches(".*\\d")) {
            valor += Integer.valueOf(cadena.substring(cadena.length() - 1));
            valor+=devuelto*10;
        }
        else
            valor=devuelto;

        return valor;
    }
}
