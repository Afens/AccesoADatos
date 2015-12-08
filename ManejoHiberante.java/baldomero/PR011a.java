package baldomero;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Curso;
import primero.Ofertaeducativa;

public class PR011a {

	public static void main(String[] args) {
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();

		Query cons = session.createQuery("FROM Ofertaeducativa oe LEFT JOIN oe.cursos");
		Iterator q = cons.iterate();
		Ofertaeducativa oe;
		Ofertaeducativa aux = null;
		Curso c;
		Object[] par;
		while (q.hasNext()) {
			par = (Object[]) q.next();
			oe = (Ofertaeducativa) par[0];
			c = (Curso) par[1];
			if (aux == null || !oe.equals(aux)) {
				aux = oe;
				System.out.printf("- CodOe: %s, Nombre: %s, Tipo: %s Descripción: %s\n", oe.getCodOe(), oe.getNombre(),
						oe.getTipo(), oe.getDescripcion());
			}
			if (c != null)
				System.out.printf("\t- CodOe: %s, CodCurso: %s, Tutor: %s\n", c.getOfertaeducativa().getCodOe(),
						c.getId().getCodCurso(), c.getProfesor().getNombre());
			else
				System.out.println("\t- No tiene cursos.");
		}

		

	}

}
