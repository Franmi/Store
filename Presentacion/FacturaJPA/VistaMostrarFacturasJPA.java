package presentacion.FacturaJPA;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import negocio.FacturaJPA.TFacturaJPA;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaMostrarFacturasJPA extends JFrame implements IGUI{
	
	public VistaMostrarFacturasJPA() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MOSTRAR FACTURAS");
		JPanel panel = new JPanel();
		JLabel read = new JLabel("¿Mostrar todas las facturas?");
		JButton accept = new JButton("Aceptar");
		JButton cancel = new JButton("Cancelar");

		panel.add(read);
		panel.add(accept);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.LISTAR_FACTURA_JPA, null);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA_JPA, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA_JPA, null);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					setVisible(true);
				}
			}
		});
	}

	@Override
	public void actualizar(int evento, Object datos) {
		
		if (evento == Evento.RES_LISTAR_FACTURAS_JPA_OK) {
			Collection<TFacturaJPA> col = (Collection<TFacturaJPA>) datos;
			String s = "";
			for (TFacturaJPA p : col) {
				s += p.toString() + "_____________\n";

			}
			JTextArea textArea = new JTextArea(s);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(this, scrollPane, "Facturas", JOptionPane.DEFAULT_OPTION);
		} else if (evento == Evento.RES_LISTAR_FACTURAS_JPA_KO) {
			JOptionPane.showMessageDialog(this, datos);
		}
		
		dispose();
	}

}
