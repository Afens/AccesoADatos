package baldomero;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Horario;
import primero.HorarioId;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();

		Horario horario = new Horario();
		horario = (Horario) session.load(Horario.class,(HorarioId) new HorarioId("DAM","1A","PROG","L1"));
		System.out.println(horario.toString());
		System.out.println("aaa");
		session.close();

	}

}
