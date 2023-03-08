package presentacion.Factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaQueryEntradas extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaQueryEntradas() {

		setTitle("Mostrar entradas vendidas por precio > al dado");
		JPanel panel = new JPanel();

		JPanel informacion = new JPanel();
		JLabel precioLabel = new JLabel("Precio: ");
		final JTextField precioTextField = new JTextField(8);
		informacion.add(precioLabel);
		informacion.add(precioTextField);

		JPanel botones = new JPanel();
		JButton aceptarButton = new JButton("Aceptar");
		JButton cancel = new JButton("Cancelar");
		botones.add(aceptarButton);
		botones.add(cancel);

		panel.add(informacion);
		panel.add(botones);

		this.add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		aceptarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					if (precioTextField.getText().length() != 0) {
						Double precio = Double.parseDouble(precioTextField.getText());
						Controlador.getInstance().accion(Evento.QUERY_ENTRADAS, precio);
					} else
						JOptionPane.showMessageDialog(null, "Debes rellenar el campo precio");
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(VistaQueryEntradas.this, "El precio introducido debe ser numérico",
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
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					setVisible(true);
				}
			}
		});

	}

	@Override
	public void actualizar(int evento, Object datos) {
		setVisible(false);
		if (evento == Evento.RES_QUERY_ENTRADAS_OK) {
			JOptionPane.showMessageDialog(this, "La cantidad de entradas es: " + datos.toString(), "Entradas",
					JOptionPane.DEFAULT_OPTION);

		} else if (evento == Evento.RES_QUERY_ENTRADAS_KO) {
			JOptionPane.showMessageDialog(this, "La operacion ha fallado", "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}

}
