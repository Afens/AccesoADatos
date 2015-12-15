package ficheroHibernate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Asignatura;
import primero.Curso;
import primero.CursoId;
import primero.Horario;
import primero.Tramohorario;
import utiles.SessionFactoryUtil;

public class Ejer3 {

	public static void main(String[] args) {
		File ruta = new File("src\\ficheroHibernate\\salida3.txt");
		BufferedWriter escritor;
		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();
		Query cons = session.createQuery("FROM Asignatura");
		Asignatura asignatura;
		Horario horario;
		CursoId curso;
		ArrayList<CursoId> aux=new ArrayList<>();
		
		Iterator asignaturas = cons.iterate();
		Iterator horarios;
		
		try {
			escritor=new BufferedWriter(new FileWriter(ruta));

			escritor.write("**************************************************************************************************************\n");
            escritor.write("									ASIGNATURAS DEL IES SALADILLO\n");
            escritor.write("**************************************************************************************************************\n");
            while(asignaturas.hasNext()){
            	asignatura=(Asignatura) asignaturas.next();
            	escritor.write(String.format("Codigo: %-10s Nombre: %-60s Horas Semanales: %d",
            			asignatura.getCodAsignatura(),asignatura.getNombre(),asignatura.getHorasSemanales()));
            	if (asignatura.getHorarios().size()==0) {
            		escritor.write("\n\tEsta asignatura no tiene todavia horario asignado.");
				}else{
	            	horarios=asignatura.getHorarios().iterator();
	            	aux.clear();
	            	while(horarios.hasNext()){
	            		horario=(Horario) horarios.next();
	            		curso=horario.getCurso().getId();
	            		if(aux.indexOf(curso)==-1)	
	            			escritor.write(String.format("\n\tCodigo Curso %-3s %-5s Tramos Horarios: "
	            					,curso.getCodCurso(),curso.getCodOe()));
	            		
	            		if(aux.indexOf(curso)>-1)
	            			escritor.write(", ");
	            		
	            		escritor.write(horario.getTramohorario().getCodTramo());
	            		if(aux.indexOf(curso)==-1)	
	            			aux.add(curso);
	            	}
				}
            	escritor.write("\n\n");
            }
            escritor.close();
		System.out.println("Datos exportados");	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
