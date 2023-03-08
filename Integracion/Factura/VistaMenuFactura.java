package presentacion.Factura;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaMenuFactura extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaMenuFactura() {
		setTitle("Factura");

		JPanel panel = new JPanel(new GridLayout(3, 4));
		JButton open = new JButton("Abrir venta");
		JButton add = new JButton("Añadir espectáculo");
		JButton read = new JButton("Buscar factura");
		JButton update = new JButton("Modificar factura");
		JButton close = new JButton("Cerrar venta");
		JButton remove = new JButton("Eliminar espectáculo");
		JButton delete = new JButton("Eliminar factura");
		JButton render = new JButton("Devolver espectáculo");
		JButton list = new JButton("Listar facturas");
		JButton queryEntradas = new JButton("Entradas vendidas con precio > x");
		JButton cancel = new JButton("Cancelar");

		panel.add(open);
		panel.add(add);
		panel.add(read);
		panel.add(update);
		panel.add(close);
		panel.add(remove);
		panel.add(delete);
		panel.add(render);
		panel.add(list);
		panel.add(queryEntradas);
		panel.add(cancel);

		getContentPane().add(panel);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);

		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ABRIR_VENTA_FACTURA, null);
			}

		});

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_AÑADIR_ESPECTACULO_FACTURA, null);
			}

		});

		read.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_BUSCAR_FACTURA, null);
			}

		});

		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_MODIFICAR_FACTURA, null);
			}

		});

		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_CERRAR_VENTA_FACTURA, null);
			}

		});

		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ELIMINAR_ESPECTACULO_FACTURA, null);
			}

		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_ELIMINAR_FACTURA, null);
			}

		});

		render.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_DEVOLVER_ESPECTACULO_FACTURA, null);
			}

		});

		list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_LISTAR_FACTURAS, null);
			}

		});

		queryEntradas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				Controlador.getInstance().accion(Evento.VISTA_QUERY_ENTRADAS, null);
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

	public void actualizar(int evento, Object datos) {
	}

}
