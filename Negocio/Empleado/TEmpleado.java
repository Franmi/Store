/**
 * 
 */
package negocio.Empleado;

public class TEmpleado {

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private int id;
	private int Id;
	private String DNI;
	private String telefono;
	private String correo;
	private String nombre;
	private String apellidos;
	private boolean activo;

	public TEmpleado(int id, String nombre, String apellidos, String dni, String telefono, String correo,
			boolean activo) {
		this.Id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = dni;
		this.telefono = telefono;
		this.correo = correo;
		this.activo = activo;
	}

	public TEmpleado(String nombre, String apellidos, String dni, String telefono, String correo, boolean activo) {
		this.Id = 0;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = dni;
		this.telefono = telefono;
		this.correo = correo;
		this.activo = activo;
	}

	public TEmpleado(int id, String nombre, String apellidos, String dni, String telefono, String correo) {
		this.Id = 0;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = dni;
		this.telefono = telefono;
		this.correo = correo;
		this.activo = true;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param nombre
	* @param apellidos
	* @param dni
	* @param telefono
	* @param correo
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TEmpleado(String nombre, String apellidos, String dni, String telefono, String correo) {
		// begin-user-code
		// TODO Auto-generated constructor stub
		// end-user-code
	}

	public TEmpleado() {
	}

	public int getId() {
		return Id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getdni() {
		return DNI;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public boolean getActivo() {
		return activo;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param activo
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setActivo(Boolean activo) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void setId(int id) {
		Id = id;
	}

	public void setdni(String dni) {
		DNI = dni;
	}

	public void setTelefono(String tfno) {
		telefono = tfno;
	}

	public void setCorreo(String corr) {
		correo = corr;
	}

	public void setNombre(String nom) {
		nombre = nom;
	}

	public void setApellidos(String apellid) {
		apellidos = apellid;
	}

	public void setActivo(boolean activ) {
		activo = activ;
	}

	public String toString() {
		return "Id: " + this.Id + '\n' + "Nombre: " + this.nombre + '\n' + "Apellidos: " + this.apellidos + '\n'
				+ "DNI: " + this.DNI + '\n' + "Telefono: " + this.telefono + '\n' + "Correo: " + this.correo + '\n'
				+ "Activo: " + this.activo + '\n' + '\n';
	}
}