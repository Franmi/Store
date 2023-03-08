package presentacion.Controlador.Comando.imp.ComandoFactura;

import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoEliminarFactura implements Comando {

	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		int result = FactoriaNegocio.getInstance().createSAFactura().delete(id);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_ELIMINAR_FACTURA_OK, result);
		else
			contexto = new Contexto(Evento.RES_ELIMINAR_FACTURA_KO, result);
		return contexto;
	}
}