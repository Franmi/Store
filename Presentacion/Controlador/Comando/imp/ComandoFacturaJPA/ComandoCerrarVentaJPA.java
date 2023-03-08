
package presentacion.Controlador.Comando.imp.ComandoFacturaJPA;

import negocio.Factoria.FactoriaNegocio;
import negocio.FacturaJPA.TFacturaConCarrito;
import negocio.FacturaJPA.TFacturaJPA;
import negocio.Pez.TPez;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;


public class ComandoCerrarVentaJPA implements Comando {

	public Contexto ejecutar(Object datos) {
		
		TFacturaConCarrito tFacturaCarrito = (TFacturaConCarrito) datos;
		int result = FactoriaNegocio.getInstance().createSAFacturaJPA().altaFactura(tFacturaCarrito);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_ALTA_FACTURA_JPA_OK, result);
		else {
			if (result == -1)
				contexto = new Contexto(Evento.RES_ALTA_FACTURA_JPA_KO, "No se ha podido generar la factura(producto o empleado inexistente)");
			else if(result == -2)
				contexto = new Contexto(Evento.RES_ALTA_FACTURA_JPA_KO, "No se ha podido comprar ningun producto (agotados o inactivos)");
			else contexto = new Contexto(Evento.RES_ALTA_FACTURA_JPA_KO, "No se ha podido generar la factura, pruebe en otro momento");
		}
		return contexto;
	}
}