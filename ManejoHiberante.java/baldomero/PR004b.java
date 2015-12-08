package baldomero;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import primero.Profesor;

public class PR004b {

	public static void main(String[] args) {
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		
		Query q=session.createQuery("from Profesor");
		@SuppressWarnings("unchecked")
		Iterator<Profesor> it=q.iterate();
		q.setFetchSize(3);

		while (it.hasNext()){
			Profesor p = it.next();
			System.out.printf("Código: %s, Nombre: %s.\n",p.getCodProf(), p.getNombre());
		}
		session.close();
	}

}
