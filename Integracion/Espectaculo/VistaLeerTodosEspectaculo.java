package presentacion.Espectaculo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import negocio.Espectaculo.TEspectaculo;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaLeerTodosEspectaculo extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaLeerTodosEspectaculo() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("LISTAR ESPECTÁCULOS");
		JPanel panel = new JPanel();
		JLabel showLabel = new JLabel("¿Mostrar todos los espectáculos?");

		JButton read = new JButton("MOSTRAR");
		JButton cancel = new JButton("CANCELAR");

		
		panel.add(showLabel);

		panel.add(read);
		panel.add(cancel);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); // Por que??

				try {

					Controlador.getInstance().accion(Evento.LISTAR_ESPECTACULO, null);

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
		if (evento == Evento.RES_LISTAR_ESPECTACULOS_OK) {
			Set<TEspectaculo> esp = (Set<TEspectaculo>) datos;
			JTextArea textArea = new JTextArea(esp.toString());
			JScrollPane scrollPane = new JScrollPane(textArea);

			scrollPane.setPreferredSize(new Dimension(500, 500));

			JOptionPane.showMessageDialog(this, scrollPane, "ESPECTÁCULOS", JOptionPane.DEFAULT_OPTION);
		}

		else if (evento == Evento.RES_LISTAR_ESPECTACULOS_KO)
			JOptionPane.showMessageDialog(this, "No se ha encontrado ningún espectáculo");
	}
}