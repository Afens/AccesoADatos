package baldomero;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Asignatura;

public class PR005a {

	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session sesion = sesionFactory.openSession();
		
		Asignatura asignatura;
		Query a = sesion.createQuery("from Asignatura where codAsignatura = ?");
		a.setString(0, "PROG");
		asignatura= (Asignatura) a.uniqueResult();
		
		System.out.printf("CodAsignatura: %s, Nombre: %s, Horas semanales: %d, Horas totales: %d\n", 
				asignatura.getCodAsignatura(), asignatura.getNombre(), asignatura.getHorasSemanales(), asignatura.getHorasTotales());
		

		sesion.close();

	}

}
