package presentacion.Controlador.Comando.imp.ComandoProducto;

import negocio.Producto.TProducto;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoUpdateProducto implements Comando {

	public Contexto ejecutar(Object datos) {
		TProducto tProducto = (TProducto) datos;
		int result = FactoriaNegocio.getInstance().createSAProducto().modificarProducto(tProducto);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_MODIFICAR_PRODUCTO_OK, result);
		else
			contexto = new Contexto(Evento.RES_MODIFICAR_PRODUCTO_KO, result);
		return contexto;
	}
}