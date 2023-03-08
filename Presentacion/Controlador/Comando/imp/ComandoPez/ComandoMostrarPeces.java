package presentacion.Controlador.Comando.imp.ComandoPez;

import java.util.Set;

import negocio.Factoria.FactoriaNegocio;
import negocio.Pez.TPez;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoMostrarPeces implements Comando {

	public Contexto ejecutar(Object datos) {
		Set<TPez> set = FactoriaNegocio.getInstance().createSAPez().readAll();
		Contexto contexto;

		if (set == null) {
			contexto = new Contexto(Evento.RES_MOSTRAR_PECES_KO, "No hay peces que leer");
		} else {
			contexto = new Contexto(Evento.RES_MOSTRAR_PECES_OK, set);
		}
		return contexto;
	}
}