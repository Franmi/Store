package presentacion.Controlador.Comando.imp.ComandoFactura;

import negocio.Factoria.FactoriaNegocio;
import negocio.Factura.TLineaFactura;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoDevolverEspectaculo implements Comando {
	public Contexto ejecutar(Object datos) {
		TLineaFactura tLineaFactura = (TLineaFactura) datos;
		int res = FactoriaNegocio.getInstance().createSAFactura().devolverEspectaculo(tLineaFactura);
		Contexto contexto;
		if (res > 0)
			contexto = new Contexto(Evento.RES_DEVOLVER_ESPECTACULO_FACTURA_OK, res);
		else
			contexto = new Contexto(Evento.RES_DEVOLVER_ESPECTACULO_FACTURA_KO, res);
		return contexto;
	}
}