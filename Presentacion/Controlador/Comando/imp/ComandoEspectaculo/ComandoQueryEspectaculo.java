package presentacion.Controlador.Comando.imp.ComandoEspectaculo;

import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoQueryEspectaculo implements Comando {

	@Override
	public Contexto ejecutar(Object datos) {
		int idEsp = (int) datos;
		int result = FactoriaNegocio.getInstance().createSAEspectaculo().queryEspectaculo(idEsp);

		Contexto contexto;
		if (result < 0) {
			contexto = new Contexto(Evento.RES_QUERY_ESPECTACULO_KO, "La operacion ha fallado");
		} else {
			contexto = new Contexto(Evento.RES_QUERY_ESPECTACULO_OK, result);
		}
		return contexto;

	}

}
