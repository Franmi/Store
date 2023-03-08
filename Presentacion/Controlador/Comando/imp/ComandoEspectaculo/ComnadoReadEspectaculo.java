package presentacion.Controlador.Comando.imp.ComandoEspectaculo;

import negocio.Espectaculo.TEspectaculo;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComnadoReadEspectaculo implements Comando {

	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		TEspectaculo result = FactoriaNegocio.getInstance().createSAEspectaculo().read(id);
		Contexto contexto;
		if (result != null)
			contexto = new Contexto(Evento.RES_LISTAR_ESPECTACULOS_OK, result);
		else
			contexto = new Contexto(Evento.RES_LISTAR_ESPECTACULOS_KO, result);
		return contexto;
	}

}