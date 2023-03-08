package negocio.Pez;

public abstract class TPez {

	private int idPez;
	private String nombre;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private String genero;
	private String tipo;
	private boolean activo;

	public TPez(int idPez, String tipo, String nombre) {
		this.idPez = idPez;
		this.tipo = tipo;
		this.nombre = nombre;
		this.activo = true;
	}

	public TPez(String tipo, String nombre) {
		this.idPez = 0;
		this.tipo = tipo;
		this.nombre = nombre;
		this.activo = true;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getIdPez() {
		return idPez;
	}

	public void setIdPez(int idPez) {
		this.idPez = idPez;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return "idPez: " + idPez + "\n" + "activo: " + activo + "\n" + "nombre: " + nombre + "\n" + "tipo: " + tipo
				+ "\n";
	}
}