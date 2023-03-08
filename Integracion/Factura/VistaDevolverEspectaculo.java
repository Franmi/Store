package presentacion.Factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Factura.TLineaFactura;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaDevolverEspectaculo extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaDevolverEspectaculo() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Devolver espectáculo");
		JPanel panel = new JPanel();
		JLabel idFacturaLabel = new JLabel("Id de la factura:");
		final JTextField idFacturaText = new JTextField(20);
		JLabel idEspectaculoLabel = new JLabel("Id del espectáculo:");
		final JTextField idEspectaculoText = new JTextField(20);
		JLabel amountLabel = new JLabel("Número de entradas:");
		final JTextField amountText = new JTextField(20);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");

		panel.add(idFacturaLabel);
		panel.add(idFacturaText);
		panel.add(idEspectaculoLabel);
		panel.add(idEspectaculoText);
		panel.add(amountLabel);
		panel.add(amountText);
		panel.add(aceptar);
		panel.add(cancelar);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.DEVOLVER_ESPECTACULO_FACTURA,
							new TLineaFactura(Integer.parseInt(idFacturaText.getText()),
									Integer.parseInt(idEspectaculoText.getText()),
									Integer.parseInt(amountText.getText()), 0));
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA, null);

			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA, null);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	@Override
	public void actualizar(int evento, Object datos) {
		setVisible(false);
		if (evento == Evento.RES_DEVOLVER_ESPECTACULO_FACTURA_OK)
			JOptionPane.showMessageDialog(this, "Se ha devuelto correctamente el espectáculo");
		else if (evento == Evento.RES_DEVOLVER_ESPECTACULO_FACTURA_KO)
			JOptionPane.showMessageDialog(this, "No se ha podido devolver el espectáculo");
	}

}
