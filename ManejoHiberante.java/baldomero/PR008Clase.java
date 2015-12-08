package baldomero;

public class PR008Clase {
	private String codProf;
	private String nombre;
	private long totalAsig;
	private long totalHoras;
	private long totalCursos;
	
	public PR008Clase(){
		
	}

	public PR008Clase(String codProf, String nombre, long totalAsig, long totalHoras, long totalCursos) {
		super();
		this.codProf = codProf;
		this.nombre = nombre;
		this.totalAsig = totalAsig;
		this.totalHoras = totalHoras;
		this.totalCursos = totalCursos;
	}

	public String getCodProf() {
		return codProf;
	}

	public void setCodProf(String codProf) {
		this.codProf = codProf;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getTotalAsig() {
		return totalAsig;
	}

	public void setTotalAsig(long totalAsig) {
		this.totalAsig = totalAsig;
	}

	public long getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(long totalHoras) {
		this.totalHoras = totalHoras;
	}

	public long getTotalCursos() {
		return totalCursos;
	}

	public void setTotalCursos(long totalCursos) {
		this.totalCursos = totalCursos;
	}

	
	
}
