package presentacion.Controlador.Comando.imp.ComandoFactura;

import presentacion.Controlador.Comando.Contexto;
import negocio.Factoria.FactoriaNegocio;
import negocio.Factura.TFactura;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;

public class ComandoBuscarFactura implements Comando {

	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		TFactura result = FactoriaNegocio.getInstance().createSAFactura().read(id);
		Contexto contexto;
		if (result != null)
			contexto = new Contexto(Evento.RES_MOSTRAR_FACTURA_OK, result);
		else
			contexto = new Contexto(Evento.RES_MOSTRAR_FACTURA_KO, result);
		return contexto;
	}
}