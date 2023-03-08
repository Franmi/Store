package presentacion.Controlador.Comando.imp.ComandoFacturaJPA;

import java.util.Collection;

import negocio.Factoria.FactoriaNegocio;
import negocio.FacturaJPA.TFacturaJPA;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoListarFacturaJPA implements Comando{

	@Override
	public Contexto ejecutar(Object datos) {
		Collection<TFacturaJPA> result = FactoriaNegocio.getInstance().createSAFacturaJPA().leerTodasFacturas();
		Contexto contexto;
		
		if(result != null && !result.isEmpty()) {
			contexto = new Contexto(Evento.RES_LISTAR_FACTURAS_JPA_OK, result);
		} else {
			contexto = new Contexto(Evento.RES_LISTAR_FACTURAS_JPA_KO, "No se pudo completar la búsqueda, o bien no hay facturas");
		}
		return contexto;
	}

}
