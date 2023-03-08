package presentacion.Controlador.Comando.imp.ComandoFactura;

import negocio.Factoria.FactoriaNegocio;
import negocio.Factura.TFactura;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoModificarFactura implements Comando {

	public Contexto ejecutar(Object datos) {
		TFactura tFactura = (TFactura) datos;
		int result = FactoriaNegocio.getInstance().createSAFactura().update(tFactura);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_MODIFICAR_FACTURA_OK, result);
		else {
			contexto = new Contexto(Evento.RES_MODIFICAR_FACTURA_KO, null);
		}
		return contexto;
	}

}
