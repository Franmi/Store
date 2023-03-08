package presentacion.Empleado;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaMenuEmpleado extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaMenuEmpleado() {
		setTitle("Empleado");

		JPanel panel = new JPanel(new GridLayout(1, 2));
		JButton add = new JButton("Añadir empleado");
		JButton read = new JButton("Buscar empleado por ID");
		JButton readDNI = new JButton("Buscar empleado por DNI");
		JButton delete = new JButton("Eliminar empleado");
		JButton update = new JButton("Modificar empleado");
		JButton list = new JButton("Listar empleados");
		JButton cancel = new JButton("Cancelar");

		panel.add(add);
		panel.add(read);
		panel.add(readDNI);
		panel.add(delete);
		panel.add(update);
		panel.add(list);
		panel.add(cancel);

		getContentPane().add(panel);
		setLocationRelativeTo(null);
		setVisible(true);
		pack();

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ALTA_EMPLEADO, null);
			}

		});

		read.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_LEER_EMPLEADO, null);
			}

		});

		readDNI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_MOSTRAR_EMPLEADO_DNI, null);
			}

		});
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ELIMINAR_EMPLEADO, null);
			}

		});

		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_MODIFICAR_EMPLEADO, null);
			}

		});

		list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_LEER_TODOS_EMPLEADOS, null);
				//Controlador.getInstance().accion(Evento.VISTA_LISTAR_EMPLEADOS, null);
			}

		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.MENU_ACUARIO, null);
				dispose();
			}

		});

		this.add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void actualizar(int evento, Object datos) {
	}

}
