package presentacion.Factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Factura.TLineaFactura;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaEliminarEspectaculoFactura extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaEliminarEspectaculoFactura() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("ELIMINAR ESPECTÁCULO DEL CARRITO");
		JPanel panel = new JPanel();
		JLabel showLabel = new JLabel("Id del espectáculo:");
		final JTextField showText = new JTextField(20);

		JButton delete = new JButton("Eliminar");
		JButton cancel = new JButton("Cancelar");

		panel.add(showLabel);
		panel.add(showText);
		panel.add(delete);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					int idEspectaculo = Integer.parseInt(showText.getText());
					boolean found = false;
					Iterator<TLineaFactura> iterator;

					if (VistaAbrirVenta.carrito == null) {
						JOptionPane.showMessageDialog(null, "No se ha podido encontrar el carrito");
					} else {
						iterator = VistaAbrirVenta.carrito.iterator();
						while (!found && iterator.hasNext()) {
							TLineaFactura linea = iterator.next();
							if (linea.getIdEspectaculo() == idEspectaculo) {
								VistaAbrirVenta.carrito.remove(linea);
								found = true;
							}
						}
						if (!found)
							JOptionPane.showMessageDialog(null,
									"No se ha podido encontrar el espectáculo en el carrito");
					}

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA, null);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void actualizar(int evento, Object datos) {
	}

}