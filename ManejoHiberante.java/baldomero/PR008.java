package baldomero;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class PR008 {

	public static void main(String[] args) {
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		
		Query q=session.createQuery("select new baldomero.PR008Clase(p.codProf, p.nombre, count(distinct r.asignatura), "
				+ "count(h.tramohorario), count(distinct r.curso)) "
				+ "from Profesor p, Reparto r, Horario h where p.codProf=r.profesor.codProf "
				+ "and r.asignatura.codAsignatura=h.asignatura.codAsignatura group by p.codProf");
		@SuppressWarnings("rawtypes")
		Iterator it=q.iterate();
		q.setFetchSize(3);
		while (it.hasNext()){
			PR008Clase p=(PR008Clase) it.next();
			System.out.printf("CodProd: %s, Nombre: %s, Asignaturas: %d, Horas Semanales:%d, Cursos: %d.\n",
					p.getCodProf(), p.getNombre(), p.getTotalAsig(), p.getTotalHoras(), p.getTotalCursos());
			
		}
		
		session.close();
	}

}
