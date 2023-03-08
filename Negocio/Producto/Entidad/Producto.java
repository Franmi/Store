/**
 * 
 */
package negocio.Producto.Entidad;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import java.util.Set;
import negocio.Producto.FacturaProducto;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;
import negocio.Producto.TProducto;

@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "codigo") })
@Entity
@NamedQueries({
		@NamedQuery(name = "negocio.Producto.Entidad.Producto.findByid", query = "select obj from Producto obj where :id = obj.id "),
		@NamedQuery(name = "negocio.Producto.Entidad.Producto.findByversion", query = "select obj from Producto obj where :version = obj.version "),
		@NamedQuery(name = "Producto.findBycodigo", query = "select obj from Producto obj where :codigo = obj.codigo "),
		@NamedQuery(name = "Producto.findBynombre", query = "select obj from Producto obj where :nombre = obj.nombre "),
		@NamedQuery(name = "Producto.findByprecio", query = "select obj from Producto obj where :precio = obj.precio "),
		@NamedQuery(name = "Producto.findBystock", query = "select obj from Producto obj where :stock = obj.stock "),
		@NamedQuery(name = "Producto.findByactivo", query = "select obj from Producto obj where :activo = obj.activo "),
		@NamedQuery(name = "Producto.findAll", query = "select obj from Producto obj"),
		@NamedQuery(name = "Producto.findByfacturaProducto", query = "select obj from Producto obj where :facturaProducto MEMBER OF obj.facturaProducto ") })
public class Producto implements Serializable {

	private static final long serialVersionUID = 0;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	@Version
	private int version;

	private String codigo;

	private String nombre;

	private double precio;

	private int stock;

	private boolean activo;

	@OneToMany(mappedBy = "producto")
	private Set<FacturaProducto> facturaProducto;


	public Producto() {

	}


	public Producto(int id, String codigo, String nombre, double precio, int stock, boolean activo) {
		this.id=id;
		this.codigo=codigo;
		this.nombre=nombre;
		this.precio=precio;
		this.stock=stock;
		this.activo=activo;
	}


	public Producto(TProducto p) {
		//setID(p.getID());
		setCodigo(p.getCodigo());
		setNombre(p.getNombre());
		setPrecio(p.getPrecio());
		setStock(p.getStock());
		setActivo(p.getActivo());
	}


	public int getID() {

		return this.id;

	}


	public void setID(int id) {
		this.id=id;
	}


	public String getCodigo() {
		return this.codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo=codigo;
	}


	public String getNombre() {
		return this.nombre;
	}


	public void setNombre(String nombre) {
		this.nombre=nombre;
	}


	public double getPrecio() {
		return this.precio;
	}


	public void setPrecio(double precio) {
		this.precio=precio;
	}


	public int getStock() {
		return this.stock;
	}


	public void setStock(int stock) {
		this.stock=stock;
	}


	public boolean getActivo() {
		return this.activo;
	}


	public void setActivo(boolean b) {
		this.activo=b;
	}

	public Set<FacturaProducto> getFacturaProducto(){
		return this.facturaProducto;
	}
	
	public void setFacturaProducto(Set<FacturaProducto> Sp){
		this.facturaProducto=Sp;
	}
	public TProducto toTransfer() {
		return new TProducto(getID(),getCodigo(),getNombre(),getPrecio(),getStock(),getActivo());
	}
}