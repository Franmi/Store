package presentacion.EmpleadoJPA;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaMenuEmpleadoJPA extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;
	
	public VistaMenuEmpleadoJPA() {
		setTitle("Empleado");

		JPanel panel = new JPanel(new GridLayout(3, 4));
		JButton add = new JButton("Añadir Empleado");
		JButton update = new JButton("Modificar Empleado");
		JButton read = new JButton("Mostrar Empleado");
		JButton readAll = new JButton("Listar Empleados");
		JButton readByTurno = new JButton("Mostrar Empleado por Turno");
		JButton link = new JButton("Vincular turno a Empleado");
		JButton unlink = new JButton("Desvincular turno de Empleado");
		JButton salary = new JButton("Calcular Nómina");
		JButton delete = new JButton("Elminar Empleado");
		JButton cancel = new JButton("Cancelar");

		panel.add(add);
		panel.add(update);
		panel.add(read);
		panel.add(readAll);
		panel.add(readByTurno);
		panel.add(link);
		panel.add(unlink);
		panel.add(salary);
		panel.add(delete);
		panel.add(cancel);

		getContentPane().add(panel);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ALTA_EMPLEADO_JPA, null);
			}

		});
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ELIMINAR_EMPLEADO_JPA, null);
			}

		});
		
		readAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_LISTAR_EMPLEADO_JPA, null);
			}

		});


		read.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_BUSCAR_EMPLEADO_JPA, null);
			}

		});

		
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_MODIFICAR_EMPLEADO_JPA, null);
			}

		});


		readByTurno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_MOSTRAR_EMPLEADOS_TURNO, null);
			}

		});
		
		link.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_VINCULAR_TURNO, null);
			}

		});
		
		
		unlink.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_DESVINCULAR_TURNO, null);
			}

		});


		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.MENU_TIENDA, null);
			}

		});
		
		salary.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_CALCULAR_NOMINA, null);
			}

		});
	}

	@Override
	public void actualizar(int evento, Object datos) {}
	
}