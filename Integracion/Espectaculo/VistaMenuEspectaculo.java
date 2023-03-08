package presentacion.Espectaculo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaMenuEspectaculo extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaMenuEspectaculo() {
		setTitle("Espectáculo");

		JPanel panel = new JPanel(new GridLayout(1, 2));
		JButton add = new JButton("Añadir espectáculo");
		JButton read = new JButton("Buscar espectáculo");
		JButton delete = new JButton("Eliminar espectáculo");
		JButton update = new JButton("Modificar espectáculo");
		JButton list = new JButton("Listar espectáculos");
		JButton listEmployee = new JButton("Mostrar espectáculos por empleado");
		JButton addFish = new JButton("Añadir pez"); // SE SALE DE LA PANTALLA, HACER DOS EN UNO??
		JButton deleteFish = new JButton("Eliminar pez");
		JButton queryEspectaculo = new JButton("Mayor número de entradas en una factura");
		JButton cancel = new JButton("Cancelar");

		panel.add(add);
		panel.add(read);
		panel.add(delete);
		panel.add(update);
		panel.add(list);
		panel.add(listEmployee);
		panel.add(addFish);
		panel.add(deleteFish);
		panel.add(queryEspectaculo);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ALTA_ESPECTACULO, null);
			}

		});

		read.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_LEER_ESPECTACULO, null);
			}

		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ELIMINAR_ESPECTACULO, null);
			}

		});

		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_MODIFICAR_ESPECTACULO, null);
			}

		});

		list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_LISTAR_ESPECTACULOS, null);
			}

		});

		listEmployee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_MOSTRAR_ESPECTACULO_POR_EMPLEADO, null);
			}

		});

		addFish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ASIGNAR_PEZ, null);
			}

		});

		deleteFish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_DESASIGNAR_PEZ, null);
			}

		});

		queryEspectaculo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_QUERY_ESPECTACULO, null);
			}

		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.MENU_ACUARIO, null);
			}

		});
	}

	@Override
	public void actualizar(int evento, Object datos) {
	}

}