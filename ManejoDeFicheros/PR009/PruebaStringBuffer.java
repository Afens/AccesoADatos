/**
 * Created by Afens on 19/10/2015.
 */
public class PruebaStringBuffer {
    public static void main(String[] args) {
        StringBuffer s=new StringBuffer();

        s.append("hola  ");
        s.replace(0,20,"a");
        s.setLength(3);




        System.out.println(s.length());

    }
}
