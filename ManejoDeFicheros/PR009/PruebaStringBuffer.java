import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Afens on 19/10/2015.
 */
public class PruebaStringBuffer {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        RandomAccessFile random;


        try {
            buffer.delete(0, buffer.length());
            //buffer.replace(0,10,"               ");
            buffer.append("1234");
            buffer.append("                           ");
/*
            while (buffer.length()<10)
                buffer.append(" ");*/
            buffer.setLength(10);




            random = new RandomAccessFile("PR009\\1.dat", "rw");
            random.writeUTF(buffer.toString());
            System.out.println(random.getFilePointer());

            random.seek(0);
            System.out.println(random.readUTF());







        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }



    }
}
