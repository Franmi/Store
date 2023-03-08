package presentacion.Factura;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaMostrarFacturas extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaMostrarFacturas() {
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
					Controlador.getInstance().accion(Evento.LISTAR_FACTURAS, null);
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
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					setVisible(true);
				}
			}
		});
	}

	public void actualizar(int evento, Object datos) {
		setVisible(false);
		if (evento == Evento.RES_LISTAR_FACTURAS_OK) {
			JTextArea textArea = new JTextArea(datos.toString());
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(this, scrollPane, "FACTURAS", JOptionPane.DEFAULT_OPTION);
		} else if (evento == Evento.RES_LISTAR_FACTURAS_KO)
			JOptionPane.showMessageDialog(this, "No se ha podido encontrar ninguna factura");
	}

}