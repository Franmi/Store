package presentacion.Controlador.Comando.imp.ComandoTurno;

import negocio.Factoria.FactoriaNegocio;
import negocio.Turno.TTurno;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoModificarTurno implements Comando {
	
	public Contexto ejecutar(Object datos) {
		TTurno tTurno = (TTurno) datos;
		int result = FactoriaNegocio.getInstance().createSATurno().updateTurno(tTurno);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_MODIFICAR_TURNO_OK, result);
		else contexto = new Contexto(Evento.RES_MODIFICAR_TURNO_KO, result);
		return contexto;
	}
}