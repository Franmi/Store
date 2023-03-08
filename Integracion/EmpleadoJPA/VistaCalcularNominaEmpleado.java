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

public class VistaCalcularNominaEmpleado  extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;

	public VistaCalcularNominaEmpleado() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Calcular nómina Empleado");
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
						Controlador.getInstance().accion(Evento.CALCULAR_NOMINA,Integer.parseInt(idEmpleadoText.getText()));
					else JOptionPane.showMessageDialog(null, "Debes rellenar el campo");
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "El id debe ser un número");
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_EMPLEADO_JPA, null);
			}
		});

		cancelar.addActionListener(new ActionListener() {
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
	
	public void actualizar(int evento, Object datos) {
		setVisible(false);
		if (evento == Evento.RES_CALCULAR_NOMINA_OK)
			JOptionPane.showMessageDialog(this, "La nómina total del Empleado es " + (double) datos);
		else if (evento == Evento.RES_CALCULAR_NOMINA_KO)
			JOptionPane.showMessageDialog(this, "No se ha podido calcular la nómina del empleado");
	}
}
