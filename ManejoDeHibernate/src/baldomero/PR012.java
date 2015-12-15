package baldomero;

import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Curso;
import primero.Profesor;
import utiles.SessionFactoryUtil;

public class PR012 {

	public static void main(String[] args) {
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		Query cons = session.createQuery("FROM Profesor p LEFT JOIN p.cursos");
		Iterator q = cons.iterate();
		Profesor p;
		Profesor aux=null;
		Object[] par;
		Curso c;
		while (q.hasNext()) {
			par = (Object[]) q.next();
			p = (Profesor) par[0];
			c = (Curso) par[1];
			if (aux == null || !p.equals(aux)) {
				aux = p;
				System.out.printf("- CodProf: %s, Nombre: %s, FechaAlta: %s, FechaNacimiento: %s\n", p.getCodProf(), p.getNombre(),
						format.format(p.getAlta()), format.format(p.getFechaDeNacimiento()));
			}
			if (c != null)
				System.out.printf("\t- CodOe: %s, CodCurso: %s\n", c.getOfertaeducativa().getCodOe(),
						c.getId().getCodCurso());
			else
				System.out.println("\t- No es Tutor.");
		}
		
		session.close();
	}

}
