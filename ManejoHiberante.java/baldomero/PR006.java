package baldomero;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Asignatura;


public class PR006 {

	public static void main(String[] args) {
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		
		Query q=session.createQuery("from Asignatura where horasSemanales in (3,4,6)");
		@SuppressWarnings("unchecked")
		Iterator<Asignatura> it=q.iterate();
		q.setFetchSize(3);

		while (it.hasNext()){
			Asignatura a = it.next();
			System.out.printf("Código: %s, Nombre: %s, Horas semanales: %d, Horas totales: %d\n",
					a.getCodAsignatura(), a.getNombre(), a.getHorasSemanales(), a.getHorasTotales());
			
		}
		session.close();
	}

}
