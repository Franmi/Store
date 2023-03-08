package presentacion.Controlador.Comando.imp.ComandoEmpleado;

import negocio.Empleado.TEmpleado;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoReadEmpleadoPorDNI implements Comando {

	public Contexto ejecutar(Object datos) {

		String DNI = (String) datos;
		TEmpleado result = FactoriaNegocio.getInstance().createSAEmpleado().readEmpleadoPorDNI(DNI);
		Contexto contexto;
		if (result != null)
			contexto = new Contexto(Evento.RES_MOSTRAR_EMPLEADO_DNI_OK, result);
		else contexto = new Contexto(Evento.RES_MOSTRAR_EMPLEADO_DNI_KO, "No se ha encontrado empleado con id: " +DNI);
		return contexto;
	}
}
