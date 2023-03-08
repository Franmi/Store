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

public class VistaLeerEspectaculo extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaLeerEspectaculo() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("BUSCAR ESPECTÁCULO");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Id del espectáculo:");
		final JTextField text = new JTextField(20);

		JButton search = new JButton("BUSCAR");
		JButton cancel = new JButton("CANCELAR");

		panel.add(label);
		panel.add(text);
		panel.add(search);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				try {
					int id = Integer.parseInt(text.getText());

					Controlador.getInstance().accion(Evento.MOSTRAR_ESPECTACULO, id);

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
		case Evento.RES_LISTAR_ESPECTACULOS_OK: {
			JOptionPane.showMessageDialog(this, datos.toString(), "Leer Espectaculo", JOptionPane.DEFAULT_OPTION);
			break;
		}
		case Evento.RES_LISTAR_ESPECTACULOS_KO:
			JOptionPane.showMessageDialog(this, "No existe el espectaculo", "Leer Espectaculo",
					JOptionPane.ERROR_MESSAGE);
		default:
			break;
		}
	}
}
