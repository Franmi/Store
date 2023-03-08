package presentacion.Controlador.Comando.imp.ComandoEmpleadoJPA;

import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoCalcularNominaJPA implements Comando {
	
	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		
		double res = FactoriaNegocio.getInstance().createSAEmpleadoJPA().calcularNomina(id);
		Contexto contexto;
		
		if(res <= 0) {
			contexto = new Contexto(Evento.RES_CALCULAR_NOMINA_KO, "No se encontró ningún empleado con id: " + id);
		} else {
			contexto = new Contexto(Evento.RES_CALCULAR_NOMINA_OK, res);
		}
		
		return contexto;
	}
}