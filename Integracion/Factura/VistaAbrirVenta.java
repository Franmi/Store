package presentacion.Factura;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import negocio.Factura.TLineaFactura;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaAbrirVenta extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	protected static Collection<TLineaFactura> carrito;

	public VistaAbrirVenta() {
		try {
			carrito = new ArrayList<TLineaFactura>();
			Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA, null);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actualizar(int evento, Object datos) {
	}

}