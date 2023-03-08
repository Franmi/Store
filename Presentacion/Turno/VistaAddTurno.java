package presentacion.Turno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Turno.TTurno;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaAddTurno extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaAddTurno() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Alta turno");
		JPanel panel = new JPanel();
		JLabel nameLabel = new JLabel("Nombre: ");
		final JTextField nameText = new JTextField(25);
		JLabel startLabel = new JLabel("Comienzo del turno: ");
		final JTextField startText = new JTextField(25);
		JLabel endLabel = new JLabel("Fin del turno: ");
		final JTextField endText = new JTextField(25);
		
		JButton add = new JButton("Añadir");
		JButton cancel = new JButton("Cancelar");
		
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(startLabel);
		panel.add(startText);
		panel.add(endLabel);
		panel.add(endText);
		panel.add(add);
		panel.add(cancel);
		
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					if (startText.getText().length() != 0 && endText.getText().length() != 0
							&& nameText.getText().length() != 0) {
						String nombre = nameText.getText();
						String inicio = startText.getText();
						String fin = endText.getText();
						TTurno turno = new TTurno(nombre, inicio, fin);
						Controlador.getInstance().accion(Evento.ALTA_TURNO, turno);
					} else
						JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(),
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_TURNO, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_TURNO, null);
				
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
					
					setVisible(true);
				}
			}
		});
	}
	
	public void actualizar(int evento, Object datos) {
		setVisible(false);
		if (evento == Evento.RES_ALTA_TURNO_OK)
			JOptionPane.showMessageDialog(this, "Se ha creado correctamente el turno con id " + (Integer) datos);
		else if (evento == Evento.RES_ALTA_TURNO_KO) {
			JOptionPane.showMessageDialog(this, "El turno no se ha podido crear");
		}
	}
}