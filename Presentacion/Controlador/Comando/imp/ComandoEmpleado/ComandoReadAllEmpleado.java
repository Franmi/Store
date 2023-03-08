package presentacion.Controlador.Comando.imp.ComandoEmpleado;

import java.util.Set;

import negocio.Empleado.TEmpleado;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoReadAllEmpleado implements Comando {

	public Contexto ejecutar(Object datos) {
		
		Set<TEmpleado> result = FactoriaNegocio.getInstance().createSAEmpleado().readAllEmpleados();
		Contexto contexto;
		if (!result.isEmpty())
			contexto = new Contexto(Evento.RES_LISTAR_EMPLEADOS_OK, result);
		else
			contexto = new Contexto(Evento.RES_LISTAR_EMPLEADOS_KO, result);
		return contexto;
	}

}