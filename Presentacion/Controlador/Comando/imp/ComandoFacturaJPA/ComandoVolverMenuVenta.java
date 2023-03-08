package presentacion.Controlador.Comando.imp.ComandoFacturaJPA;

import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

public class ComandoVolverMenuVenta implements Comando{

	@Override
	public Contexto ejecutar(Object datos) {//Para hacer setVisible true a vista especial
		
		return new Contexto(Evento.VOLVER_MENU_ABRIR_VENTA,null);
	}

}
