package negocio.Producto;

import java.io.Serializable;

import negocio.FacturaJPA.TLineaFacturaJPA;

public class FacturaProductoID implements Serializable {
	
	private static final long serialVersionUID = 0;

	private int producto;
	private int factura;

	public FacturaProductoID() {}

	public FacturaProductoID(int idP, int idF) {
		this.producto=idP;
		this.factura=idF;
	}
	
	/* lineaFactura ya no usa idProducto sino el codigo de producto
	public FacturaProductoID(TLineaFacturaJPA lf){
		this.producto=lf.getIdProducto();
		this.factura=lf.getIdFactura();
	}*/

	public int getIdFactura(){
		return factura;
	}
	
	public int getIdProducto(){
		return producto;
	}

	public void setIdProducto(int idProducto) {
		this.producto = idProducto;
	}

	public void setIdFactura(int idFactura) {
		this.factura = idFactura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + factura;
		result = prime * result + producto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacturaProductoID other = (FacturaProductoID) obj;
		if (factura != other.factura)
			return false;
		if (producto != other.producto)
			return false;
		return true;
	}

}