package presentacion.EmpleadoJPA;

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
import javax.swing.JTextField;

import negocio.EmpleadoJPA.TEmpleadoJPA;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaReadEmpleadoByTurno extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;
	
	public VistaReadEmpleadoByTurno() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MOSTRAR EMPLEADO POR TURNO");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Turno:");
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
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				
				try {
					if (text.getText().length() != 0)
						Controlador.getInstance().accion(Evento.MOSTRAR_EMPLEADOS_TURNO,
							Integer.parseInt(text.getText()));
					else JOptionPane.showMessageDialog(null, "Debes rellenar el campo");
				}
				catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "El id debe ser un número");
				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	@Override
	public void actualizar(int evento, Object datos) {
		setVisible(false);
			if(evento == Evento.RES_MOSTRAR_EMPLEADOS_TURNO_OK) {
				Collection<TEmpleadoJPA> set = (Collection<TEmpleadoJPA>) datos;
				String s = "";
				for (TEmpleadoJPA p : set) {
					s += p.toString() + "_____________\n";

				}
				JTextArea textArea = new JTextArea(s);
				JScrollPane scrollPane = new JScrollPane(textArea);
				scrollPane.setPreferredSize(new Dimension(500, 500));
				JOptionPane.showMessageDialog(this, scrollPane, "Empleado", JOptionPane.DEFAULT_OPTION);
			} 
			else {
				JOptionPane.showMessageDialog(this, "No se han encontrado empleados asociados al turno introducido");	
			}
			
			dispose();
		}
	}
