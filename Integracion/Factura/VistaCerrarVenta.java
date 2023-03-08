package presentacion.Factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Factura.TFactura;
import negocio.Factura.TOAFacturaEspectaculo;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaCerrarVenta extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaCerrarVenta() {
		setTitle("CERRAR VENTA");
		JPanel panel = new JPanel();
		JLabel DNILabel = new JLabel("DNI de cliente:");
		final JTextField DNIText = new JTextField(20);
		final String date = DateTimeFormatter.ofPattern("MM-dd-yyy hh:mm:ss").format(LocalDateTime.now());
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");

		panel.add(DNILabel);
		panel.add(DNIText);
		panel.add(aceptar);
		panel.add(cancelar);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					if (VistaAbrirVenta.carrito == null) {
						JOptionPane.showMessageDialog(null, "No se ha podido encontrar el carrito");
					} else {
						if (DNIText.getText().length() > 9)
							JOptionPane.showMessageDialog(null, "El campo DNI no puede tener más de 9 caracteres");
						else {
							if (DNIText.getText().length() != 0) {
								TOAFacturaEspectaculo toaFacturaEspectaculo = new TOAFacturaEspectaculo();
								toaFacturaEspectaculo.setTLineaFactura(VistaAbrirVenta.carrito);
								toaFacturaEspectaculo.setTFactura(new TFactura(0, DNIText.getText(), date, 0, 0));
								Controlador.getInstance().accion(Evento.ALTA_FACTURA, toaFacturaEspectaculo);
							} else
								JOptionPane.showMessageDialog(null, "Debes rellenar el campo DNI");
						}
					}

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA, null);

			}
		});

		cancelar.addActionListener(new ActionListener() {
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
		setVisible(false);
		if (evento == Evento.RES_ALTA_FACTURA_OK)
			JOptionPane.showMessageDialog(this, "Se ha creado correctamente la factura con id " + (Integer) datos);
		else if (evento == Evento.RES_ALTA_FACTURA_KO) {
			JOptionPane.showMessageDialog(this, (String) datos);
		}
		VistaAbrirVenta.carrito = null;
	}

}