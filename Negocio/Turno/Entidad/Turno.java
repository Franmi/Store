package negocio.Turno.Entidad;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.persistence.NamedQueries;

import java.util.Set;
import negocio.EmpleadoJPA.Entidad.Empleado;
import javax.persistence.ManyToMany;
import negocio.Turno.TTurno;

@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "nombre") })
@Entity
@NamedQueries({
		@NamedQuery(name = "Turno.findByid", query = "select obj from Turno obj where :id = obj.id "),
		@NamedQuery(name = "Turno.findByversion", query = "select obj from Turno obj where :version = obj.version "),
		@NamedQuery(name = "Turno.findBynombre", query = "select obj from Turno obj where :nombre = obj.nombre "),
		@NamedQuery(name = "Turno.findBycomienzo", query = "select obj from Turno obj where :comienzo = obj.comienzo "),
		@NamedQuery(name = "Turno.findByfin", query = "select obj from Turno obj where :fin = obj.fin "),
		@NamedQuery(name = "Turno.findByactivo", query = "select obj from Turno obj where :activo = obj.activo "),
		@NamedQuery(name = "Turno.findByempleado", query = "select obj from Turno obj where :empleado MEMBER OF obj.empleado "),
		@NamedQuery(name = "Turno.findAll", query = "select obj from Turno obj where obj.activo = 1") })

public class Turno implements Serializable {

	private static final long serialVersionUID = 0;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

	@Version
	private int version;

	private String nombre;
	private String comienzo;
	private String fin;

	private boolean activo;

	@ManyToMany(mappedBy = "turno")
	private Set<Empleado> empleado;

	public Turno() {}
	
	public Turno(int id, String nombre, String comienzo, String fin, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.comienzo = comienzo;
		this.fin = fin;
		this.activo = activo;
	}
	
	public Turno(String nombre, String comienzo, String fin, boolean activo) {
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
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public int getVersion() {
		return version;
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
	
	public void setEmpleados(Set<Empleado> empleado) {
		this.empleado = empleado;
	}
	
	public Set<Empleado> getEmpleados() {
		return empleado;
	}
	
	public TTurno toTransfer() {
		return new TTurno(id, nombre, comienzo, fin, activo);
	}
	
}