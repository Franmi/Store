package presentacion.EmpleadoJPA;

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

public class VistaReadEmpleado extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaReadEmpleado() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MOSTRAR EMPLEADO");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Id del empleado:");
		final JTextField text = new JTextField(20);

		JButton show = new JButton("MOSTRAR");
		JButton cancel = new JButton("CANCELAR");

		panel.add(label);
		panel.add(text);
		panel.add(show);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (text.getText().length() != 0){
					int id = Integer.parseInt(text.getText());
					Controlador.getInstance().accion(Evento.BUSCAR_EMPLEADO_JPA, id);
					}
					else JOptionPane.showMessageDialog(null, "No has seleccionado ningun empleado");

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO_JPA, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO_JPA, null);

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
		if (evento == Evento.RES_BUSCAR_EMPLEADO_JPA_OK) {
			JOptionPane.showMessageDialog(this, datos.toString(), "EMPLEADO", JOptionPane.DEFAULT_OPTION);
		} else {
			String str = (String) datos;
			JOptionPane.showMessageDialog(this, str, "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		dispose();
	}
}