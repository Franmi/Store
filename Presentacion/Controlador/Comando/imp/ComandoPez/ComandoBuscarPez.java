package presentacion.Controlador.Comando.imp.ComandoPez;

import negocio.Factoria.FactoriaNegocio;
import negocio.Pez.TPez;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoBuscarPez implements Comando {

	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		TPez tPez = FactoriaNegocio.getInstance().createSAPez().read(id);
		Contexto contexto;

		if (tPez == null) {
			contexto = new Contexto(Evento.RES_MOSTRAR_PEZ_KO, "No se encontró ningún pez activo con id: " + id);
		} else {
			contexto = new Contexto(Evento.RES_MOSTRAR_PEZ_OK, tPez);
		}
		return contexto;
	}
}