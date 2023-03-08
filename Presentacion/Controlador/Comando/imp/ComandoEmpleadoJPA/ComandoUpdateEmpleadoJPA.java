package presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA;

import negocio.EmpleadoJPA.TEmpleadoJPA;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoUpdateEmpleadoJPA implements Comando {

	public Contexto ejecutar(Object datos) {
		TEmpleadoJPA tEmpleadoJPA = (TEmpleadoJPA) datos;
		int result = FactoriaNegocio.getInstance().createSAEmpleadoJPA().updateEmpleado(tEmpleadoJPA);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_MODIFICAR_EMPLEADO_JPA_OK, result);
		else contexto = new Contexto(Evento.RES_MODIFICAR_EMPLEADO_JPA_KO, result);
		return contexto;
	}
}