package baldomero;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utiles.SessionFactoryUtil;


public class PR002b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update Profesor set nombre=? where codProf=?";
		
		Query a=session.createQuery(hql);
		a.setString(0,"Nombre2");
		a.setString(1, "B");
		a.executeUpdate();
		//session.createQuery(hql).setString(0,"Nombre2").setString(1, "B").executeUpdate();
		
		tx.commit();
		session.close();		
	}

}
