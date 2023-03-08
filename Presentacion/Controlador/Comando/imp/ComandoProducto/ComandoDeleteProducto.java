/**
 * 
 */
package presentacion.Controlador.Comando.imp.ComandoProducto;

import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;


public class ComandoDeleteProducto implements Comando {

	public Contexto ejecutar(Object datos) {

		int id=(int) datos;
		int result = FactoriaNegocio.getInstance().createSAProducto().eliminarProducto(id);
		Contexto contexto;
		if(result>0){
			contexto=new Contexto(Evento.RES_ELIMINAR_PRODUCTO_OK,result);
		}
		else{
			contexto=new Contexto(Evento.RES_ELIMINAR_PRODUCTO_KO,result);
		}
		return contexto;
	}
}