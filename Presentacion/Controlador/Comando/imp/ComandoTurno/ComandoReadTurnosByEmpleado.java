package presentacion.Controlador.Comando.imp.ComandoTurno;

import java.util.Collection;

import negocio.Factoria.FactoriaNegocio;
import negocio.Turno.TTurno;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.*;

public class ComandoReadTurnosByEmpleado implements Comando {
	public Contexto ejecutar(Object datos) {
		int idEmpleado = (int) datos;
		Collection<TTurno> result = FactoriaNegocio.getInstance().createSATurno().readTurnosByEmpleado(idEmpleado);		
		Contexto contexto;
		
		if (!result.isEmpty())
			contexto = new Contexto(Evento.RES_MOSTRAR_TURNOS_EMPLEADO_OK, result);
		
		else contexto = new Contexto(Evento.RES_MOSTRAR_TURNOS_EMPLEADO_KO, result);
		
		return contexto;
	}
}