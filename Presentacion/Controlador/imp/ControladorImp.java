package presentacion.Controlador.imp;

import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;
import presentacion.Controlador.FactoriaComando.FactoriaComando;
import presentacion.Factoria.FactoriaPresentacion;

public class ControladorImp extends Controlador {

	public void accion(int evento, Object datos) {
	
		Comando comando = FactoriaComando.getInstance().createComando(evento);
		if (comando != null) {
		
			Contexto contexto = comando.ejecutar(datos);
			FactoriaPresentacion.getInstance().generarVista(evento).actualizar(contexto.getEvento(),
					contexto.getDatos());
		} else
			FactoriaPresentacion.getInstance().generarVista(evento);
	}

}