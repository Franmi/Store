package presentacion.Turno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaReadTurno extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;

	public VistaReadTurno() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("BUSCAR TURNO");
		JPanel panel = new JPanel();
		JLabel idTurnoLabel = new JLabel("Id del turno:");
		final JTextField idTurnoText = new JTextField(20);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");

		panel.add(idTurnoLabel);
		panel.add(idTurnoText);
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
					if (idTurnoText.getText().length() != 0)
						Controlador.getInstance().accion(Evento.BUSCAR_TURNO,
							Integer.parseInt(idTurnoText.getText()));
					else JOptionPane.showMessageDialog(null, "Debes rellenar el campo");
				}
				catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "El id debe ser un número");
				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				
				Controlador.getInstance().accion(Evento.VISTA_MENU_TURNO, null);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_TURNO, null);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	public void actualizar(int evento, Object datos) {
		setVisible(false);
		if (evento == Evento.RES_BUSCAR_TURNO_OK)
			JOptionPane.showMessageDialog(this, datos.toString());
		else if (evento == Evento.RES_BUSCAR_TURNO_KO)
			JOptionPane.showMessageDialog(this, "No se ha podido encontrado el turno introducido");
	}
}