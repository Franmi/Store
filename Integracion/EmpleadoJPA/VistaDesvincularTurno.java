package presentacion.EmpleadoJPA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.EmpleadoJPA.TTrabaja;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaDesvincularTurno extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;
	
	public VistaDesvincularTurno() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("DESVINCULAR EMPLEADO A TURNO");
		JPanel panel = new JPanel();
		JLabel idLabel = new JLabel("ID:");
		final JTextField id = new JTextField(20);
		JLabel label = new JLabel("Turno:");
		final JTextField text = new JTextField(20);

		JButton show = new JButton("DESVINCULAR");
		JButton cancel = new JButton("CANCELAR");
		
		panel.add(idLabel);
		panel.add(id);
		panel.add(label);
		panel.add(text);
		panel.add(show);
		panel.add(cancel);
		
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					if (id.getText().length() != 0 && text.getText().length() != 0) {
						int idEmpleado = Integer.parseInt(id.getText());
						int idTurno = Integer.parseInt(text.getText());
						TTrabaja tTrabaja = new TTrabaja(idEmpleado,idTurno);
						Controlador.getInstance().accion(Evento.DESVINCULAR_TURNO, tTrabaja);
						
					} else JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
					
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(),
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO_JPA, null);
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO_JPA, null);
				
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(),
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	@Override
	public void actualizar(int evento, Object datos) {
		setVisible(false);
			if(evento == Evento.RES_DESVINCULAR_TURNO_OK) {
				JOptionPane.showMessageDialog(this, "El empleado se ha desvinculado correctamente " );
			} 
			else {
				JOptionPane.showMessageDialog(this, "El Empleado no se ha podido desvincular");
			}
			
			dispose();
		}
	}
