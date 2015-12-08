package baldomero;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PR009 {

	public static void main(String[] args) {
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		
		Query q=session.createQuery("Select avg(r.asignatura.horasSemanales) From Reparto r Where r.curso.ofertaeducativa.codOe=:cod");
		q.setString("cod","smr");
		
		Object o= q.uniqueResult();
		System.out.println(o);
		
		/*
		List<Object[]> lista = q.list();
		for (int i = 0; i < lista.size(); i++) {
			Object[] filaActual = lista.get(i);
			System.out.println(filaActual[0]);
		}
		*/		
		
		session.close();

	}

}
