
package presentacion.Controlador.Comando.imp.ComandoFacturaJPA;

import negocio.Factoria.FactoriaNegocio;
import negocio.FacturaJPA.TFacturaJPA;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;


public class ComandoModificarFacturaJPA implements Comando {

	public Contexto ejecutar(Object datos) {
		TFacturaJPA tFac = (TFacturaJPA) datos;
		int res = FactoriaNegocio.getInstance().createSAFacturaJPA().modificarFactura(tFac);
		Contexto contexto;
		if(res > 0) contexto = new Contexto(Evento.RES_MODIFICAR_FACTURA_JPA_OK, "La factura se modificó correctamente");
		else if(res == -1) {
			contexto = new Contexto(Evento.RES_MODIFICAR_FACTURA_JPA_KO, "No se pudo modificar la factura, factura inactiva o no existente");
		}else if(res==-2){
			contexto = new Contexto(Evento.RES_MODIFICAR_FACTURA_JPA_KO, "No se pudo modificar la factura, empleado inactivo o inexistente");
		
		} else {
			contexto = new Contexto(Evento.RES_MODIFICAR_FACTURA_JPA_KO, "No se pudo modificar la factura, prueba en otro momento");
		}
		
		return contexto;
	}
}