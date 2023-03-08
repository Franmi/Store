package presentacion.Turno;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaMenuTurno extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;
	
	public VistaMenuTurno() {
		setTitle("Turno");

		JPanel panel = new JPanel(new GridLayout(3, 4));
		JButton add = new JButton("Añadir turno");
		JButton read = new JButton("Buscar turno");
		JButton update = new JButton("Modificar turno");
		JButton delete = new JButton("Eliminar turno");
		JButton list = new JButton("Listar turnos");
		JButton listEmployees = new JButton("Mostrar por empleado");
		JButton payroll = new JButton("Calcular nómina");
		JButton cancel = new JButton("Cancelar");

		panel.add(add);
		panel.add(read);
		panel.add(update);
		panel.add(delete);
		panel.add(list);
		panel.add(listEmployees);
		panel.add(payroll);
		panel.add(cancel);

		getContentPane().add(panel);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ALTA_TURNO, null);
			}

		});

		read.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_BUSCAR_TURNO, null);
			}

		});

		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_MODIFICAR_TURNO, null);
			}

		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ELIMINAR_TURNO, null);
			}

		});

		list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_LISTAR_TURNOS, null);
			}

		});


		listEmployees.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_MOSTRAR_TURNOS_EMPLEADO, null);
			}

		});

		payroll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_CALCULAR_NOMINA_TURNO, null);
			}

		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.MENU_TIENDA, null);
			}

		});
	}

	@Override
	public void actualizar(int evento, Object datos) {}
	
}