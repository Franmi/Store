package negocio.Factura;

public class TLineaFactura {

	private int idFactura;
	private int idEspectaculo;
	private int numeroEntradas;

	private double precio;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private TOAFacturaEspectaculo tOAFacturaEspectaculo;

	public TLineaFactura(int idFactura, int idEspectaculo, int numeroEntradas, double precio) {
		this.idFactura = idFactura;
		this.idEspectaculo = idEspectaculo;
		this.numeroEntradas = numeroEntradas;
		this.precio = precio;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdEspectaculo(int idEspectaculo) {
		this.idEspectaculo = idEspectaculo;
	}

	public int getIdEspectaculo() {
		return idEspectaculo;
	}

	public void setNumeroEntradas(int numeroEntradas) {
		this.numeroEntradas = numeroEntradas;
	}

	public int getNumeroEntradas() {
		return numeroEntradas;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public String toString() {
		return "Espectáculo: " + this.idEspectaculo + '\n' + "Cantidad: " + this.numeroEntradas + '\n' + "Precio: "
				+ this.precio + '\n';
	}
}