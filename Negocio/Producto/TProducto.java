/**
 * 
 */
package negocio.Producto;


public class TProducto {

	private int id;

	private String codigo;

	private String nombre;

	private double precio;

	private int stock;

	private boolean activo;


	public TProducto(String codigo,String name,double precio,int stock) {
		this.codigo=codigo;
		this.nombre=name;
		this.precio=precio;
		this.stock=stock;
		this.id=0;
		this.activo=true;
	}

	public TProducto(int id,String codigo,String name,double precio,int stock,boolean activo) {
		this.codigo=codigo;
		this.nombre=name;
		this.precio=precio;
		this.stock=stock;
		this.id=id;
		this.activo=activo;
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


	public void setCodigo(String c) {
		this.codigo=c;
	}


	public double getPrecio() {
		return this.precio;
	}


	public void setPrecio(double p) {
		this.precio=p;
	}


	public String getNombre() {
		return this.nombre;
	}


	public void setNombre(String name) {
		this.nombre=name;
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
	public String toString(){
		return "ID: "+this.id+'\n'+"Codigo: "+this.codigo+'\n'+"Nombre del producto: "+this.nombre+'\n'+"Precio: "+this.precio+'\n'+"Stock: "+this.stock+'\n'+"Activo: "+this.activo+'\n';

	}
}