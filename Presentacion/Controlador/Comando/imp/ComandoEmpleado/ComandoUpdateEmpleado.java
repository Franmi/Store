package presentacion.Controlador.Comando.imp.ComandoEmpleado;

import negocio.Empleado.TEmpleado;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoUpdateEmpleado implements Comando {

	public Contexto ejecutar(Object datos) {

		TEmpleado tEmpleado = (TEmpleado) datos;
		int result = FactoriaNegocio.getInstance().createSAEmpleado().updateEmpleado(tEmpleado);
		Contexto contexto;

		if (result > 0)
			contexto = new Contexto(Evento.RES_MODIFICAR_EMPLEADO_OK, result);

		else
			contexto = new Contexto(Evento.RES_MODIFICAR_EMPLEADO_KO, "No se ha podido modificar el empleado");

		return contexto;
	}
}