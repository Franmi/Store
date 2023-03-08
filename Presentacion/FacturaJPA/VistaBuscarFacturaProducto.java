package presentacion.FacturaJPA;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.FacturaJPA.TFacturaJPA;
import negocio.Pez.TPez;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaBuscarFacturaProducto extends JFrame implements IGUI{
	
	public VistaBuscarFacturaProducto() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("BUSCAR FACTURAS POR PRODUCTO");
		JPanel panel = new JPanel();
		JLabel showLabel = new JLabel("Id del producto:");
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
					int idProd = Integer.parseInt(showText.getText());
					Controlador.getInstance().accion(Evento.BUSCAR_FACTURA_PRODUCTO_JPA, idProd);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA_JPA, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA_JPA, null);
				dispose();
			}
		});
	}

	@Override
	public void actualizar(int evento, Object datos) {
		
		if (evento == Evento.RES_BUSCAR_FACTURA_PRODUCTO_JPA_OK) {
			Collection<TFacturaJPA> col = (Collection<TFacturaJPA>) datos;
			String s = "";
			for (TFacturaJPA p : col) {
				s += p.toString() + "_____________\n";

			}
			JTextArea textArea = new JTextArea(s);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(this, scrollPane, "Facturas", JOptionPane.DEFAULT_OPTION);
		} else if (evento == Evento.RES_BUSCAR_FACTURA_PRODUCTO_JPA_KO) {
			JOptionPane.showMessageDialog(this, datos);
		}
		
		dispose();
	}

}
