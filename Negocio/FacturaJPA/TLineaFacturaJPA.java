
package negocio.FacturaJPA;


public class TLineaFacturaJPA {
	
	private int idFactura;
	private int idProducto;
	private int cantidad;
	private double precio;
	private boolean activo;
	
	public TLineaFacturaJPA(int idFactura, int idProducto, int cantidad, double precio,boolean activo) {
		this.idFactura= idFactura;
		this.idProducto= idProducto;
		this.cantidad= cantidad;
		this.precio=precio;
		this.activo= activo;
	}

	public int getIdFactura() { return idFactura; }
	public void setIdFactura(int idFactura) { this.idFactura=idFactura; }
	
	public int getIdProducto() { return idProducto; }
	public void setIdProducto(int idProducto) { this.idProducto=idProducto; }
	
	public int getCantidad() { return cantidad; }
	public void setCantidad(int cantidad) { this.cantidad=cantidad; }
	
	public double getPrecio() { return precio; }
	public void setPrecio(int precio) { this.precio=precio; }

	public double getTotalLinea() { return precio*cantidad; }
	
	@Override
	public String toString(){
		return "Id Factura: "+ idFactura 
				+ "  Id Producto: "+idProducto 
				+ "  Cantidad: " + cantidad 
				+ "  precio: "+ precio  ;
		
	}
	
	public boolean isActivo(){
		return activo;
	}
}