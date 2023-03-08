package presentacion.FacturaJPA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.FacturaJPA.TLineaFacturaJPA;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;


public class VistaDevolverProducto extends JFrame implements IGUI  {
	
	public VistaDevolverProducto() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("DEVOLVER PRODUCTO");
		JPanel panel = new JPanel();
		JLabel showLabel3 = new JLabel("Id de la factura:");
		final JTextField showText3 = new JTextField(20);
		JLabel showLabel = new JLabel("Id del producto:");
		final JTextField showText = new JTextField(20);
		JLabel showLabel2 = new JLabel("Cantidad a devolver:");
		final JTextField showText2 = new JTextField(20);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancel = new JButton("Cancelar");
		
		panel.add(showLabel3);
		panel.add(showText3);
		panel.add(showLabel);
		panel.add(showText);
		panel.add(showLabel2);
		panel.add(showText2);
		panel.add(aceptar);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);

				try {
					int idFac = Integer.parseInt(showText3.getText());
					int idProd = Integer.parseInt(showText.getText());
					int cant = Integer.parseInt(showText2.getText());
					Controlador.getInstance().accion(Evento.DEVOLVER_PRODUCTO, new TLineaFacturaJPA(idFac, idProd, cant, -1, true));

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

	public void actualizar(int evento, Object datos) {
		if (evento == Evento.RES_DEVOLVER_PRODUCTO_OK) {
			JOptionPane.showMessageDialog(this, datos.toString());
		} else if (evento == Evento.RES_DEVOLVER_PRODUCTO_KO) {
			JOptionPane.showMessageDialog(this, datos);
		}
		
		dispose();
	}
}