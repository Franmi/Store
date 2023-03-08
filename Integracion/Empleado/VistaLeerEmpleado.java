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

public class VistaLeerEmpleado extends JFrame implements IGUI {

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void readCliente() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	private static final long serialVersionUID = 1L;

	public VistaLeerEmpleado() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("BUSCAR EMPLEADO");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Id del empleado:");
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
					int id = Integer.parseInt(text.getText());

					Controlador.getInstance().accion(Evento.MOSTRAR_EMPLEADO, id);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(VistaLeerEmpleado.this, "El ID introducido no es correcto", "ERROR",
							JOptionPane.ERROR_MESSAGE);

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
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	@Override
	public void actualizar(int evento, Object datos) {
		setVisible(false);
		if (evento == Evento.RES_MOSTRAR_EMPLEADO_OK) {
			JOptionPane.showMessageDialog(this, datos.toString(), "EMPLEADO", JOptionPane.DEFAULT_OPTION);
		} else {
			String str = (String) datos;
			JOptionPane.showMessageDialog(this, str, "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		dispose();
	}
}