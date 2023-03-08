package presentacion.FacturaJPA;

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

public class VistaMostrarFacturaCompleta extends JFrame implements IGUI {
	
	public VistaMostrarFacturaCompleta() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Mostrar factura completa");
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
					Controlador.getInstance()
					.accion(Evento.MOSTRAR_FACTURA_COMPLETA_JPA, idFactura);

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
		if (evento == Evento.RES_MOSTRAR_FACTURA_COMPLETA_JPA_OK) {
			JOptionPane.showMessageDialog(this, datos.toString());
		} else if (evento == Evento.RES_MOSTRAR_FACTURA_COMPLETA_JPA_KO) {
			JOptionPane.showMessageDialog(this, datos);
		}
		
		dispose();
		
	}
}
