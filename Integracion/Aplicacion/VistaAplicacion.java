package presentacion.Aplicacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaAplicacion extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;
	
	public VistaAplicacion() {
		setTitle("Aplicacion");
		JPanel panel = new JPanel(new GridLayout(1, 2));
		JButton acuario = new JButton("Acuario");
		JButton tienda = new JButton("Tienda");
		
		panel.add(acuario);
		panel.add(tienda);
		
		acuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.MENU_ACUARIO, null);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		tienda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.MENU_TIENDA, null);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
	
		});
		this.add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actualizar(int evento, Object datos) {}
	
}