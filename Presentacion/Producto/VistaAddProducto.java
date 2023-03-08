package presentacion.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Producto.TProducto;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaAddProducto extends JFrame implements IGUI {

	public VistaAddProducto() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("AÑADIR PRODUCTO");

		JPanel panel = new JPanel();
		JLabel codeLabel = new JLabel("Código del producto:");
		final JTextField codeText = new JTextField(20);
		JLabel nameLabel = new JLabel("Nombre del producto");
		final JTextField nameText = new JTextField(20);
		JLabel priceLabel = new JLabel("Precio del producto:");
		final JTextField priceText = new JTextField(20);
		JLabel stockLabel = new JLabel("Stock del producto:");
		final JTextField stockText = new JTextField(20);

		JButton add = new JButton("AÑADIR");
		JButton cancel = new JButton("CANCELAR");

		panel.add(codeLabel);
		panel.add(codeText);
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(priceLabel);
		panel.add(priceText);
		panel.add(stockLabel);
		panel.add(stockText);
		panel.add(add);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				try {
					if (codeText.getText().length() != 0 && nameText.getText().length() != 0
							&& priceText.getText().length() != 0 && stockText.getText().length() != 0) {
						String code = codeText.getText();
						String name = nameText.getText();
						double price = Double.parseDouble(priceText.getText());
						int stock = Integer.parseInt(stockText.getText());
						if(stock>=0 && price>=0){
							TProducto producto = new TProducto(code, name, price, stock);
							Controlador.getInstance().accion(Evento.ALTA_PRODUCTO, producto);
						}
						else JOptionPane.showMessageDialog(null, "Precio y/o stock no pueden ser negativos");
					} else
						JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Los datos introducidos no son válidos", "ERROR",
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
		case Evento.RES_ALTA_PRODUCTO_OK: {
			setVisible(false);
			JOptionPane.showMessageDialog(this, "El producto fue dado de alta con éxito" + datos, "Alta Producto",
					JOptionPane.DEFAULT_OPTION);
			break;
		}
		case Evento.RES_ALTA_PRODUCTO_KO: {
			JOptionPane.showMessageDialog(this, "No se creó el producto", "Alta Producto", JOptionPane.ERROR_MESSAGE);
		}
		default:
			break;
		}

	}
}