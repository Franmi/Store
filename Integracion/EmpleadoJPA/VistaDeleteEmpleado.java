package presentacion.EmpleadoJPA;

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

public class VistaDeleteEmpleado extends JFrame implements IGUI {
	
	private static final long serialVersionUID = 1L;

	JTextField idTextField;

	public VistaDeleteEmpleado() {
		
		setTitle("Dar de baja Empleado");
		JPanel panel = new JPanel();

		JPanel informacion = new JPanel();
		JLabel idLabel = new JLabel("ID: ");
		idTextField = new JTextField(8);
		informacion.add(idLabel);
		informacion.add(idTextField);

		JPanel botones = new JPanel();
		JButton aceptarButton = new JButton("Aceptar");
		JButton cancelarButton = new JButton("Cancelar");
		botones.add(aceptarButton);
		botones.add(cancelarButton);

		aceptarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					if (idTextField.getText().length() !=0) {
						try{
						int id = Integer.parseInt(idTextField.getText());
						Controlador.getInstance().accion(Evento.ELIMINAR_EMPLEADO_JPA, id);
						}catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(null, "El id debe ser un número");
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Debes rellenar el campo");
					}

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO_JPA, null);
			}

		});

		cancelarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				try{
					Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO_JPA, null);
				} catch(Exception exception){
					JOptionPane.showMessageDialog(null, exception.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		panel.add(informacion);
		panel.add(botones);

		this.add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		if (evento == Evento.RES_ELIMINAR_EMPLEADO_JPA_OK) {
			int id = (int) datos;
			JOptionPane.showMessageDialog(this, "Empleado con id " + id + " dado de baja correctamente.");
			//Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO_JPA, null);
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "El empleado no se ha podido dar de baja", "BAJA EMPLEADO",JOptionPane.ERROR_MESSAGE);
		}

	}
}