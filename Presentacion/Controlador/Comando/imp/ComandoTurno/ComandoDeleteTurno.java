package presentacion.Controlador.Comando.imp.ComandoTurno;

import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.*;

public class ComandoDeleteTurno implements Comando {
	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		int result = FactoriaNegocio.getInstance().createSATurno().deleteTurno(id);
		Contexto contexto;
		
		if (result >= 0)
			contexto = new Contexto(Evento.RES_ELIMINAR_TURNO_OK, result);
		
		else contexto = new Contexto(Evento.RES_ELIMINAR_TURNO_KO, result);
		
		return contexto;
	}
}