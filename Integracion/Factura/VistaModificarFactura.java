package presentacion.Factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Factura.TFactura;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaModificarFactura extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaModificarFactura() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MODIFICAR FACTURA");
		JPanel panel = new JPanel();
		JLabel idLabel = new JLabel("Id de la factura: ");
		final JTextField idText = new JTextField(20);
		JLabel DNILabel = new JLabel("DNI del cliente: ");
		final JTextField DNIText = new JTextField(20);
		final String date = DateTimeFormatter.ofPattern("MM-dd-yyy hh:mm:ss").format(LocalDateTime.now());
		JButton accept = new JButton("Aceptar");
		JButton cancel = new JButton("Cancelar");

		panel.add(idLabel);
		panel.add(idText);
		panel.add(DNILabel);
		panel.add(DNIText);
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
					if (DNIText.getText().length() > 9)
						JOptionPane.showMessageDialog(null, "El campo DNI no puede tener más de 9 caracteres");
					else {
						if (DNIText.getText().length() != 0) {
							Controlador.getInstance().accion(Evento.MODIFICAR_FACTURA,
									new TFactura(Integer.parseInt(idText.getText()), DNIText.getText(), date, 0, 0));
						} else
							JOptionPane.showMessageDialog(null, "Debes rellenar el campo DNI");
					}
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

	@Override
	public void actualizar(int evento, Object datos) {
		setVisible(false);
		if (evento == Evento.RES_MODIFICAR_FACTURA_OK)
			JOptionPane.showMessageDialog(this, "Se ha modificado correctamente la factura con id " + (Integer) datos);
		else if (evento == Evento.RES_MODIFICAR_FACTURA_KO)
			JOptionPane.showMessageDialog(this, "No se ha podido modificar la factura");
	}

}