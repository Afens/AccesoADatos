import java.io.*;

/**
 * Created by Afens on 13/10/2015.
 */
public class PR008_2 {
    public static void main(String[] args) {
        Contacto per = new Contacto("P", 632, "C\\", 123, 10f);
        Contacto per2 = new Contacto("J", 954, "Avenida", 432, 0f);

        try {
            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("PR008\\save.dat"));
            ObjectInputStream leer = new ObjectInputStream(new FileInputStream("PR008\\save.dat"));

            escribir.writeObject(per);
            escribir.writeObject(per2);

            //escribir.close();
            while (true) {
                try {
                    System.out.println(leer.readObject().toString());
                } catch (EOFException e) {
                    return;
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
