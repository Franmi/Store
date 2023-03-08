package presentacion.Empleado;

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

public class VistaBajaEmpleado extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaBajaEmpleado() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("BAJA EMPLEADO");

		JPanel panel = new JPanel();
		JLabel label1 = new JLabel("Id del empleado:");
		final JTextField id = new JTextField(20);

		JButton baja = new JButton("DAR DE BAJA");
		JButton cancel = new JButton("CANCELAR");

		panel.add(label1);
		panel.add(id);

		panel.add(baja);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		baja.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				try {
					int idEmpleado = Integer.parseInt(id.getText());
					Controlador.getInstance().accion(Evento.ELIMINAR_EMPLEADO, idEmpleado);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(VistaBajaEmpleado.this, "El ID introducido no es correcto", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO, null);

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
		if (evento == Evento.RES_ELIMINAR_EMPLEADO_OK) {
			int id = (int) datos;
			JOptionPane.showMessageDialog(this, "Empleado con id " + id + " dado de baja correctamente.");
		} else {
			String str = (String) datos;
			JOptionPane.showMessageDialog(this, str, "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		dispose();
	}

}