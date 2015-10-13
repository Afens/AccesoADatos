import java.io.*;

/**
 * Created by Afens on 13/10/2015.
 */
public class PR008 {
    public static void main(String[] args) {
        File save = new File("PR008\\save.dat");
        String nombre = "P";
        int phone = 666;
        String direc = "C/";
        int codPostal = 11;
        boolean debo = false;
        float cant = 0;

        String nombre2 = "J";
        int phone2 = 953;
        String direc2 = "C/";
        int codPostal2 = 11;
        boolean debo2 = true;
        float cant2 = 10f;


        try {
            DataInputStream leer = new DataInputStream(new FileInputStream(save));
            DataOutputStream escribir = new DataOutputStream(new FileOutputStream(save));

            escribir.writeUTF(nombre);
            escribir.writeInt(phone);
            escribir.writeUTF(direc);
            escribir.writeInt(codPostal);
            escribir.writeBoolean(debo);
            escribir.writeFloat(cant);

            escribir.writeUTF(nombre2);
            escribir.writeInt(phone2);
            escribir.writeUTF(direc2);
            escribir.writeInt(codPostal2);
            escribir.writeBoolean(debo2);
            escribir.writeFloat(cant2);
            escribir.close();
            while (true) {
                try {
                    System.out.printf("Nombre: %s\n\tTelefono: %d\n\tDireccion: %s\n\tCodigo Postal: %d\n\t%s\n\n",
                            leer.readUTF(), leer.readInt(), leer.readUTF(), leer.readInt(), leer.readBoolean() ? String.format("Le debo %.2f $", leer.readFloat()) : String.format("No le debo", leer.readFloat()));
                } catch (EOFException e) {
                    return;
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
