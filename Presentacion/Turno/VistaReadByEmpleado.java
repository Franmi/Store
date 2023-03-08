package presentacion.Turno;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.swing.*;

import negocio.Turno.TTurno;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaReadByEmpleado extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;

	public VistaReadByEmpleado() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MOSTRAR TURNOS POR EMPLEADO");
		JPanel panel = new JPanel();
		JLabel idEmpleadoLabel = new JLabel("Id del empleado:");
		final JTextField idEmpleadoText = new JTextField(20);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");

		panel.add(idEmpleadoLabel);
		panel.add(idEmpleadoText);
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
					if (idEmpleadoText.getText().length() != 0)
						Controlador.getInstance().accion(Evento.MOSTRAR_TURNOS_EMPLEADO,
							Integer.parseInt(idEmpleadoText.getText()));
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
		Collection<TTurno> setTurnos = (Collection<TTurno>) datos;
		if (evento == Evento.RES_MOSTRAR_TURNOS_EMPLEADO_OK) {
			JTextArea textArea = new JTextArea(setTurnos.toString());
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(this, scrollPane, "TURNOS", JOptionPane.DEFAULT_OPTION);
		
		} else if (evento == Evento.RES_MOSTRAR_TURNOS_EMPLEADO_KO)
			JOptionPane.showMessageDialog(this, "No se han encontrado turnos asociados al empleado introducido");
	}
}