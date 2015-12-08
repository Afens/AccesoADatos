package baldomero;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PR003b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		Transaction tx=session.beginTransaction();
		Query a;
		String hql;
		
		hql="insert into Historicoprofesor (codProf, nombre, alta, fechaDeNacimiento) "
				+ "select codProf, nombre, alta, fechaDeNacimiento from Profesor where codProf='B'";
		a=session.createQuery(hql);
		a.executeUpdate();
		
		hql="delete Profesor where codProf='B'";
		a=session.createQuery(hql);
		a.executeUpdate();
		
		tx.commit();
		session.close();
	}

}
