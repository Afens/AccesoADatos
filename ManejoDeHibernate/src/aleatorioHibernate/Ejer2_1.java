package aleatorioHibernate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import utiles.SessionFactoryUtil;

public class Ejer2_1 {
	public static void main(String[] args) {
		final int NOMBRE = 60;
		final int COD_OE = 4;
		final int COD_CURSO = 2;
		RandomAccessFile a;
		int temp;
		File ruta = new File("src\\aleatorioHibernate\\salida2.dat");
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		Query cons = session.createQuery(
				"SELECT c.id.codCurso, c.id.codOe, c.profesor.nombre, "
				+ "count(r.asignatura),count(distinct r.profesor) "
				+ "FROM Curso c, Reparto r WHERE c=r.curso GROUP BY 2,1");

		List<Object[]> filas = cons.list();
		Object[] filaActual;
		StringBuffer buffer = new StringBuffer();
		try {
			a = new RandomAccessFile(ruta, "rw");
			for (int i = 0; i < filas.size(); i++) {
				filaActual = filas.get(i);
				a.writeInt(i);
				
				buffer.append(filaActual[0]);
				buffer.setLength(COD_CURSO);
		        a.writeChars(buffer.toString());
		        buffer.delete(0, buffer.length());
		        
		        buffer.append(filaActual[1]);
				buffer.setLength(COD_OE);
		        a.writeChars(buffer.toString());
		        buffer.delete(0, buffer.length());
		        
		        buffer.append(filaActual[2]);
				buffer.setLength(NOMBRE);
		        a.writeChars(buffer.toString());
		        buffer.delete(0, buffer.length());
				
		        temp =Integer.valueOf(String.format("%d", filaActual[3])) ;
		        a.writeInt(temp);
		        temp =Integer.valueOf(String.format("%d", filaActual[4])) ;
		        a.writeInt(temp);
				
			}
			System.out.println("Se han guardado los datos");
			a.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
