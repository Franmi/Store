package negocio.EmpleadoJPA;

import java.io.Serializable;



public class TTiempoParcial extends TEmpleadoJPA implements Serializable {

	private static final long serialVersionUID = 0;
	private double sueldo;
	private int horasTrabajadas;

	public TTiempoParcial() {

	}
	
	public TTiempoParcial(int id, String nombre, String apellidos, String dni, boolean act, double sueldo, int horas){
		super(id,nombre,apellidos,dni,act);
		this.sueldo = sueldo;
		this.horasTrabajadas = horas;
	}
	public TTiempoParcial(String nombre, String apellidos, String dni, boolean act, double sueldo, int horas){
		super(nombre,apellidos,dni,act);
		this.sueldo = sueldo;
		this.horasTrabajadas = horas;
	}
	public TTiempoParcial(int id, String nombre, String apellidos, boolean act, double sueldo, int horas){
		super(id,nombre,apellidos,act);
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
	public String toString() {
		return super.toString()+"\n" + "Suledo: " + this.sueldo + '\n' + "Horas Trabajadas: " + this.horasTrabajadas + '\n';
	}
}