package presentacion.Controlador.Comando.imp.ComandoTurno;

import java.util.Collection;

import negocio.Factoria.FactoriaNegocio;
import negocio.Turno.TTurno;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.*;

public class ComandoReadAllTurnos implements Comando {
	public Contexto ejecutar(Object datos) {
		Collection<TTurno> result = FactoriaNegocio.getInstance().createSATurno().readAllTurnos();
		Contexto contexto;
		
		if (!result.isEmpty())
			contexto = new Contexto(Evento.RES_LISTAR_TURNOS_OK, result);
		
		else
			contexto = new Contexto(Evento.RES_LISTAR_TURNOS_KO, result);
	
		return contexto;
	}
}