package presentacion.Tienda;

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

public class VistaTienda extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;

	public VistaTienda() {
	
		setTitle("Tienda");
		JPanel panel = new JPanel(new GridLayout(1, 2));
		JButton empleadoButton = new JButton("Empleado");
		JButton facturaButton = new JButton("Factura");
		JButton turnoButton = new JButton("Turno");
		JButton productoButton = new JButton("Producto");
		
		panel.add(empleadoButton);
		panel.add(facturaButton);
		panel.add(turnoButton);
		panel.add(productoButton);
		
		empleadoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO_JPA, null);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		facturaButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA_JPA, null);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
	
		});
		productoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_PRODUCTO, null);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		turnoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_TURNO, null);
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