package presentacion.Controlador.Comando.imp.ComandoPez;

import negocio.Factoria.FactoriaNegocio;
import negocio.Pez.TPez;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoAñadirPez implements Comando {

	public Contexto ejecutar(Object datos) {
		TPez tPez = (TPez) datos;
		int result = FactoriaNegocio.getInstance().createSAPez().create(tPez);
		Contexto contexto;
		if (result > 0) {
			contexto = new Contexto(Evento.RES_ALTA_PEZ_OK, result);
		} else
			contexto = new Contexto(Evento.RES_ALTA_PEZ_KO, "Error al crear el pez");
		return contexto;
	}
}