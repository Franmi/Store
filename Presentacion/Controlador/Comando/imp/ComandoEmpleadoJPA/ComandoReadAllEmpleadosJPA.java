package presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA;

import java.util.Collection;
import java.util.Set;

import negocio.EmpleadoJPA.TEmpleadoJPA;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;


public class ComandoReadAllEmpleadosJPA implements Comando {
	
	public Contexto ejecutar(Object datos) {
		
		Contexto contexto;
		Collection<TEmpleadoJPA> result = FactoriaNegocio.getInstance().createSAEmpleadoJPA().readAllEmpleados();
		if (!result.isEmpty())
			contexto = new Contexto(Evento.RES_LISTAR_EMPLEADO_JPA_OK, result);
		else
			contexto = new Contexto(Evento.RES_LISTAR_EMPLEADO_JPA_KO, result);

		return contexto;
	}
}