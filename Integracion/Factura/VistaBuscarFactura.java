package presentacion.Factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaBuscarFactura extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaBuscarFactura() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("BUSCAR FACTURA");
		JPanel panel = new JPanel();
		JLabel showLabel = new JLabel("Id de la factura:");
		final JTextField showText = new JTextField(20);

		JButton search = new JButton("Buscar");
		JButton cancel = new JButton("Cancelar");

		panel.add(showLabel);
		panel.add(showText);
		panel.add(search);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);

				try {
					int idFactura = Integer.parseInt(showText.getText());

					Controlador.getInstance().accion(Evento.MOSTRAR_FACTURA, idFactura);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);

				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA, null);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void actualizar(int evento, Object datos) {
		setVisible(false);
		if (evento == Evento.RES_MOSTRAR_FACTURA_OK) {
			JOptionPane.showMessageDialog(this, datos.toString());
		} else if (evento == Evento.RES_MOSTRAR_FACTURA_KO)
			JOptionPane.showMessageDialog(this, "No se ha podido encontrar la factura");
	}
}