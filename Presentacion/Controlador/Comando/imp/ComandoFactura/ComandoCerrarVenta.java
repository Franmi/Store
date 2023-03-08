package presentacion.Controlador.Comando.imp.ComandoFactura;

import negocio.Factoria.FactoriaNegocio;
import negocio.Factura.TOAFacturaEspectaculo;
import negocio.FacturaJPA.TFacturaConCarrito;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoCerrarVenta implements Comando {

	public Contexto ejecutar(Object datos) {
		TFacturaConCarrito tFacturaCarrito = (TFacturaConCarrito) datos;
		int result = FactoriaNegocio.getInstance().createSAFacturaJPA()
				.altaFactura(tFacturaCarrito);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_ALTA_FACTURA_JPA_OK, result);
		else {
			if (result == -1)
				contexto = new Contexto(Evento.RES_ALTA_FACTURA_JPA_KO, "No se ha podido generar la factura");
			else
				contexto = new Contexto(Evento.RES_ALTA_FACTURA_JPA_KO, "Las entradas del espectáculo se han agotado");
		}
		return contexto;
	}
}