package presentacion.EmpleadoJPA;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import negocio.Empleado.TEmpleado;
import negocio.EmpleadoJPA.TEmpleadoJPA;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaReadAllEmpleado extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaReadAllEmpleado() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("LISTAR TODOS LOS EMPLEADOS");
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
					Controlador.getInstance().accion(Evento.LISTAR_EMPLEADO_JPA, null);
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
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}

	@Override
	public void actualizar(int evento, Object datos) {
		setVisible(false);
		if (evento == Evento.RES_LISTAR_EMPLEADO_JPA_OK) {
			Collection<TEmpleadoJPA> set = (Collection<TEmpleadoJPA>) datos;
			String s = "";
			for (TEmpleadoJPA p : set) {
				s += p.toString() + "_____________\n";

			}
			JTextArea textArea = new JTextArea(s);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(this, scrollPane, "Empleado", JOptionPane.DEFAULT_OPTION);
		}

		else if (evento == Evento.RES_LISTAR_EMPLEADO_JPA_KO)
			JOptionPane.showMessageDialog(this, "No se ha encontrado ningun Empleado");

		dispose();
	}

	public void leerTodosEmpleado() {

	}
}