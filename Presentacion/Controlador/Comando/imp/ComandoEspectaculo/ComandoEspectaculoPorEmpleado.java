package presentacion.Controlador.Comando.imp.ComandoEspectaculo;

import java.util.Set;

import negocio.Espectaculo.TEspectaculo;
import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoEspectaculoPorEmpleado implements Comando{

	@Override
	public Contexto ejecutar(Object datos) {
		int idempleado =(int) datos;
		Set<TEspectaculo> SetEsp=FactoriaNegocio.getInstance().createSAEspectaculo().readEspectaculoByEmpleado(idempleado);
		Contexto contexto;
		if(SetEsp!=null){
			contexto=new Contexto(Evento.RES_MOSTRAR_ESPECTACULO_POR_EMPLEADO_OK,SetEsp);
		}else{
			contexto=new Contexto(Evento.RES_MOSTRAR_ESPECTACULO_POR_EMPLEADO_KO,SetEsp);
		}
		return contexto;
	}

}
