package presentacion.Controlador.Comando.imp.ComandoPez;

import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoEliminarPez implements Comando {

	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		int res = FactoriaNegocio.getInstance().createSAPez().delete(id);
		Contexto contexto;

		if (res == -1) {
			contexto = new Contexto(Evento.RES_ELIMINAR_PEZ_KO, "El id debe ser un número positivo");
		} else if (res == -2) {
			contexto = new Contexto(Evento.RES_ELIMINAR_PEZ_KO,
					"El pez no existe, está dado de baja o participa en algún espectáculo");
		} else {
			contexto = new Contexto(Evento.RES_ELIMINAR_PEZ_OK, id);
		}
		return contexto;
	}
}