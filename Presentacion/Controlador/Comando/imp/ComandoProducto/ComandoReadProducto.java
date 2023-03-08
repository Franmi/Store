package presentacion.Controlador.Comando.imp.ComandoProducto;

import negocio.Factoria.FactoriaNegocio;
import negocio.Producto.TProducto;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;


public class ComandoReadProducto implements Comando {

	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		TProducto result = FactoriaNegocio.getInstance().createSAProducto().readProducto(id);
		Contexto contexto;
		if (result != null)
			contexto = new Contexto(Evento.RES_BUSCAR_PRODUCTO_OK, result);
		else
			contexto = new Contexto(Evento.RES_BUSCAR_PRODUCTO_KO, result);
		return contexto;
	}
}