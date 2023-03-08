package presentacion.Turno;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaReadAllTurnos extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;

	public VistaReadAllTurnos() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MOSTRAR TURNOS");
		JPanel panel = new JPanel();
		JLabel idTurnoLabel = new JLabel("¿Mostrar todos los turnos?");
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");

		panel.add(idTurnoLabel);
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
					Controlador.getInstance().accion(Evento.LISTAR_TURNOS, null);
				} catch (Exception exception) {
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
		if (evento == Evento.RES_LISTAR_TURNOS_OK) {
			JTextArea textArea = new JTextArea(datos.toString());
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(500, 500));
			JOptionPane.showMessageDialog(this, scrollPane, "TURNOS", JOptionPane.DEFAULT_OPTION);
		
		} else if (evento == Evento.RES_LISTAR_TURNOS_KO)
			JOptionPane.showMessageDialog(this, "No se ha encontrado ninguna factura para visualizar");
	}
}