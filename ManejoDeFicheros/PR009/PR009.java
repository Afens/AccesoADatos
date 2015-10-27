import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Afens on 19/10/2015.
 */
public class PR009 {

    private static RandomAccessFile a;
    public static final int CHAR_NOMBRE = 20;
    public static final int CHAR_TELF = 12;
    public static final int CHAR_DIR = 20;
    public static final int TOTAL = 118;

    //True = vacio
    public static void main(String[] args) {
        int opcion;
        boolean repetir = true;

        try {
            a = new RandomAccessFile("PR009\\file.dat", "rw");
            init();

            do {
                System.out.println("------------- Menu -------------");
                System.out.println("1. Añadir Contacto.");
                System.out.println("2. Consultar el fichero.");
                System.out.println("3. Consultar contacto.");
                System.out.println("4. Modificar si le debo dinero y la cantidad.");
                System.out.println("5. Eliminar contacto.");
                System.out.println("6. Compactar fichero.");
                System.out.println("7. Salir.");
                System.out.print(" Opcion: ");
                opcion = Teclado.numInt(1, 7, Teclado.Opcion.AMBOS_INCLUIDOS);

                switch (opcion) {
                    case 1:
                        submenu();
                        break;
                    case 2:
                        consultarFich();
                        break;
                    case 3:
                        consultarCont();
                        break;
                    case 4:
                        modificar();
                        break;
                    case 5:
                        eliminar();
                        break;
                    case 6:
                        compactar();
                        break;
                    case 7:
                        compactar();
                        repetir = false;
                        break;
                }
            } while (repetir);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void init() throws IOException {
        StringBuffer buffer = new StringBuffer("Pepe");
        a.writeBoolean(false);
        a.writeInt(1);

        buffer.setLength(CHAR_NOMBRE);
        a.writeChars(buffer.toString());
        buffer.delete(0, buffer.length());

        buffer.append("+3641");
        buffer.setLength(CHAR_TELF);
        a.writeChars(buffer.toString());
        buffer.delete(0, buffer.length());

        buffer.append("calle");
        buffer.setLength(CHAR_DIR);
        a.writeChars(buffer.toString());
        buffer.delete(0, buffer.length());

        a.writeInt(123);
        a.writeBoolean(false);
        a.writeFloat(0);


        a.writeBoolean(false);
        a.writeInt(2);
        buffer.append("Rosa");
        buffer.setLength(CHAR_NOMBRE);
        a.writeChars(buffer.toString());
        buffer.delete(0, buffer.length());

        buffer.append("+3891");
        buffer.setLength(CHAR_TELF);
        a.writeChars(buffer.toString());
        buffer.delete(0, buffer.length());

        buffer.append("avenida");
        buffer.setLength(CHAR_DIR);
        a.writeChars(buffer.toString());
        buffer.delete(0, buffer.length());

        a.writeInt(6355);
        a.writeBoolean(true);
        a.writeFloat(10.6f);


    }


    private static void modificar() {

    }

    private static void eliminar() throws IOException {
        int i = (int) (a.length() / TOTAL);
        int pos;

        System.out.printf("Cual de los %d Contactos quieres eliminar\n", i);
        pos = Teclado.numInt(1, i, Teclado.Opcion.AMBOS_INCLUIDOS);

        a.seek((pos - 1) * TOTAL);
        a.writeBoolean(true);

    }

    private static void compactar() throws IOException {
        File origen = new File("PR009\\file.dat");
        File temporal = new File("PR009\\temp.dat");
        int cont = 0;
        RandomAccessFile temp = new RandomAccessFile(temporal, "rw");
        a.seek(0);
        while (a.getFilePointer() < a.length()) {
            if (!a.readBoolean()) {
                cont++;
                temp.writeBoolean(false);
                a.skipBytes(4);
                temp.writeInt(cont);


                for (int i = 0; i < CHAR_NOMBRE; i++)
                    temp.writeChar(a.readChar());

                for (int i = 0; i < CHAR_TELF; i++)
                    temp.writeChar(a.readChar());

                for (int i = 0; i < CHAR_DIR; i++)
                    temp.writeChar(a.readChar());


                temp.writeInt(a.readInt());
                if (a.readBoolean()) {
                    temp.writeBoolean(true);
                    temp.writeFloat(a.readFloat());
                } else {
                    temp.writeBoolean(false);
                    temp.writeFloat(0);
                    a.skipBytes(4);
                }

            } else
                a.skipBytes(TOTAL - 1);
        }

        a.close();
        temp.close();
        origen.delete();
        temporal.renameTo(origen);
        a=new RandomAccessFile(origen,"rw");

    }

    private static void consultarFich() throws IOException {
        a.seek(0);
        while (a.getFilePointer() < a.length()) {
            if (!a.readBoolean()) {
                datosContacto();
            } else
                a.skipBytes(TOTAL - 1);
        }
    }

    private static void consultarCont() throws IOException {
        int i = (int) (a.length() / TOTAL);
        int pos;
        System.out.printf("Cual de los %d Contactos quieres Consultar\n", i);
        pos = Teclado.numInt(1, i, Teclado.Opcion.AMBOS_INCLUIDOS);

        a.seek((pos - 1) * TOTAL);
        if (!a.readBoolean()) {
            datosContacto();
        } else
            System.out.println("El contacto ya no existe");
    }

    private static void datosContacto() throws IOException {
        System.out.printf("\tID: %d\n", a.readInt());

        System.out.print("\tNombre: ");
        for (int i = 0; i < CHAR_NOMBRE; i++)
            System.out.print(a.readChar());

        System.out.print("\n\tTelefono: ");
        for (int i = 0; i < CHAR_TELF; i++)
            System.out.print(a.readChar());

        System.out.print("\n\tDireccion: ");
        for (int i = 0; i < CHAR_DIR; i++)
            System.out.print(a.readChar());


        System.out.printf("%n\tCodigo postal: %d\n", a.readInt());
        if (a.readBoolean())
            System.out.printf("\tDebe %.2f€‚¬\n", a.readFloat());
        else
            a.skipBytes(4);
        System.out.println();
    }

    private static void submenu() throws IOException {
        int subopcion;
        System.out.println("------------- Menu -------------");
        System.out.println("1. Añadir al final.");
        System.out.println("2. Añadir en el primer hueco.");
        System.out.println("3. Cancelar.");
        System.out.print(" Opcion: ");
        subopcion = Teclado.numInt(1, 3, Teclado.Opcion.AMBOS_INCLUIDOS);
        switch (subopcion) {
            case 1:
                addEnd();
                break;
            case 2:
                addFirst();
                break;
        }
    }

    private static void addFirst() throws IOException {
        a.seek(0);
        while (!a.readBoolean()) {
            a.skipBytes(TOTAL - 1);
        }
        crearContacto((int) (a.getFilePointer() / TOTAL));
    }

    private static void addEnd() throws IOException {
        int id = (int) (a.length() / TOTAL);
        crearContacto(id);
    }

    private static void crearContacto(int id) throws IOException {
        StringBuffer buffer;
        Boolean debo;
        a.seek(id * TOTAL);
        a.writeBoolean(false);
        a.writeInt(id);
        System.out.println("Introduce Nombre");
        buffer = new StringBuffer(Teclado.cadena());
        buffer.setLength(CHAR_NOMBRE);
        a.writeChars(buffer.toString());
        buffer.delete(0, buffer.length());

        System.out.println("Introduce Telefono");
        buffer.append(Teclado.cadena());
        buffer.setLength(CHAR_TELF);
        a.writeChars(buffer.toString());
        buffer.delete(0, buffer.length());

        System.out.println("Introduce Direccion");
        buffer.append(Teclado.cadena());
        buffer.setLength(CHAR_DIR);
        a.writeChars(buffer.toString());
        buffer.delete(0, buffer.length());

        System.out.println("Introduce Codigo Postal");
        a.writeInt(Teclado.numInt(0, Teclado.Modo.MAYOR));

        debo = Teclado.cierto("¿Le debo dinero?", "Si", "No");
        a.writeBoolean(debo);

        if (debo) {
            System.out.println("Cuanto le debo");
            a.writeFloat(Teclado.numFloat(0, Teclado.Modo.MAYOR));
        } else {
            a.writeFloat(0);
        }


    }
}
