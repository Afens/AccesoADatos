package baldomero;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Profesor;

public class PR001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		Transaction tx=session.beginTransaction();
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
		Profesor profesor=new Profesor();
		profesor.setCodProf("B");
		profesor.setNombre("Baldomero");
		profesor.setAlta(new Date());
		try {
			profesor.setFechaDeNacimiento(format.parse("11/12/1970"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.save(profesor);
		tx.commit();
		session.close();
		System.out.println("aa");

	}

}
