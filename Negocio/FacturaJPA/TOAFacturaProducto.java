
package negocio.FacturaJPA;

import java.util.Map;
import java.util.Set;

import negocio.Producto.TProducto;


public class TOAFacturaProducto {

	TFacturaJPA tFactura;
	Set<TLineaFacturaJPA> lineas;
	Map<Integer,TProducto> productos;
	public TOAFacturaProducto(TFacturaJPA tFactura,Set<TLineaFacturaJPA> lineas,Map<Integer,TProducto> productos) {
		this.tFactura=tFactura;
		this.lineas=lineas;
		this.productos=productos;
	}


	public void setTFactura(TFacturaJPA tFactura) { this.tFactura=tFactura; }
	public TFacturaJPA getTFactura() { return tFactura; }


	public void setTLineaFactura(Set<TLineaFacturaJPA> lineas) { this.lineas=lineas; }
	public Set<TLineaFacturaJPA> getLineas() { return lineas; }

	public Map<Integer,TProducto> getProductos() { return productos; }
	public void setProductos(Map<Integer,TProducto> productos) { this.productos=productos; }
	
	@Override
	public String toString(){
		String separador="_________________________________________________"+ "\n";
		String encabezado="Id factura: "+tFactura.getIdFactura()+ " Fecha: "+ tFactura.getFecha() +"\n"
							+ "Id del empleado encargado: "+ tFactura.getIdEmpleado()+"\n"+separador;
		
		String cuerpo="";
		for(TLineaFacturaJPA linea: lineas){
			String nombreProducto=  productos.get(linea.getIdProducto()).getNombre();
			String codigoProducto=  productos.get(linea.getIdProducto()).getCodigo();
			
			cuerpo+= "| Id: "+linea.getIdProducto() +"| Codigo: "+codigoProducto+" | Nombre: " + nombreProducto+ " | Cantidad: "+ linea.getCantidad()
					+" | Precio: "+ linea.getPrecio() + " |  Monto: "+ linea.getTotalLinea()+ "\n"+ separador;
		}
		
		String pie= "Total: "+ tFactura.getTotal();
		
		return encabezado+cuerpo+pie;
	}

}