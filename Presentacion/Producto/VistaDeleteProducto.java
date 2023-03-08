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

public class VistaDeleteProducto extends JFrame implements IGUI {

	public VistaDeleteProducto() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("ELIMINAR PRODUCTO");
		JPanel panel = new JPanel();
		JLabel idLabel = new JLabel("Id del producto:");
		final JTextField idText = new JTextField(20);

		JButton delete = new JButton("ELIMINAR");
		JButton cancel = new JButton("CANCELAR");

		panel.add(idLabel);
		panel.add(idText);
		panel.add(delete);
		panel.add(cancel);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					if (idText.getText() != " ") {
						try{
						int idProducto = Integer.parseInt(idText.getText());
						Controlador.getInstance().accion(Evento.ELIMINAR_PRODUCTO, idProducto);
						}catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(null, "El id debe ser un número");
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Debes rellenar el campo");
					}

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
		setVisible(false);
		switch (evento) {
		case Evento.RES_ELIMINAR_PRODUCTO_OK: {
			JOptionPane.showMessageDialog(this, "Producto dado de baja correctamente.", "Baja Producto",
					JOptionPane.DEFAULT_OPTION);
			break;
		}
		case Evento.RES_ELIMINAR_PRODUCTO_KO: {
			JOptionPane.showMessageDialog(this, "No se ha podido dar de baja", "Baja Producto",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
		default: {
			String str = (String) datos;
			JOptionPane.showMessageDialog(this, str, "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		}
		}
	}
}