package presentacion.Controlador.Comando.imp.ComandoEmpleado;

import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoDeleteEmpleado implements Comando {

	public Contexto ejecutar(Object datos) {

		int id = (int) datos;
		int result = FactoriaNegocio.getInstance().createSAEmpleado().deleteEmpleado(id);
		Contexto contexto;

		if (result == -1)
			contexto = new Contexto(Evento.RES_ELIMINAR_EMPLEADO_KO,
					"El Empleado con id:" + id + " no existe, est� dado de baja o est� asociado a alg�n espect�culo");
		else
			contexto = new Contexto(Evento.RES_ELIMINAR_EMPLEADO_OK, id);
		return contexto;

	}
}