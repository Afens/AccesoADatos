package baldomero;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Historicoprofesor;
import primero.Profesor;

public class PR003a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		Transaction tx=session.beginTransaction();
		
		Profesor profesor=(Profesor) session.load(Profesor.class, "B");	
		Historicoprofesor historico=new Historicoprofesor();
		
		historico.setCodProf(profesor.getCodProf());
		historico.setNombre(profesor.getNombre());
		historico.setAlta(profesor.getAlta());
		historico.setFechaDeNacimiento(profesor.getFechaDeNacimiento());
		
		session.save(historico);
		session.delete(profesor);
		
		tx.commit();
		session.close();
	}

}
