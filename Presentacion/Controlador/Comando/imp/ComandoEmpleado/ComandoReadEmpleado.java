package presentacion.Controlador.Comando.imp.ComandoEmpleado;

import negocio.Empleado.TEmpleado;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoReadEmpleado implements Comando {

	public Contexto ejecutar(Object datos) {

		int id = (int) datos;
		TEmpleado result = FactoriaNegocio.getInstance().createSAEmpleado().readEmpleado(id);
		Contexto contexto;
		if (result != null)
			contexto = new Contexto(Evento.RES_MOSTRAR_EMPLEADO_OK, result);
		else
			contexto = new Contexto(Evento.RES_MOSTRAR_EMPLEADO_KO, "No se ha encontrado empleado con id: " + id);
		return contexto;
	}
}