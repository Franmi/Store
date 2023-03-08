/**
 * 
 */
package negocio.EmpleadoJPA.Entidad;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

import negocio.EmpleadoJPA.TEmpleadoJPA;
import negocio.EmpleadoJPA.TTiempoCompleto;

import javax.persistence.NamedQueries;

@Entity
@DiscriminatorValue("TiempoCompleto")
@NamedQueries({
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.TiempoCompleto.findBybase", query = "select obj from TiempoCompleto obj where :base = obj.base "),
		@NamedQuery(name = "negocio.EmpleadoJPA.Entidad.TiempoCompleto.findBycomplemento", query = "select obj from TiempoCompleto obj where :complemento = obj.complemento ") })
public class TiempoCompleto extends Empleado implements Serializable {

	private static final long serialVersionUID = 0;
	
	@Column(name = "base")
	private double base;
	@Column(name = "complemento")
	private double complemento;

	@Version
	private int version;
	
	public TiempoCompleto() {

	}

	public TiempoCompleto(int id, String nomb, String apell, String DNI, boolean act, double bas, double complem){
		super(id,nomb, apell, DNI, act);
		this.base = bas;
		this.complemento = complem;
	}

	public double getBase() {return this.base;}
	public double getComplemento() {return this.complemento;}
	
	public void setBase(double base) {this.base = base;}
	public void setComplemento(double complemento) {this.complemento = complemento;}

	
	
	
	public int getHorasTrabajadas() {return 0;}
	public void setSueldo(double sueldo) {}
	public void setHorasTrabajadas(int horasTrabajadas) {}

	@Override
	public double getSueldo() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public double calcularSueldo() {
		return (int) (base + complemento);
	}

	@Override
	public TEmpleadoJPA toTransfer() {
		return new TTiempoCompleto(this.id,this.nombre,this.apellidos,this.dni,this.activo,this.base,this.complemento);
	}
}