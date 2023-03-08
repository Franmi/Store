package negocio.Espectaculo;

public class TEspectaculo {

	private double precio;

	private boolean activo;

	private String nombre;

	private int id;

	private int entradas;
	private int idEmpleado;

	public TEspectaculo(String nombre, double precio, int entradas, int idEmpleado) {
		this.id = 0;
		this.nombre = nombre;
		this.precio = precio;
		this.entradas = entradas;
		this.activo = true;
		this.idEmpleado = idEmpleado;
	}

	public TEspectaculo(int idEspectaculo, String nombre, double precio, int entradas, int idEmpleado, boolean activo) { // FALTARIA TAMBIÉN ACTIVO??
		this.nombre = nombre;
		id = idEspectaculo;
		this.precio = precio;
		this.entradas = entradas;
		this.idEmpleado = idEmpleado;
		this.activo = activo;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public double getPrecio() {

		return this.precio;

	}

	public boolean getActivo() {

		return this.activo;

	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getId() {

		return this.id;

	}

	public void setIdEmpleado(int b) {
		this.idEmpleado = b;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {

		return this.nombre;

	}

	public int getEntradas() {

		return this.entradas;

	}

	public String toString() {
		String s = "Id del espectaculo" + id + "\n" + "Nombre del espectáculo: " + nombre + "\n Empleado asociado: "
				+ idEmpleado + "\n Precio: " + precio + "\n Entradas: " + entradas + "\n";
		return s;
	}
}