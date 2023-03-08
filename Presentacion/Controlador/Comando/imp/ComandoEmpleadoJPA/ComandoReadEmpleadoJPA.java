package presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA;

import negocio.EmpleadoJPA.TEmpleadoJPA;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoReadEmpleadoJPA implements Comando {
	
	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		TEmpleadoJPA eLeido = FactoriaNegocio.getInstance().createSAEmpleadoJPA().readEmpleado(id);
		Contexto contexto;
		
		if(eLeido == null) {
			contexto = new Contexto(Evento.RES_BUSCAR_EMPLEADO_JPA_KO, "No se encontró ningún empleado con id: " + id);
		} else {
			contexto = new Contexto(Evento.RES_BUSCAR_EMPLEADO_JPA_OK, eLeido);
		}
		
		return contexto;
	}
}