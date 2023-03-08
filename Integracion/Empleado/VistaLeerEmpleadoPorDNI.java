package presentacion.Empleado;

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

public class VistaLeerEmpleadoPorDNI extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;
	
	public VistaLeerEmpleadoPorDNI() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MOSTRAR EMPLEADO POR DNI");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("DNI del empleado:");
		final JTextField text = new JTextField(20);

		JButton show = new JButton("BUSCAR");
		JButton cancel = new JButton("CANCELAR");
		
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
					
					if(text.getText().length() != 0) {
						String DNI = text.getText();
						Controlador.getInstance().accion(Evento.MOSTRAR_EMPLEADO_DNI, DNI);
					} else {
						JOptionPane.showMessageDialog(VistaLeerEmpleadoPorDNI.this, "El DNI introducido no es correcto", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(VistaLeerEmpleadoPorDNI.this, "El DNI introducido no es correcto", "ERROR", JOptionPane.ERROR_MESSAGE);

				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO, null);
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO, null);
				
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
			if(evento == Evento.RES_MOSTRAR_EMPLEADO_DNI_OK) {
				JOptionPane.showMessageDialog(this, datos.toString(), "EMPLEADO", JOptionPane.DEFAULT_OPTION);
			} 
			else {
				String str = (String) datos;
				JOptionPane.showMessageDialog(this, str, "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			dispose();
		}
	}
