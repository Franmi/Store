package presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA;

import negocio.Factoria.FactoriaNegocio;
import negocio.EmpleadoJPA.TEmpleadoJPA;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoAddEmpleadoJPA implements Comando {

	public Contexto ejecutar(Object datos) {

		TEmpleadoJPA tEmpleadoJPA = (TEmpleadoJPA) datos;
		int result = FactoriaNegocio.getInstance().createSAEmpleadoJPA().createEmpleado(tEmpleadoJPA);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_ALTA_EMPLEADO_JPA_OK, result);
		else contexto = new Contexto(Evento.RES_ALTA_EMPLEADO_JPA_KO, "Ese Empleado ya existe");
		return contexto;
	}
}