package baldomero;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Asignatura;

public class PR005b {

	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session sesion = sesionFactory.openSession();
		Asignatura asignatura;
		Query a = sesion.createQuery("from Asignatura a where a.nombre = :nombre");
		a.setString("nombre", "Bases de datos");
		asignatura= (Asignatura) a.uniqueResult();
		System.out.printf("CodAsignatura: %s, Nombre: %s, Horas semanales: %d, Horas totales: %d", 
				asignatura.getCodAsignatura(), asignatura.getNombre(), asignatura.getHorasSemanales(), asignatura.getHorasTotales());
		
		sesion.close();

	}

}
