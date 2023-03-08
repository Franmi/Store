package presentacion.Controlador.Comando.imp.ComandoEspectaculo;

import java.util.Set;

import negocio.Espectaculo.TEspectaculo;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoReadAllEspectaculo implements Comando {

	public Contexto ejecutar(Object datos) {
		Set<TEspectaculo> result = FactoriaNegocio.getInstance().createSAEspectaculo().readAll();
		Contexto contexto;
		if (!result.isEmpty())
			contexto = new Contexto(Evento.RES_LISTAR_ESPECTACULOS_OK, result);
		else
			contexto = new Contexto(Evento.RES_LISTAR_ESPECTACULOS_KO, result);
		return contexto;
	}

}