package baldomero;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Curso;
import primero.Ofertaeducativa;
import utiles.SessionFactoryUtil;

public class PR011b {

	

	public static void main(String[] args) {
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();

		Query cons = session.createQuery("FROM Ofertaeducativa oe LEFT JOIN FETCH oe.cursos");
		Ofertaeducativa oe;
		Object aux=null;
		Curso c;
		Set set;
		List<Ofertaeducativa> list = cons.list();
		Iterator ite = list.iterator();
		Iterator it;		
		while (ite.hasNext()) {
			oe = (Ofertaeducativa) ite.next();
			if (aux == null || !oe.equals(aux)) {				
				aux=oe;
				System.out.println("=====================================================================");
				System.out.printf("- CodOe: %s, Nombre: %s, Tipo: %s Descripción: %s\n", oe.getCodOe(), oe.getNombre(),
						oe.getTipo(), oe.getDescripcion());
				set = oe.getCursos();
				if (!set.isEmpty()) {
					it = set.iterator();
					while (it.hasNext()) {
						c = (Curso) it.next();
						System.out.printf("\t- CodOe: %s, CodCurso: %s, Tutor: %s\n", c.getOfertaeducativa().getCodOe(),
								c.getId().getCodCurso(), c.getProfesor().getNombre());
					}
				} else
					System.out.println("\t- No tiene cursos.");
			}

		}
		session.close();

	}

}
