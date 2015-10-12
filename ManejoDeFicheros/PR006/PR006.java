import java.io.*;
import java.util.Arrays;

/**
 * Created by Afens on 12/10/2015.
 */
public class PR006 {
    public static void main(String[] args) {
        File origen = new File("PR006\\fichero.txt");
        File unido = new File("PR006\\unido.txt");
        BufferedReader reader, readerF1, readerF2, readerF3;
        BufferedWriter writerF1, writerF2, writerF3, writerUnido;
        char[] array = new char[15];

        try {
            reader = new BufferedReader(new FileReader(origen));
            writerUnido = new BufferedWriter(new FileWriter(unido));

            writerF1 = new BufferedWriter(new FileWriter("PR006\\f1.txt"));
            writerF2 = new BufferedWriter(new FileWriter("PR006\\f2.txt"));
            writerF3 = new BufferedWriter(new FileWriter("PR006\\f3.txt"));

            while (reader.read(array) != -1) {
                writerF1.write(array, 0, 5);
                writerF2.write(array, 5, 5);
                writerF3.write(array, 10, 5);
                Arrays.fill(array, ' ');

            }
            writerF1.close();
            writerF2.close();
            writerF3.close();
            reader.close();

            readerF1 = new BufferedReader(new FileReader("PR006\\f1.txt"));
            readerF2 = new BufferedReader(new FileReader("PR006\\f2.txt"));
            readerF3 = new BufferedReader(new FileReader("PR006\\f3.txt"));

            while (readerF1.read(array,0,5) != -1) {
                readerF2.read(array, 5, 5);
                readerF3.read(array, 10, 5);

                writerUnido.write(array);


            }
            writerUnido.close();
            readerF1.close();
            readerF2.close();
            readerF3.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error en el E/S.");
        }
    }
}
