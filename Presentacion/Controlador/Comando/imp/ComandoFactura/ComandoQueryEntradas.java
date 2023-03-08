package presentacion.Controlador.Comando.imp.ComandoFactura;

import negocio.Factoria.FactoriaNegocio;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoQueryEntradas implements Comando {

	@Override
	public Contexto ejecutar(Object datos) {
		double precio = (double) datos;
		int result = FactoriaNegocio.getInstance().createSAFactura().queryEntradas(precio);
		Contexto contexto;
		if (result == -1)
			contexto = new Contexto(Evento.RES_QUERY_ENTRADAS_KO, null);
		else {
			contexto = new Contexto(Evento.RES_QUERY_ENTRADAS_OK, result);
		}
		return contexto;
	}

}
