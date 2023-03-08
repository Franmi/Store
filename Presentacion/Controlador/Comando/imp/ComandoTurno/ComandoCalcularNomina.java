package presentacion.Controlador.Comando.imp.ComandoTurno;

import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoCalcularNomina implements Comando {
	
	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		double result = FactoriaNegocio.getInstance().createSATurno().calcularNomina(id);
		Contexto contexto;
		if (result >= 0)
			contexto = new Contexto(Evento.RES_CALCULAR_NOMINA_TURNO_OK, result);
		else contexto = new Contexto(Evento.RES_CALCULAR_NOMINA_TURNO_KO, result);
		return contexto;
	}
}