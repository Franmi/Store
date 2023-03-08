package presentacion.Controlador.Comando.imp.ComandoPez;

import java.util.Set;

import negocio.Factoria.FactoriaNegocio;
import negocio.Pez.TPez;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoMostrarPecesEspectaculo implements Comando {

	public Contexto ejecutar(Object datos) {
		int idEspectaculo = (int) datos;
		Set<TPez> set = FactoriaNegocio.getInstance().createSAPez().readPezByEspectaculo(idEspectaculo);
		Contexto contexto;
		
		if(set.isEmpty()) {
			contexto = new Contexto(Evento.RES_MOSTRAR_PECES_ESPECTACULO_KO, "No hay peces que leer");
		} else {
			contexto = new Contexto(Evento.RES_MOSTRAR_PECES_ESPECTACULO_OK, set);
		}
		return contexto;
	}
}
