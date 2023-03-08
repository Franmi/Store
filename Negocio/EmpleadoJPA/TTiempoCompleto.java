package negocio.EmpleadoJPA;

import java.io.Serializable;


public class TTiempoCompleto extends TEmpleadoJPA implements Serializable {

	private static final long serialVersionUID = 0;

	private double base;
	private double complemento;

	public TTiempoCompleto() {

	}

	public TTiempoCompleto(int id, String nomb, String apell, String DNI, boolean act, double bas, double complem){
		super(id,nomb, apell, DNI, act);
		this.base = bas;
		this.complemento = complem;
	}
	public TTiempoCompleto(String nomb, String apell, String DNI, boolean act, double bas, double complem){
		super(nomb, apell, DNI, act);
		this.base = bas;
		this.complemento = complem;
	}
	public TTiempoCompleto(int id, String nomb, String apell, boolean act, double bas, double complem){
		super(id,nomb,apell, act);
		this.base = bas;
		this.complemento = complem;
	}
	public double getBase() {return this.base;}
	public double getComplemento() {return this.complemento;}
	
	public void setBase(double base) {this.base = base;}
	public void setComplemento(double complemento) {this.complemento = complemento;}

	public int getHorasTrabajadas() { return 0; }
	public void setSueldo(double sueldo) {}
	public void setHorasTrabajadas(int horasTrabajadas) {}

	@Override
	public double getSueldo() {
		return 0;
	}

	@Override
	public String toString() {
		return super.toString()+"\n" + "Suledo Base: " + this.base + '\n' + "Complementos: " + this.complemento + '\n';
	}
}