package presentacion.Producto;

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

public class VistaReadProducto extends JFrame implements IGUI {

	public VistaReadProducto() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("BUSCAR PRODUCTO");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Id del producto:");
		final JTextField text = new JTextField(20);

		JButton search = new JButton("BUSCAR");
		JButton cancel = new JButton("CANCELAR");

		panel.add(label);
		panel.add(text);
		panel.add(search);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				try {
					int id = Integer.parseInt(text.getText());

					Controlador.getInstance().accion(Evento.BUSCAR_PRODUCTO, id);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				Controlador.getInstance().accion(Evento.VISTA_MENU_PRODUCTO, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_PRODUCTO, null);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch (evento) {
		case Evento.RES_BUSCAR_PRODUCTO_OK: {
			JOptionPane.showMessageDialog(this, datos.toString(), "Leer Producto", JOptionPane.DEFAULT_OPTION);
			break;
		}
		case Evento.RES_BUSCAR_PRODUCTO_KO:
			JOptionPane.showMessageDialog(this, "No existe el producto", "Leer producto",
					JOptionPane.ERROR_MESSAGE);
		default:
			break;
		}
	}
}