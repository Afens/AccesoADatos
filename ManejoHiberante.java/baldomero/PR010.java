package baldomero;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PR010 {
	public static void main(String[] args) {
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();

		Query q = session
				.createQuery("Select distinct r.profesor.nombre From Reparto r "
						+ " Where r.curso.ofertaeducativa.codOe=:cod and r.asignatura.horasSemanales > "
						+ "(Select avg(a.asignatura.horasSemanales) From Reparto a "
						+ " Where a.curso.ofertaeducativa.codOe=:cod)");
		q.setString("cod", "dam");
		Iterator it = q.iterate();
		while (it.hasNext()) {

			System.out.println((String)it.next());
		}
		session.close();
	}
}
