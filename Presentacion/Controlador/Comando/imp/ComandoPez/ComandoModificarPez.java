package presentacion.Controlador.Comando.imp.ComandoPez;

import negocio.Factoria.FactoriaNegocio;
import negocio.Pez.TPez;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoModificarPez implements Comando {

	public Contexto ejecutar(Object datos) {
		Contexto contexto = null;
		try {
			TPez tPez = (TPez) datos;
			int result = FactoriaNegocio.getInstance().createSAPez().update(tPez);
			if (result > 0) {
				contexto = new Contexto(Evento.RES_MODIFICAR_PEZ_OK, result);
			} else
				contexto = new Contexto(Evento.RES_MODIFICAR_PEZ_KO, "Error SQL al hacer update");
		} catch (IllegalArgumentException e) {
			contexto = new Contexto(Evento.RES_MODIFICAR_PEZ_KO, e.getMessage());
		}

		return contexto;
	}
}