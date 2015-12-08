package baldomero;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Asignatura;



public class PR007 {

	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session sesion = sesionFactory.openSession();

		Query q =sesion.createQuery("from Asignatura a, Repartoid r where a.codAsignatura=r.codAsignatura and codOe=? and codCurso=? ");
		q.setString(0, "DAM");
		q.setString(1, "1A");
		@SuppressWarnings("rawtypes")
		Iterator it=q.iterate();
		while(it.hasNext()){
			Object[] par=(Object[]) it.next();
			Asignatura a=(Asignatura) par[0];
			System.out.printf("Código: %s, Nombre: %s, Horas semanales: %d, Horas totales: %d\n",
					a.getCodAsignatura(), a.getNombre(), a.getHorasSemanales(), a.getHorasTotales());
		}
		sesion.close();
	}

}
