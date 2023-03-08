
package negocio.FacturaJPA.Entidad;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import negocio.EmpleadoJPA.Entidad.Empleado;
import javax.persistence.ManyToOne;
import java.util.Set;
import negocio.Producto.FacturaProducto;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import negocio.FacturaJPA.TFacturaJPA;

@Entity
@NamedQueries({
		@NamedQuery(name = "Factura.findByid", query = "select obj from Factura obj where :id = obj.id "),
		@NamedQuery(name = "Factura.findByfecha", query = "select obj from Factura obj where :fecha = obj.fecha "),
		@NamedQuery(name = "Factura.findBytotal", query = "select obj from Factura obj where :total = obj.total "),
		@NamedQuery(name = "Factura.findByactivo", query = "select obj from Factura obj where :activo = obj.activo "),
		@NamedQuery(name = "Factura.findByversion", query = "select obj from Factura obj where :version = obj.version "),
		@NamedQuery(name = "Factura.findByempleado", query = "select obj from Factura obj where :empleado = obj.empleado "),
		@NamedQuery(name = "Factura.findByfacturaProducto2", query = "select obj from Factura obj where :facturaProducto2 MEMBER OF obj.facturaProducto2 "),
		@NamedQuery(name = "Factura.findAll", query = "select obj from Factura obj") })
public class Factura implements Serializable {

	private static final long serialVersionUID = 0;

	@GeneratedValue
	@Id
	private Integer id;
	private String fecha;
	private double total;
	private boolean activo;
	@Version
	private int version;
	
	@ManyToOne
	private Empleado empleado;
	
	@OneToMany(mappedBy = "factura")
	private Set<FacturaProducto> facturaProducto2;

	public Factura() {
		
	}
	public Factura(Empleado empleado,String fecha) {
		this.empleado=empleado;
		this.fecha=fecha;
		this.activo=true;
	}

	public Factura(Empleado empleado, String fecha, boolean activo) {
		this.empleado=empleado;
		this.fecha=fecha;
		this.activo=activo;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id=id; }

	public Empleado getEmpleado() { return empleado; }
	public void setEmpleado(Empleado empleado) { this.empleado=empleado;} 

	public String getFecha() { return fecha;}
	public void setFecha(String fecha) { this.fecha=fecha; }

	public boolean getActivo() { return activo; }
	public void setActivo(boolean activo) { this.activo=activo; }
	
	public double getTotal() { return total; }
	
	public void setTotal(double total) {this.total = total;}
	
	public Set<FacturaProducto> getLineas() { return facturaProducto2;}

	public TFacturaJPA toTransfer() {
		return new TFacturaJPA(id,empleado.getID(), total, fecha, activo);

	}
}