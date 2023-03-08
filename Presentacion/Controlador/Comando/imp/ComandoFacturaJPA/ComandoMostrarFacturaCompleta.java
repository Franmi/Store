package presentacion.Controlador.Comando.imp.ComandoFacturaJPA;

import negocio.Factoria.FactoriaNegocio;
import negocio.FacturaJPA.TFacturaJPA;
import negocio.FacturaJPA.TOAFacturaProducto;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;


public class ComandoMostrarFacturaCompleta implements Comando {
	
	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		TOAFacturaProducto tLeido = FactoriaNegocio.getInstance().createSAFacturaJPA()
				.mostrarFacturaCompleta(id);
		Contexto contexto;
		
		if(tLeido == null) {
			contexto = new Contexto(Evento.RES_MOSTRAR_FACTURA_COMPLETA_JPA_KO, "No se pudo mostrar la factura");
		} else {
			contexto = new Contexto(Evento.RES_MOSTRAR_FACTURA_COMPLETA_JPA_OK, tLeido);
		}
		
		return contexto;
	}
}