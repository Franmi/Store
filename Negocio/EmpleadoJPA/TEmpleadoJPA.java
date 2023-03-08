package negocio.EmpleadoJPA;

import java.io.Serializable;

public abstract class TEmpleadoJPA implements Serializable {

	private static final long serialVersionUID = 0;
	
	
	private int id;
	private String dni;
	private String nombre;
	private String apellidos;
	private boolean activo;

	
	public TEmpleadoJPA(int id, String nomb, String apell, String DNI, boolean act){
		this.id = id;
		this.nombre = nomb;
		this.apellidos = apell;
		this.dni = DNI;
		this.activo = act;
	}
	public TEmpleadoJPA(String nomb, String apell, String DNI, boolean act){
		this.nombre = nomb;
		this.apellidos = apell;
		this.dni = DNI;
		this.activo = act;
	}
	public TEmpleadoJPA(int id, String nomb, String apell, boolean act){
		this.nombre = nomb;
		this.apellidos = apell;
		this.activo = act;
	}
	
	public TEmpleadoJPA() {
		// TODO Auto-generated constructor stub
	}




	public int getID() {return this.id;}
	public String getNombre() {return this.nombre;}
	public String getApellidos() {return this.apellidos;}
	public String getDni() {return this.dni;}
	public boolean getActivo() {return this.activo;}
	
	public void setID(int ID) {this.id = ID;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setApellidos(String apellidos) {this.apellidos = apellidos;}
	public void setDni(String DNI) {this.dni = DNI;}
	public void setActivo(boolean activo) {this.activo = activo;}

	
	
	public abstract double getSueldo();
	public abstract void setSueldo(double sueldo);
	
	public abstract double getBase();
	public abstract void setBase(double base);
	
	public abstract int getHorasTrabajadas();
	public abstract void setHorasTrabajadas(int horasTrabajadas);
	
	public abstract double getComplemento();
	public abstract void setComplemento(double complemento);
	
	public String toString(){
		return "Id: " + this.id + '\n' + "Nombre: " + this.nombre + '\n' + "Apellido: " + this.apellidos + '\n'
				+ "DNI: " + this.dni + '\n' + "Activo: " + this.activo + '\n';
	}
}