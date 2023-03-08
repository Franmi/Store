package presentacion.Espectaculo;

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

public class VistaQueryEspectaculo extends JFrame implements IGUI {

	JTextField idEspField;

	public VistaQueryEspectaculo() {
		setTitle("Mostrar el mayor número de entradas en una sola factura para un espectáculo dado");
		JPanel panel = new JPanel();

		JPanel informacion = new JPanel();
		JLabel precioLabel = new JLabel("ID espectáculo: ");
		idEspField = new JTextField(8);
		informacion.add(precioLabel);
		informacion.add(idEspField);

		JPanel botones = new JPanel();
		JButton aceptarButton = new JButton("Aceptar");
		JButton cancelarButton = new JButton("Cancelar");
		botones.add(aceptarButton);
		botones.add(cancelarButton);

		aceptarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (idEspField.getText().length() != 0) {
						int id = Integer.parseInt(idEspField.getText());
						Controlador.getInstance().accion(Evento.QUERY_ESPECTACULO, id);
					} else
						JOptionPane.showMessageDialog(null, "Debes rellenar el campo id");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(VistaQueryEspectaculo.this, "El id debe ser un numero", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		cancelarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(Evento.VISTA_MENU_ESPECTACULO, null);
				dispose();
			}
		});

		panel.add(informacion);
		panel.add(botones);

		this.add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actualizar(int evento, Object datos) {

		if (evento == Evento.RES_QUERY_ESPECTACULO_OK) {
			JOptionPane.showMessageDialog(this,
					"La factura (o facturas) con mayor número de entradas para ese espectáculo tiene:  " + (int) datos
							+ " entradas",
					"Espectaculo", JOptionPane.DEFAULT_OPTION);
		} else if (evento == Evento.RES_QUERY_ESPECTACULO_KO) {
			JOptionPane.showMessageDialog(this, (String) datos, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}
