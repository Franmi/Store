package presentacion.Empleado;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Empleado.TEmpleado;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaAltaEmpleado extends JFrame implements IGUI {

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void AltaEmpleado() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	private static final long serialVersionUID = 1L;

	public VistaAltaEmpleado() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("ALTA EMPLEADO");

		JPanel panel = new JPanel();
		JLabel label2 = new JLabel("Nombre del empleado: ");
		final JTextField nombre = new JTextField(15);
		JLabel label3 = new JLabel("Apellidos del empleado: ");
		final JTextField apellidos = new JTextField(15);
		JLabel label4 = new JLabel("DNI del empleado: ");
		final JTextField dni = new JTextField(15);
		JLabel label5 = new JLabel("Telefono del empleado: ");
		final JTextField telefono = new JTextField(15);
		JLabel label6 = new JLabel("Correo del empleado: ");
		final JTextField correo = new JTextField(15);

		JButton update = new JButton("AÑADIR");
		JButton cancel = new JButton("CANCELAR");

		panel.add(label2);
		panel.add(nombre);
		panel.add(label3);
		panel.add(apellidos);
		panel.add(label4);
		panel.add(dni);
		panel.add(label5);
		panel.add(telefono);
		panel.add(label6);
		panel.add(correo);
		panel.add(update);
		panel.add(cancel);

		getContentPane().add(panel, BorderLayout.CENTER);

		setPreferredSize(new Dimension(1500, 100));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		update.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				try {

					if (nombre.getText().length() != 0 && dni.getText().length() != 0
							&& apellidos.getText().length() != 0 && telefono.getText().length() != 0
							&& correo.getText().length() != 0) {
						String nombreEmpleado = nombre.getText();
						String dniEmpleado = dni.getText();
						String apellidosEmpleado = apellidos.getText();
						String telefonoEmpleado = telefono.getText();
						String correoEmpleado = correo.getText();

						TEmpleado empleado = new TEmpleado(nombreEmpleado, apellidosEmpleado, dniEmpleado,
								telefonoEmpleado, correoEmpleado, true);
						if (empleado != null)
							Controlador.getInstance().accion(Evento.ALTA_EMPLEADO, empleado);
					} else
						JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Los datos introducidos no son validos", "ERROR",
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
		if (evento == Evento.RES_ALTA_EMPLEADO_OK) {
			int id = (int) datos;
			JOptionPane.showMessageDialog(this, "Empleado dado de alta correctamente, con id: " + id);
			dispose();
		} else {
			String str = datos.toString();
			JOptionPane.showMessageDialog(this, str, "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		dispose();
	}

}