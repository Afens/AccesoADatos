import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Afens on 06/10/2015.
 */
public class Teclado {
    private static Scanner lapi=new Scanner(System.in);
    private static boolean error=false;
    public enum Modo{
        MAYOR_IGUAL,MENOR_IGUAL,MAYOR,MENOR
    }
    public enum Opcion{
        AMBOS_INCLUIDOS,AMBOS_EXCLUIDOS,MINIMO_INCLUIDO,MAXIMO_INCLUIDO
    }

    public static void cerrar(){
        lapi.close();
    }

    //Entrada de Boolean
    public static boolean cierto(String mensaje,String verdadero,String falso){
        boolean salida;
        System.out.println(mensaje);
        System.out.println("\t1. "+verdadero);
        System.out.println("\t2. "+falso);

        if(numInt(1, 2, Opcion.AMBOS_INCLUIDOS)==1)
            salida=true;
        else
            salida=false;

        return salida;
    }

    //Entrada de Char
    public static char caracter(){
        String salida;
        do {
            salida = lapi.nextLine();
            if(salida.length()>1){
                System.out.println("Error: Has introducido mas de un caracter");
                error=true;
            }else
                error=false;
        } while (error);
        return salida.charAt(0);
    }

    public static char caracter(String patron){
        String salida;
        do {
            salida = lapi.nextLine();
            if(salida.length()>1||!salida.matches(patron)){
                System.out.println("Error: Has introducido mas de un caracter o no cumple el patron");
                error=true;
            }else
                error=false;
        } while (error);
        return salida.charAt(0);
    }

    //Entrada de String
    public static String cadena(){
        String salida;
        salida=lapi.nextLine();
        return salida;
    }
    public static String cadena(String patron){
        String salida;
        do {
            salida = cadena();
            if (salida.matches(patron))
                error = false;
            else{
                System.out.println("Error: La cadena no cumple el patron.");
                error = true;
            }
        } while (error);
        return salida;
    }

    //Entrada de Int
    public static int numInt(){
        int salida=0;
        do {
            try {
                salida = lapi.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: No has introducido un Entero tipo Int");
                error = true;
            }finally{
                lapi.nextLine();
            }
        } while (error);
        return salida;
    }
    public static int numInt(int comparador,Modo modo){
        int salida=0;
        do {
            error=false;
            salida = numInt();
            switch (modo) {
                case MAYOR_IGUAL:
                    if (salida < comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor o igual que "+ comparador);
                    }
                    break;
                case MENOR_IGUAL:
                    if (salida > comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor o igual que "+ comparador);
                    }
                    break;
                case MAYOR:
                    if (salida <= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor que "+ comparador);
                    }
                    break;
                case MENOR:
                    if (salida >= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor que "+ comparador);
                    }
                    break;
            }
        } while (error);
        return salida;
    }
    public static int numInt(int min,int max,Opcion option){
        int salida=0;
        if(min>=max){
            System.out.println("Error: El minimo es mayor o igual que el maximo.");
        }else{
            do {
                error=false;
                salida = numInt();
                switch (option) {
                    case AMBOS_INCLUIDOS:
                        if (salida < min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Incluidos\n",min, max);
                        }
                        break;
                    case AMBOS_EXCLUIDOS:
                        if (salida <= min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Excluidos\n",min, max);
                        }
                        break;
                    case MINIMO_INCLUIDO:
                        if (salida < min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo incluido y el maximo excluido\n",min, max);
                        }
                        break;
                    case MAXIMO_INCLUIDO:
                        if (salida <= min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo excluido y el maximo incluido\n",min, max);
                        }
                        break;
                }
            } while (error);
        }
        return salida;
    }

