package presentacion.Espectaculo;

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

import negocio.Espectaculo.TEspectaculo;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaModificarEspectaculo extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaModificarEspectaculo() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MODIFICAR ESPECTÁCULO");
		JPanel panel = new JPanel();

		JLabel idLabel = new JLabel("Id del espectáculo:");
		final JTextField idText = new JTextField(20);
		JLabel showLabel = new JLabel("Nombre del espectáculo:");
		final JTextField showText = new JTextField(20);
		JLabel priceLabel = new JLabel("Precio del espectáculo:");
		final JTextField priceText = new JTextField(20);
		JLabel amountLabel = new JLabel("Entradas disponibles para el espectáculo:");
		final JTextField amountText = new JTextField(20);
		JLabel employeeLabel = new JLabel("ID del empleado asociado:");
		final JTextField employeeText = new JTextField(20);

		JPanel panelBoton = new JPanel();

		JButton change = new JButton("MODIFICAR");
		JButton cancel = new JButton("CANCELAR");
		JPanel jid = new JPanel();
		jid.setLayout(new BoxLayout(jid, BoxLayout.X_AXIS));
		jid.add(idLabel);
		jid.add(idText);
		JPanel jshow = new JPanel();
		jshow.setLayout(new BoxLayout(jshow, BoxLayout.X_AXIS));
		jshow.add(showLabel);
		jshow.add(showText);
		JPanel jprice = new JPanel();
		jprice.setLayout(new BoxLayout(jprice, BoxLayout.X_AXIS));
		jprice.add(priceLabel);
		jprice.add(priceText);
		JPanel jamount = new JPanel();
		jamount.setLayout(new BoxLayout(jamount, BoxLayout.X_AXIS));
		jamount.add(amountLabel);
		jamount.add(amountText);
		JPanel jemployee = new JPanel();
		jemployee.setLayout(new BoxLayout(jemployee, BoxLayout.X_AXIS));
		jemployee.add(employeeLabel);
		jemployee.add(employeeText);

		panel.add(jid);
		panel.add(jshow);
		panel.add(jprice);
		panel.add(jamount);
		panel.add(jemployee);
		panelBoton.add(change);
		panelBoton.add(cancel);
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(panelBoton, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); // Por que??

				try {
					int idEspectaculo = Integer.parseInt(idText.getText());
					String nombreEspectaculo = showText.getText();
					double precioEspectaculo = Double.parseDouble(priceText.getText());
					int numeroEntradas = Integer.parseInt(amountText.getText());
					int idEmpleado = Integer.parseInt(employeeText.getText());
					TEspectaculo modificadoEspectaculo = new TEspectaculo(idEspectaculo, nombreEspectaculo,
							precioEspectaculo, numeroEntradas, idEmpleado, true);

					Controlador.getInstance().accion(Evento.MODIFICAR_ESPECTACULO, modificadoEspectaculo);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				Controlador.getInstance().accion(Evento.VISTA_MENU_ESPECTACULO, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);

				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_ESPECTACULO, null);

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
		case Evento.RES_MODIFICAR_ESPECTACULO_OK: {
			//TEspectaculo esp=(TEspectaculo) datos;
			JOptionPane.showMessageDialog(this, "UPDATE ESPECTACULO ACTUALIZADO: ", datos.toString(),
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		case Evento.RES_MODIFICAR_ESPECTACULO_KO: {
			JOptionPane.showMessageDialog(this, "No se ha podido modificar el Espectaculo", "Update Espectaculo",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
		default:
			break;
		}
	}
}