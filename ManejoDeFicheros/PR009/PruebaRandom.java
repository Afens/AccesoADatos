import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * Created by Usuario on 19/10/2015.
 */
public class PruebaRandom {
    public static void main(String[] args) {
        RandomAccessFile e;
        try {
            e = new RandomAccessFile("PR009\\1.dat", "rw");


            e.writeBoolean(true);
            System.out.println("Fin1:" + e.getFilePointer());

            e.writeBoolean(true);
            System.out.println("Fin2:" + e.getFilePointer());

            System.out.println("Tamaño: " + e.length());

            e.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
}
