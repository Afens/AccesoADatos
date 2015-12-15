package baldomero;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Profesor;
import utiles.SessionFactoryUtil;

public class PR002a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		Transaction tx=session.beginTransaction();
		Profesor profesor=(Profesor) session.load(Profesor.class, "B");
		profesor.setNombre("Nuevo Nombre");
			
		session.update(profesor);
		tx.commit();
		session.close();
	}

}
