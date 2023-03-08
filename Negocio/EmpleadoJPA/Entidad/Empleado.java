package negocio.EmpleadoJPA.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import java.util.Set;
import negocio.FacturaJPA.Entidad.Factura;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import negocio.Turno.Entidad.Turno;
import javax.persistence.ManyToMany;
import negocio.EmpleadoJPA.TEmpleadoJPA;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;

@Inheritance(strategy=InheritanceType.JOINED)
@Entity
@NamedQueries({
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.Empleado.findByid", query = "select obj from Empleado obj where :id = obj.id "),
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.Empleado.findBydni", query = "select obj from Empleado obj where :dni = obj.dni "),
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.Empleado.findBynombre", query = "select obj from Empleado obj where :nombre = obj.nombre "),
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.Empleado.findByapellidos", query = "select obj from Empleado obj where :apellidos = obj.apellidos "),
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.Empleado.findByfactura", query = "select obj from Empleado obj where :factura MEMBER OF obj.factura "),
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.Empleado.findByturno", query = "select obj from Empleado obj where :turno MEMBER OF obj.turno "),
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.Empleado.findByactivo", query = "select obj from Empleado obj where :activo = obj.activo "),
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.Empleado.findAll", query = "select obj from Empleado obj "),
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.Empleado.mostrarListaEmpleados", query = "select obj from Empleado obj where obj.activo = 1") })

public abstract class Empleado implements Serializable {

	private static final long serialVersionUID = 0;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;
	
	protected String dni;
	
	protected String nombre;
	
	protected String apellidos;
	
	protected boolean activo;

	@Version
	private int version;

	public Empleado(int id, String nomb, String apell, String DNI, boolean act){
		this.id = id;
		this.nombre = nomb;
		this.apellidos = apell;
		this.dni = DNI;
		this.activo = act;
	}
	
	
	
	public Empleado() {
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
	
	
	// OTROS
	@OneToMany(mappedBy = "empleado")
	private Set<Factura> factura;
	@ManyToMany
	private Set<Turno> turno;
	
	
	
	public void setTurnos(Set<Turno> turno) {
		this.turno = turno;
	}
	
	public Set<Turno> getTurnos() {
		return turno;
	}
	
	public abstract double calcularSueldo();
	//public abstract TEmpleadoJPA toTransfer();
	//public TEmpleadoJPA toTransfer()



	public TEmpleadoJPA toTransfer() {
		// TODO Auto-generated method stub
		return null;
	}

}