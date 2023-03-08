package presentacion.FacturaJPA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.FacturaJPA.TFacturaJPA;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaModificarFacturaJPA extends JFrame implements IGUI {
	
	public VistaModificarFacturaJPA() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MODIFICAR FACTURA");
		JPanel panel = new JPanel();
		JLabel showLabel = new JLabel("Id factura:");
		final JTextField showText = new JTextField(20);
		JLabel showLabel2 = new JLabel("Id empleado:");
		final JTextField showText2 = new JTextField(20);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancel = new JButton("Cancelar");

		panel.add(showLabel);
		panel.add(showText);
		panel.add(showLabel2);
		panel.add(showText2);
		panel.add(aceptar);
		panel.add(cancel);

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
				
				try {
					int idFac = Integer.parseInt(showText.getText());
					int idEmp = Integer.parseInt(showText2.getText());
					final String date = DateTimeFormatter.ofPattern("MM-dd-yyy hh:mm:ss").format(LocalDateTime.now());
					
					TFacturaJPA tFac = new TFacturaJPA(idEmp, date);
					tFac.setIdFactura(idFac);
					Controlador.getInstance().accion(Evento.MODIFICAR_FACTURA_JPA, tFac);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA_JPA, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Controlador.getInstance().accion(Evento.VISTA_MENU_FACTURA_JPA, null);
				dispose();
			}
		});
	}

	@Override
	public void actualizar(int evento, Object datos) {
		if (evento == Evento.RES_MODIFICAR_FACTURA_JPA_OK) {
			JOptionPane.showMessageDialog(this, datos.toString());
		} else if (evento == Evento.RES_MODIFICAR_FACTURA_JPA_KO) {
			JOptionPane.showMessageDialog(this, datos);
		}
		
		dispose();
	}
	
}
