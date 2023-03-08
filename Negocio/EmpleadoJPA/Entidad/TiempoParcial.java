package negocio.EmpleadoJPA.Entidad;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

import negocio.EmpleadoJPA.TEmpleadoJPA;
import negocio.EmpleadoJPA.TTiempoParcial;

import javax.persistence.NamedQueries;


@Entity
@DiscriminatorValue("TiempoParcial")
@NamedQueries({
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.TiempoParcial.findBysueldo", query = "select obj from TiempoParcial obj where :sueldo = obj.sueldo "),
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.TiempoParcial.findByhorasTrabajadas", query = "select obj from TiempoParcial obj where :horasTrabajadas = obj.horasTrabajadas ") })
public class TiempoParcial extends Empleado implements Serializable {

	private static final long serialVersionUID = 0;
	
	@Column(name = "sueldo")
	private double sueldo;
	@Column(name = "horasTrabajadas")
	private int horasTrabajadas;
	
	@Version
	private int version;
	public TiempoParcial() {

	}
	
	public TiempoParcial(int id, String nombre, String apellidos, String dni, boolean act, double sueldo, int horas){
		super(id,nombre,apellidos,dni,act);
		this.sueldo = sueldo;
		this.horasTrabajadas = horas;
	}


	public double getSueldo() {return this.sueldo;}
	public int getHorasTrabajadas() {return this.horasTrabajadas;}

	public void setSueldo(double sueldo) {this.sueldo = sueldo;}
	public void setHorasTrabajadas(int horasTrabajadas) {this.horasTrabajadas = horasTrabajadas;}


	@Override
	public double getBase() {return 0;}
	public double getComplemento() {return 0;}

	@Override
	public void setBase(double base) {}
	public void setComplemento(double complemento) {}

	@Override
	public double calcularSueldo() {
		return (int) (sueldo * horasTrabajadas);
	}
	public TEmpleadoJPA toTransfer() {
			return new TTiempoParcial(this.id,this.nombre,this.apellidos,this.dni,this.activo,this.sueldo,this.horasTrabajadas);
	}
}
