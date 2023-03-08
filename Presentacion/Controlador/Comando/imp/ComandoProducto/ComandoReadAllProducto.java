/**
 * 
 */
package presentacion.Controlador.Comando.imp.ComandoProducto;

import java.util.Set;

import negocio.Factoria.FactoriaNegocio;
import negocio.Producto.TProducto;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;


public class ComandoReadAllProducto implements Comando {

	public Contexto ejecutar(Object datos) {

		Set<TProducto> prod=FactoriaNegocio.getInstance().createSAProducto().readAllProducto();
		Contexto contexto;
		if(!prod.isEmpty()){
			contexto=new Contexto(Evento.RES_LISTAR_PRODUCTO_OK,prod);
		}
		else{
			contexto=new Contexto(Evento.RES_LISTAR_PRODUCTO_KO,prod);
		}
		
		return contexto;

	}
}