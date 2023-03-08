/**
 * 
 */
package presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA;
import negocio.Factoria.FactoriaNegocio;
import negocio.EmpleadoJPA.TTrabaja;
import negocio.EmpleadoJPA.TEmpleadoJPA;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoDesvincularTurno implements Comando {
	
	public Contexto ejecutar(Object datos) {
		TTrabaja t = (TTrabaja) datos;
		int result = FactoriaNegocio.getInstance().createSAEmpleadoJPA().desvincularTurno(t);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_DESVINCULAR_TURNO_OK, result);
		else contexto = new Contexto(Evento.RES_DESVINCULAR_TURNO_KO, result);
		
		return contexto;
	}
}