package baldomero;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import primero.Profesor;

public class PR004a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		
		Query q=session.createQuery("from Profesor");
		@SuppressWarnings("unchecked")
		List<Profesor> lista=q.list();
		
		for (Profesor p:lista)
			System.out.printf("Código: %s, Nombre: %s\n",p.getCodProf(), p.getNombre());
		session.close();
	}

}
