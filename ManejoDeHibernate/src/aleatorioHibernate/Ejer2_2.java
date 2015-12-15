package aleatorioHibernate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import utiles.Teclado;

public class Ejer2_2 {

	public static void main(String[] args) {
		final int NOMBRE = 60;
		final int COD_OE = 4;
		final int COD_CURSO = 2;
		final int SKIP = 128;
		final int TOTAL = 144;
		int pos;
		File ruta = new File("src\\aleatorioHibernate\\salida2.dat");
		RandomAccessFile a;

		try {
			a = new RandomAccessFile(ruta, "rw");
			System.out.printf("====== Cursos ======");
			while (a.getFilePointer() < a.length()) {
				System.out.printf("\nID: %d", a.readInt());
				System.out.print(" Curso: ");
				for (int i = 0; i < COD_CURSO; i++)
					System.out.print(a.readChar());
				System.out.print(" ");
				for (int i = 0; i < COD_OE; i++)
					System.out.print(a.readChar());
				a.skipBytes(SKIP);				
			}
			
			System.out.println("\n\nIntroduce la id del curso que quieres ver");
			pos=Teclado.numInt(0, (int) (a.length() / TOTAL), Teclado.Opcion.MINIMO_INCLUIDO);			
			a.seek(pos * TOTAL);
			
			System.out.printf("\nID: %d\n", a.readInt());
			System.out.print("Curso: ");
			for (int i = 0; i < COD_CURSO; i++)
				System.out.print(a.readChar());
			System.out.print(" ");
			for (int i = 0; i < COD_OE; i++)
				System.out.print(a.readChar());
			System.out.print("\nTutor: ");
			for (int i = 0; i < NOMBRE; i++)
				System.out.print(a.readChar());
			System.out.printf("\nNumero de asignaturas: %d\n", a.readInt());
			System.out.printf("Numero de profesores: %d\n", a.readInt());


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
