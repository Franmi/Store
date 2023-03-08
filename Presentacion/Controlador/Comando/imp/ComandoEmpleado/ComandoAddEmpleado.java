package presentacion.Controlador.Comando.imp.ComandoEmpleado;

import negocio.Empleado.TEmpleado;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoAddEmpleado implements Comando {

	public Contexto ejecutar(Object datos) {
		TEmpleado tEmpleado = (TEmpleado) datos;
		int result = FactoriaNegocio.getInstance().createSAEmpleado().addEmpleado(tEmpleado);
		Contexto contexto;
		if (result > 0)
			contexto = new Contexto(Evento.RES_ALTA_EMPLEADO_OK, result);
		else
			contexto = new Contexto(Evento.RES_ALTA_EMPLEADO_KO, "Error al crear Empleado. El DNI ya existe.");
		return contexto;
	}
}