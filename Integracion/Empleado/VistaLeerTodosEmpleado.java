package presentacion.Empleado;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import negocio.Empleado.TEmpleado;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaLeerTodosEmpleado extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaLeerTodosEmpleado() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("LEER TODOS LOS EMPLEADOS");
		JPanel panel = new JPanel();
		JButton show = new JButton("MOSTRAR");
		JButton cancel = new JButton("CANCELAR");

		panel.add(show);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				try {

					Controlador.getInstance().accion(Evento.LISTAR_EMPLEADO, null);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "No se puede mostrar la lista", "ERROR",
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
		if (evento == Evento.RES_LISTAR_EMPLEADOS_OK) {

			Set<TEmpleado> set = (Set<TEmpleado>) datos;
			String s = "";
			for (TEmpleado p : set) {
				s += p.toString() + "_____________\n";

			}
			JTextArea textArea = new JTextArea(s);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(this, scrollPane, "Empleado", JOptionPane.DEFAULT_OPTION);
			System.out.println("LLEGA");
		}

		else if (evento == Evento.RES_LISTAR_EMPLEADOS_KO)
			JOptionPane.showMessageDialog(this, "No se han podido mostrar los empleado", "EMPLEADOS",
					JOptionPane.ERROR);

		dispose();
	}

	public void leerTodosEmpleado() {

	}
}