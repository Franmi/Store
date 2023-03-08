package presentacion.Controlador.Comando.imp.ComandoTurno;

import negocio.Factoria.FactoriaNegocio;
import negocio.Turno.TTurno;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.*;

public class ComandoReadTurno implements Comando {
	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		TTurno result = FactoriaNegocio.getInstance().createSATurno().readTurno(id);
		Contexto contexto;
		
		if (result != null)
			contexto = new Contexto(Evento.RES_BUSCAR_TURNO_OK, result);
		
		else contexto = new Contexto(Evento.RES_BUSCAR_TURNO_KO, result);
		
		return contexto;
	}
}