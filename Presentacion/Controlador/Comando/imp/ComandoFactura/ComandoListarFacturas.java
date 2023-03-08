package presentacion.Controlador.Comando.imp.ComandoFactura;

import java.util.Collection;

import negocio.Factoria.FactoriaNegocio;
import negocio.Factura.TFactura;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoListarFacturas implements Comando {

	public Contexto ejecutar(Object datos) {
		Collection<TFactura> result = FactoriaNegocio.getInstance().createSAFactura().readAll();
		Contexto contexto;
		if (!result.isEmpty())
			contexto = new Contexto(Evento.RES_LISTAR_FACTURAS_OK, result);
		else
			contexto = new Contexto(Evento.RES_LISTAR_FACTURAS_KO, result);
		return contexto;
	}
}