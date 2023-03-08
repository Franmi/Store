
package negocio.FacturaJPA;

public class TFacturaJPA {

	private int idFactura;
	private int idEmpleado;
	private String fecha;
	private double total;
	private boolean activo;
	
	
	public TFacturaJPA(int idEmpleado, String fecha) {
		this.idEmpleado=idEmpleado;
		this.fecha=fecha;
		total=0;
		activo=true;
	}
	
	public TFacturaJPA(int idFactura,int idEmpleado,double total, String fecha) {
		this.idFactura=idFactura;
		this.idEmpleado=idEmpleado;
		this.fecha=fecha;
		this.total=total;
		activo=true;
	}

	public TFacturaJPA(int idFactura,int idEmpleado, String fecha, boolean activo) {
		this.idFactura=idFactura;
		this.idEmpleado=idEmpleado;
		this.fecha=fecha;
		total=0;
		activo=false;
	}
	
	public TFacturaJPA(int idFactura,int idEmpleado,double total, String fecha, boolean activo) {
		this.idFactura=idFactura;
		this.idEmpleado=idEmpleado;
		this.fecha=fecha;
		this.total=total;
		this.activo=activo;
	}
	
	public int getIdFactura() { return idFactura; }
	public void setIdFactura(int idFactura) { this.idFactura=idFactura; }

	public int getIdEmpleado() { return idEmpleado; }
	public void setIdEmpleado(int idEmpleado) { this.idEmpleado=idEmpleado; }


	public String getFecha() { return fecha; }
	public void setFecha(String fecha) { this.fecha=fecha; }

	public double getTotal() { return total; }
	public void setTotal(double total) { this.total=total; }
	
	public boolean getActivo() { return activo; }
	public void setActivo(boolean activo) { this.activo=activo; }
	
	
	@Override
	public String toString(){
		return "Id Factura: "+ idFactura +" Id Empleado: " + idEmpleado + "\n"
				+"Fecha: "+ fecha +"\n"
				+"Total: "+total +"\n"
				+"Activo: "+ activo + "\n";
	}
	
	
}