    //Entrada de Byte
    public static byte numByte(){
        byte salida=0;
        do {
            try {
                salida = lapi.nextByte();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: No has introducido un Entero tipo Byte");
                error = true;
            }finally{
                lapi.nextLine();
            }
        } while (error);
        return salida;
    }
    public static byte numByte(byte comparador,Modo modo){
        byte salida=0;
        do {
            error=false;
            salida = numByte();
            switch (modo) {
                case MAYOR_IGUAL:
                    if (salida < comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor o igual que "+ comparador);
                    }
                    break;
                case MENOR_IGUAL:
                    if (salida > comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor o igual que "+ comparador);
                    }
                    break;
                case MAYOR:
                    if (salida <= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor que "+ comparador);
                    }
                    break;
                case MENOR:
                    if (salida >= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor que "+ comparador);
                    }
                    break;
            }
        } while (error);
        return salida;
    }
    public static byte numByte(byte min,byte max,Opcion option){
        byte salida=0;
        if(min>max){
            System.out.println("Error: El minimo es mayor que el maximo. Devuelve 0");
        }else{
            do {
                error=false;
                salida = numByte();
                switch (option) {
                    case AMBOS_INCLUIDOS:
                        if (salida < min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Incluidos\n",min, max);
                        }
                        break;
                    case AMBOS_EXCLUIDOS:
                        if (salida <= min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Excluidos\n",min, max);
                        }
                        break;
                    case MINIMO_INCLUIDO:
                        if (salida < min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo incluido y el maximo excluido\n",min, max);
                        }
                        break;
                    case MAXIMO_INCLUIDO:
                        if (salida <= min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo excluido y el maximo incluido\n",min, max);
                        }
                        break;
                }
            } while (error);
        }
        return salida;
    }

    //Entrada de Short
    public static short numShort(){
        short salida=0;
        do {
            try {
                salida = lapi.nextShort();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: No has introducido un Entero tipo Short");
                error = true;
            }finally{
                lapi.nextLine();
            }
        } while (error);
        return salida;
    }
    public static short numShort(short comparador,Modo modo){
        short salida=0;
        do {
            error=false;
            salida = numShort();
            switch (modo) {
                case MAYOR_IGUAL:
                    if (salida < comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor o igual que "+ comparador);
                    }
                    break;
                case MENOR_IGUAL:
                    if (salida > comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor o igual que "+ comparador);
                    }
                    break;
                case MAYOR:
                    if (salida <= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor que "+ comparador);
                    }
                    break;
                case MENOR:
                    if (salida >= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor que "+ comparador);
                    }
                    break;
            }
        } while (error);
        return salida;
    }
    public static short numShort(short min,short max,Opcion option){
        short salida=0;
        if(min>max){
            System.out.println("Error: El minimo es mayor que el maximo. Devuelve 0");
        }else{
            do {
                error=false;
                salida = numShort();
                switch (option) {
                    case AMBOS_INCLUIDOS:
                        if (salida < min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Incluidos\n",min, max);
                        }
                        break;
                    case AMBOS_EXCLUIDOS:
                        if (salida <= min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Excluidos\n",min, max);
                        }
                        break;
                    case MINIMO_INCLUIDO:
                        if (salida < min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo incluido y el maximo excluido\n",min, max);
                        }
                        break;
                    case MAXIMO_INCLUIDO:
                        if (salida <= min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo excluido y el maximo incluido\n",min, max);
                        }
                        break;
                }
            } while (error);
        }
        return salida;
    }

    //Entrada de Long
    public static long numLong(){
        long salida=0;
        do {
            try {
                salida = lapi.nextLong();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: No has introducido un Entero tipo Long");
                error = true;
            }finally{
                lapi.nextLine();
            }
        } while (error);
        return salida;
    }
    public static long numLong(long comparador,Modo modo){
        long salida=0;
        do {
            error=false;
            salida = numLong();
            switch (modo) {
                case MAYOR_IGUAL:
                    if (salida < comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor o igual que "+ comparador);
                    }
                    break;
                case MENOR_IGUAL:
                    if (salida > comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor o igual que "+ comparador);
                    }
                    break;
                case MAYOR:
                    if (salida <= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor que "+ comparador);
                    }
                    break;
                case MENOR:
                    if (salida >= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor que "+ comparador);
                    }
                    break;
            }
        } while (error);
        return salida;
    }
    public static long numLong(long min,long max,Opcion option){
        long salida=0;
        if(min>max){
            System.out.println("Error: El minimo es mayor que el maximo. Devuelve 0");
        }else{
            do {
                error=false;
                salida = numLong();
                switch (option) {
                    case AMBOS_INCLUIDOS:
                        if (salida < min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Incluidos\n",min, max);
                        }
                        break;
                    case AMBOS_EXCLUIDOS:
                        if (salida <= min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Excluidos\n",min, max);
                        }
                        break;
                    case MINIMO_INCLUIDO:
                        if (salida < min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo incluido y el maximo excluido\n",min, max);
                        }
                        break;
                    case MAXIMO_INCLUIDO:
                        if (salida <= min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo excluido y el maximo incluido\n",min, max);
                        }
                        break;
                }
            } while (error);
        }
        return salida;
    }

