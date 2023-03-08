package presentacion.Controlador.Comando.imp.ComandoEspectaculo;

import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoDeleteEspectaculo implements Comando {

	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		int result = FactoriaNegocio.getInstance().createSAEspectaculo().delete(id);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_ELIMINAR_ESPECTACULO_OK, result);
		else
			contexto = new Contexto(Evento.RES_ELIMINAR_ESPECTACULO_KO, result);
		return contexto;
	}

}