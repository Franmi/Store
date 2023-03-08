package presentacion.Espectaculo;

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

public class VistaBajaEspectaculo extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaBajaEspectaculo() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("ELIMINAR ESPECTÁCULO");
		JPanel panel = new JPanel();
		JLabel showLabel = new JLabel("Id del espectáculo:");
		final JTextField showText = new JTextField(20);

		JButton delete = new JButton("ELIMINAR");
		JButton cancel = new JButton("CANCELAR");

		panel.add(showLabel);
		panel.add(showText);
		panel.add(delete);
		panel.add(cancel);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); // Por que??

				try {
					if (showText.getText() != " ") {
						int idEspectaculo = Integer.parseInt(showText.getText());
						Controlador.getInstance().accion(Evento.ELIMINAR_ESPECTACULO, idEspectaculo);
					}

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
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
		switch (evento) {
		case Evento.RES_ELIMINAR_ESPECTACULO_OK: {
			JOptionPane.showMessageDialog(this, "Espectaculo dado de baja correctamente.", "Baja Espectaculo",
					JOptionPane.DEFAULT_OPTION);
			break;
		}
		case Evento.RES_ELIMINAR_ESPECTACULO_KO: {
			JOptionPane.showMessageDialog(this, "No se ha podido dar de baja", "Baja Espectaculo",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
		default: {
			String str = (String) datos;
			JOptionPane.showMessageDialog(this, str, "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		}
		}
	}
}