package presentacion.Controlador.Comando.imp.ComandoEspectaculo;

import negocio.Espectaculo.TEspectaculo;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoCreateEspectaculo implements Comando {

	public Contexto ejecutar(Object datos) {
		TEspectaculo tEspectaculo = (TEspectaculo) datos;
		int result = FactoriaNegocio.getInstance().createSAEspectaculo().create(tEspectaculo);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_ALTA_ESPECTACULO_OK, result);
		else
			contexto = new Contexto(Evento.RES_ALTA_ESPECTACULO_KO, result);
		return contexto;
	}

}