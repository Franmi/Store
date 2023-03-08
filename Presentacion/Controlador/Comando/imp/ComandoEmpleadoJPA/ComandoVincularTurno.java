package presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA;

import negocio.Factoria.FactoriaNegocio;
import negocio.EmpleadoJPA.TTrabaja;
import negocio.EmpleadoJPA.TEmpleadoJPA;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoVincularTurno implements Comando {
	
	public Contexto ejecutar(Object datos) {
		TTrabaja t = (TTrabaja) datos;
		int result = FactoriaNegocio.getInstance().createSAEmpleadoJPA().vincularTurno(t);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_VINCULAR_TURNO_OK, result);
		else contexto = new Contexto(Evento.RES_VINCULAR_TURNO_KO, result);
		
		return contexto;
	}
}