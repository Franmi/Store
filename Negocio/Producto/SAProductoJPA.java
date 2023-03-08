/**
 * 
 */
package negocio.Producto;

import java.util.Set;

public interface SAProductoJPA {

	public int eliminarProducto(int idProducto);

	public int createProducto(TProducto TProducto);

	public TProducto readProducto(int id);

	public Set<TProducto> readAllProducto();

	public int modificarProducto(TProducto TProducto);
	
}