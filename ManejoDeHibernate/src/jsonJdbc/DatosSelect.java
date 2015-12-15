package jsonJdbc;

import java.util.Date;

public class DatosSelect {
	String codProf;
	String nombre;
	Date fechaNacimiento;	
	String tutorEn="";

	int asignaturasImparte;

	public DatosSelect(String codProf, String nombre, Date fechaNacimiento, String codOe, String codCurso,
			int asignaturasImparte) {	
		this.codProf = codProf;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		if(codOe!=null)
			this.tutorEn = codCurso + " " + codOe;

		this.asignaturasImparte = asignaturasImparte;
	}
}
