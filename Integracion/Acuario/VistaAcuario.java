package presentacion.Acuario;

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

public class VistaAcuario extends JFrame implements IGUI {

	private static final long serialVersionUID = 1L;

	public VistaAcuario() {
		setTitle("Acuario");
		JPanel panel = new JPanel(new GridLayout(1, 2));
		JButton empleadoButton = new JButton("Empleado");
		JButton facturaButton = new JButton("Factura");
		JButton espectaculoButton = new JButton("Espectáculo");
		JButton pezButton = new JButton("Pez");

		panel.add(empleadoButton);
		panel.add(facturaButton);
		panel.add(espectaculoButton);
		panel.add(pezButton);

		empleadoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO, null);
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
					Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA, null);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		pezButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_PEZ, null);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		espectaculoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_ESPECTACULO, null);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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