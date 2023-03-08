package presentacion.Espectaculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Espectaculo.TEspectaculo;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaAltaEspectaculo extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaAltaEspectaculo() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("AÑADIR ESPECTÁCULO");
		JPanel panel = new JPanel();
		JLabel showLabel = new JLabel("Nombre del espectáculo:");
		final JTextField showText = new JTextField(20);
		JLabel priceLabel = new JLabel("Precio del espectáculo:");
		final JTextField priceText = new JTextField(20);
		JLabel amountLabel = new JLabel("Entradas disponibles para el espectáculo:");
		final JTextField amountText = new JTextField(20);
		JLabel employeeLabel = new JLabel("ID del empleado asociado:");
		final JTextField employeeText = new JTextField(20);

		JButton add = new JButton("AÑADIR");
		JButton cancel = new JButton("CANCELAR");

		panel.add(showLabel);
		panel.add(showText);
		panel.add(priceLabel);
		panel.add(priceText);
		panel.add(amountLabel);
		panel.add(amountText);
		panel.add(employeeLabel);
		panel.add(employeeText);
		panel.add(add);
		panel.add(cancel);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); // Por que??

				try {
					if (showText.getText().length() != 0 && priceText.getText().length() != 0
							&& amountText.getText().length() != 0 && employeeText.getText().length() != 0) {
						String nombreEspectaculo = showText.getText();
						double precioEspectaculo = Double.parseDouble(priceText.getText());
						int numeroEntradas = Integer.parseInt(amountText.getText());
						int idEmpleado = Integer.parseInt(employeeText.getText());
						TEspectaculo espectaculo = new TEspectaculo(nombreEspectaculo, precioEspectaculo,
								numeroEntradas, idEmpleado);

						Controlador.getInstance().accion(Evento.ALTA_ESPECTACULO, espectaculo);
					} else
						JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Los datos introducidos no son válidos", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				Controlador.getInstance().accion(Evento.VISTA_MENU_ESPECTACULO, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);

				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_ESPECTACULO, null);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	@Override
	public void actualizar(int evento, Object datos) {
		setVisible(false);
		switch (evento) {
		case Evento.RES_ALTA_ESPECTACULO_OK: {
			setVisible(false);
			JOptionPane.showMessageDialog(this, "Se Genero exitosamente el alta" + datos, "Alta Espectaculo",
					JOptionPane.DEFAULT_OPTION);
			break;
		}
		case Evento.RES_ALTA_ESPECTACULO_KO: {
			JOptionPane.showMessageDialog(this, "No se creo el  Espectaculo", "Alta Espectaculo",
					JOptionPane.ERROR_MESSAGE);
		}
		default:
			break;
		}

	}

}