    //Entrada de Float
    public static float numFloat(){
        float salida=0;
        do {
            try {
                salida = lapi.nextFloat();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: No has introducido un Entero tipo Float");
                error = true;
            }finally{
                lapi.nextLine();
            }
        } while (error);
        return salida;
    }
    public static float numFloat(float comparador,Modo modo){
        float salida=0;
        do {
            error=false;
            salida = numFloat();
            switch (modo) {
                case MAYOR_IGUAL:
                    if (salida < comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor o igual que "+ comparador);
                    }
                    break;
                case MENOR_IGUAL:
                    if (salida > comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor o igual que "+ comparador);
                    }
                    break;
                case MAYOR:
                    if (salida <= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor que "+ comparador);
                    }
                    break;
                case MENOR:
                    if (salida >= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor que "+ comparador);
                    }
                    break;
            }
        } while (error);
        return salida;
    }
    public static float numFloat(float min,float max,Opcion option){
        float salida=0;
        if(min>max){
            System.out.println("Error: El minimo es mayor que el maximo. Devuelve 0");
        }else{
            do {
                error=false;
                salida = numFloat();
                switch (option) {
                    case AMBOS_INCLUIDOS:
                        if (salida < min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Incluidos\n",min, max);
                        }
                        break;
                    case AMBOS_EXCLUIDOS:
                        if (salida <= min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Excluidos\n",min, max);
                        }
                        break;
                    case MINIMO_INCLUIDO:
                        if (salida < min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo incluido y el maximo excluido\n",min, max);
                        }
                        break;
                    case MAXIMO_INCLUIDO:
                        if (salida <= min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo excluido y el maximo incluido\n",min, max);
                        }
                        break;
                }
            } while (error);
        }
        return salida;
    }

    //Entrada de Double
    public static double numDouble(){
        double salida=0;
        do {
            try {
                salida = lapi.nextDouble();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: No has introducido un Entero tipo Double");
                error = true;
            }finally{
                lapi.nextLine();
            }
        } while (error);
        return salida;
    }
    public static double numDouble(double comparador,Modo modo){
        double salida=0;
        do {
            error=false;
            salida = numDouble();
            switch (modo) {
                case MAYOR_IGUAL:
                    if (salida < comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor o igual que "+ comparador);
                    }
                    break;
                case MENOR_IGUAL:
                    if (salida > comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor o igual que "+ comparador);
                    }
                    break;
                case MAYOR:
                    if (salida <= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero mayor que "+ comparador);
                    }
                    break;
                case MENOR:
                    if (salida >= comparador) {
                        error = true;
                        System.out.println("Error: Introduce un numero menor que "+ comparador);
                    }
                    break;
            }
        } while (error);
        return salida;
    }
    public static double numDouble(double min,double max,Opcion option){
        double salida=0;
        if(min>max){
            System.out.println("Error: El minimo es mayor que el maximo. Devuelve 0");
        }else{
            do {
                error=false;
                salida = numDouble();
                switch (option) {
                    case AMBOS_INCLUIDOS:
                        if (salida < min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Incluidos\n",min, max);
                        }
                        break;
                    case AMBOS_EXCLUIDOS:
                        if (salida <= min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. Ambos Excluidos\n",min, max);
                        }
                        break;
                    case MINIMO_INCLUIDO:
                        if (salida < min || salida >= max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo incluido y el maximo excluido\n",min, max);
                        }
                        break;
                    case MAXIMO_INCLUIDO:
                        if (salida <= min || salida > max) {
                            error = true;
                            System.out.printf("Error: Introduce un numero que se encuentre entre %d y %d. El minimo excluido y el maximo incluido\n",min, max);
                        }
                        break;
                }
            } while (error);
        }
        return salida;
    }

}