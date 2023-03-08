package presentacion.Producto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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

public class VistaUpdateProducto extends JFrame implements IGUI{
	
	public VistaUpdateProducto() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MODIFICAR PRODUCTO");
		JPanel panel = new JPanel();

		JLabel idLabel = new JLabel("Id del producto:");
		final JTextField idText = new JTextField(20);
		JLabel codeLabel = new JLabel("Código del producto:");
		final JTextField codeText = new JTextField(20);
		JLabel nameLabel = new JLabel("Nombre del producto:");
		final JTextField nameText = new JTextField(20);
		JLabel priceLabel = new JLabel("Precio del producto:");
		final JTextField priceText = new JTextField(20);
		JLabel stockLabel = new JLabel("Stock del producto:");
		final JTextField stockText = new JTextField(20);

		JPanel panelBoton = new JPanel();

		JButton change = new JButton("MODIFICAR");
		JButton cancel = new JButton("CANCELAR");
		JPanel jid = new JPanel();
		jid.setLayout(new BoxLayout(jid, BoxLayout.X_AXIS));
		jid.add(idLabel);
		jid.add(idText);
		JPanel jcode = new JPanel();
		jcode.setLayout(new BoxLayout(jcode, BoxLayout.X_AXIS));
		jcode.add(codeLabel);
		jcode.add(codeText);
		JPanel jshow = new JPanel();
		jshow.setLayout(new BoxLayout(jshow, BoxLayout.X_AXIS));
		jshow.add(nameLabel);
		jshow.add(nameText);
		JPanel jprice = new JPanel();
		jprice.setLayout(new BoxLayout(jprice, BoxLayout.X_AXIS));
		jprice.add(priceLabel);
		jprice.add(priceText);
		JPanel jstock = new JPanel();
		jstock.setLayout(new BoxLayout(jstock, BoxLayout.X_AXIS));
		jstock.add(stockLabel);
		jstock.add(stockText);

		panel.add(jid);
		panel.add(jcode);
		panel.add(jshow);
		panel.add(jprice);
		panel.add(jstock);
		panelBoton.add(change);
		panelBoton.add(cancel);
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(panelBoton, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 

				try {
					if (idText.getText().length() != 0 && codeText.getText().length() != 0 && nameText.getText().length() != 0
							&& priceText.getText().length() != 0 && stockText.getText().length() != 0) {
						try{
						int idProducto = Integer.parseInt(idText.getText());
						String code = codeText.getText();
						String name = nameText.getText();
						double price = Double.parseDouble(priceText.getText());
						int stock = Integer.parseInt(stockText.getText());
						if(price>=0 && stock >=0){
							TProducto productoModificado = new TProducto(idProducto, code, name, price, stock, true);
							Controlador.getInstance().accion(Evento.MODIFICAR_PRODUCTO, productoModificado);
						}
						}catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(null, "El id y precio deben de ser un número");
						}
					} else
						JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
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
		case Evento.RES_MODIFICAR_PRODUCTO_OK: {
			JOptionPane.showMessageDialog(this, "Producto actualizado con éxito: ", datos.toString(),
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		case Evento.RES_MODIFICAR_PRODUCTO_KO: {
			JOptionPane.showMessageDialog(this, "No se ha podido modificar el producto", "Update Producto",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
		default:
			break;
		}
	}
}