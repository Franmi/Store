package presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA;

import java.util.Collection;
import java.util.Set;

import negocio.EmpleadoJPA.TEmpleadoJPA;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoReadEmpleadoByTurno implements Comando {

	public Contexto ejecutar(Object datos) {
		int idTurno =(int) datos;
		Collection<TEmpleadoJPA> emp=FactoriaNegocio.getInstance().createSAEmpleadoJPA().readEmpleadosByTurno(idTurno);
		Contexto contexto;
		if(!emp.isEmpty()){
			contexto=new Contexto(Evento.RES_MOSTRAR_EMPLEADOS_TURNO_OK,emp);
		}else{
			contexto=new Contexto(Evento.RES_MOSTRAR_EMPLEADOS_TURNO_KO, emp);
		}
		return contexto;
	}
}