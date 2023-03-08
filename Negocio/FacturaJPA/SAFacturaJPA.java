
package negocio.FacturaJPA;

import java.util.Collection;


public interface SAFacturaJPA {

	public int altaFactura(TFacturaConCarrito tFacturaCarrito);
	
	public int bajaFactura(int idFactura);

	public int modificarFactura(TFacturaJPA tFactura);

	public TFacturaJPA leerFactura(int idFactura);

	public Collection<TFacturaJPA> leerTodasFacturas();

	public int devolverProducto(TLineaFacturaJPA tLineaFactura);
	
	public Collection<TFacturaJPA> leerPorProducto(int idProd);
	
	public TOAFacturaProducto mostrarFacturaCompleta(int idFactura);
	
	public double calcularTotal(int idFactura);
}