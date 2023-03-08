package negocio.Producto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import java.io.Serializable;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import javax.persistence.NamedQueries;
import negocio.Producto.Entidad.Producto;

import javax.persistence.ManyToOne;

import negocio.FacturaJPA.Entidad.Factura;
import negocio.FacturaJPA.TLineaFacturaJPA;

@Entity
@IdClass(FacturaProductoID.class)
@NamedQueries({
		@NamedQuery(name = "negocio.Producto.FacturaProducto.findByversion", query = "select obj from FacturaProducto obj where :version = obj.version "),
		@NamedQuery(name = "negocio.Producto.FacturaProducto.findByprecio", query = "select obj from FacturaProducto obj where :precio = obj.precio "),
		@NamedQuery(name = "negocio.Producto.FacturaProducto.findBycantidad", query = "select obj from FacturaProducto obj where :cantidad = obj.cantidad "),
		@NamedQuery(name = "negocio.Producto.FacturaProducto.findByactivo", query = "select obj from FacturaProducto obj where :activo = obj.activo "),
		@NamedQuery(name = "FacturaProducto.findByproducto", query = "select obj from FacturaProducto obj where :producto = obj.producto "),
		@NamedQuery(name = "FacturaProducto.findByfactura", query = "select obj from FacturaProducto obj where :factura = obj.factura ") })
public class FacturaProducto implements Serializable {

	private static final long serialVersionUID = 0;

	@Id
	@ManyToOne
	private Producto producto;

	@Id
	@ManyToOne
	private Factura factura;

	@Version
	private int version;
	private int cantidad;
	
	private double precio;


	private boolean activo;


	public FacturaProducto() {

	}

	public FacturaProducto(TLineaFacturaJPA lf){
		this.cantidad=lf.getCantidad();
		this.activo=lf.isActivo();
	}

	public FacturaProducto(double precio,int cantidad,boolean activo,Producto p,Factura f){
		this.precio=precio;
		this.cantidad=cantidad;
		this.precio=precio;
		producto=p;
		factura=f;
		this.activo=activo;
	}
	
	public int getCantidad(){
		return this.cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}

	public Producto getProducto(){
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto=producto;
	}
	
	public Factura getFactura() {
		return factura;
	}
	
	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public double getPrecio(){
		return this.precio;
	}
	
	public void setPrecio(double precio) {
		this.precio=precio;
	}

	public boolean geActivo(){
		return this.activo;
	}
	public void setActivo(boolean activo){
		this.activo=activo;
	}
	
	public TLineaFacturaJPA toTransfer() {

		return new TLineaFacturaJPA(factura.getId(),producto.getID(), this.cantidad,this.precio,this.activo);

	}
}