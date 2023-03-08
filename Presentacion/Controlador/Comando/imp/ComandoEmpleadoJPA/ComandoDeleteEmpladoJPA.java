package presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA;

import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoDeleteEmpladoJPA implements Comando {

	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		int result = FactoriaNegocio.getInstance().createSAEmpleadoJPA().deleteEmpleado(id);
		Contexto contexto;
		if (result > 0) contexto = new Contexto(Evento.RES_ELIMINAR_EMPLEADO_JPA_OK, result);
		else contexto = new Contexto(Evento.RES_ELIMINAR_EMPLEADO_JPA_KO, result);
		return contexto;
	}
}