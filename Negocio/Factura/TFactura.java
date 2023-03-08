package negocio.Factura;

public class TFactura {

	private int id;
	private int numeroEspectaculos;

	private String DNICliente;
	private String fecha;

	private double total;

	private boolean activo;
	
	public TFactura(int id, String DNICliente, String fecha, double total, int numeroEspectaculos) {
		this.id = id;
		this.DNICliente = DNICliente;
		this.fecha = fecha;
		this.total = total;
		this.numeroEspectaculos = numeroEspectaculos;
		activo = true;
	}

	public TFactura(String DNICliente, String fecha, double total, int numeroEspectaculos) {
		this.DNICliente = DNICliente;
		this.fecha = fecha;
		this.total = total;
		this.numeroEspectaculos = numeroEspectaculos;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setDNICliente(String DNICliente) {
		this.DNICliente = DNICliente;
	}

	public String getDNICliente() {
		return DNICliente;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFecha() {
		return fecha;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public void setNumeroEspectaculos(int numeroEspectaculos) {
		this.numeroEspectaculos = numeroEspectaculos;
	}

	public int getNumeroEspectaculos() {
		return numeroEspectaculos;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean getActivo() {
		return activo;
	}

	public String toString() {
		return "Id: " + this.id + '\n' + "Cliente: " + this.DNICliente + '\n' + "Fecha: " + this.fecha + '\n'
				+ "Número de espectáculos: " + this.numeroEspectaculos + '\n' + "Importe total: " + this.total + '\n';
	}
}