package negocio.Turno;

public class TTurno {
	
	private int id;
	
	private String nombre;
	private String comienzo;
	private String fin;
	
	private boolean activo;
	
	public TTurno(String nombre, String comienzo, String fin) {
		this.id = 0;
		this.nombre = nombre;
		this.comienzo = comienzo;
		this.fin = fin;
		activo = true;
	}

	public TTurno(int id, String nombre, String comienzo, String fin, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.comienzo = comienzo;
		this.fin = fin;
		this.activo = activo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setComienzo(String comienzo) {
		this.comienzo = comienzo;
	}
	
	public String getComienzo() {
		return comienzo;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getFin() {
		return fin;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public String toString() {
		return "Id: " + id + '\n' + "Nombre: " + nombre + '\n' + "Comienzo: " + comienzo + '\n'
				+ "Fin: " + fin + '\n' + "Activo: " + activo + '\n' + '\n';
	}
}