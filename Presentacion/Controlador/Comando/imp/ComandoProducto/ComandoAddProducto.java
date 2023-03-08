/**
 * 
 */
package presentacion.Controlador.Comando.imp.ComandoProducto;

import negocio.Factoria.FactoriaNegocio;
import negocio.Producto.TProducto;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;


public class ComandoAddProducto implements Comando {

	public Contexto ejecutar(Object datos) {
	
		TProducto pro=(TProducto) datos;
		int exito=FactoriaNegocio.getInstance().createSAProducto().createProducto(pro);
		Contexto contexto;
		if(exito>0){
			contexto = new Contexto(Evento.RES_ALTA_PRODUCTO_OK,exito);
		}
		else{
			contexto=new Contexto(Evento.RES_ALTA_PRODUCTO_KO,exito);
		}
		return contexto;

	}
}