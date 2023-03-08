package presentacion.Factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.*;

import negocio.Factura.TLineaFactura;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaAñadirEspectaculoFactura extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;

	public VistaAñadirEspectaculoFactura() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("AÑADIR ESPECTÁCULO AL CARRITO");
		JPanel panel = new JPanel();
		JLabel showLabel = new JLabel("Id del espectáculo:");
		final JTextField showText = new JTextField(20);
		JLabel amountLabel = new JLabel("Número de entradas:");
		final JTextField amountText = new JTextField(20);
		
		JButton add = new JButton("Añadir");
		JButton cancel = new JButton("Cancelar");
		
		panel.add(showLabel);
		panel.add(showText);
		panel.add(amountLabel);
		panel.add(amountText);
		panel.add(add);
		panel.add(cancel);
		
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					int idEspectaculo = Integer.parseInt(showText.getText());
					int entradas = Integer.parseInt(amountText.getText());
					
					boolean found = false;
					Iterator<TLineaFactura> iterator;
					
					if (VistaAbrirVenta.carrito == null) {
						JOptionPane.showMessageDialog(null, "No se ha podido encontrar el carrito");
					}
					else {
						iterator = VistaAbrirVenta.carrito.iterator();
						while (!found && iterator.hasNext()) {
							TLineaFactura linea = iterator.next();
							if (linea.getIdEspectaculo() == idEspectaculo) {
									found = true;
									JOptionPane.showMessageDialog(null, "El espectáculo ya pertenece a la factura");
							}
						}
						if (!found)
							VistaAbrirVenta.carrito.add(new TLineaFactura(0, idEspectaculo, entradas, 0));
					}
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(),
							"ERROR", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
					
					setVisible(true);
				}
			}
		});
	}

	public void actualizar(int evento, Object datos) {}
}