package presentacion.Controlador.Comando.imp.ComandoFacturaJPA;

import java.util.Collection;

import negocio.Factoria.FactoriaNegocio;
import negocio.FacturaJPA.TFacturaJPA;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoBuscarFacturaProducto implements Comando{

	@Override
	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		Collection<TFacturaJPA> tLeido = FactoriaNegocio.getInstance().createSAFacturaJPA().leerPorProducto(id);
		Contexto contexto;
		
		if(tLeido == null) {
			contexto = new Contexto(Evento.RES_BUSCAR_FACTURA_PRODUCTO_JPA_KO, "No se pudo completar la búsqueda, o no existe ninguna factura que contenga ese producto, o el producto no existe / está inactivo");
		} else {
			contexto = new Contexto(Evento.RES_BUSCAR_FACTURA_PRODUCTO_JPA_OK, tLeido);
		}
		
		return contexto;
	}

}
