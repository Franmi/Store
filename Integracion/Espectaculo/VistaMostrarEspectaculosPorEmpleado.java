package presentacion.Espectaculo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.Espectaculo.TEspectaculo;
import presentacion.IGUI;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Evento;

public class VistaMostrarEspectaculosPorEmpleado extends JFrame implements IGUI {

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void vistaMostrarEspectaculosPorEmpleado() {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	private static final long serialVersionUID = 1L;

	public VistaMostrarEspectaculosPorEmpleado() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("MOSTRAR ESPECTÁCULO POR EMPLEADO");
		JPanel panel = new JPanel();
		JLabel showLabel = new JLabel("Id del empleado:");
		final JTextField showText = new JTextField(20);

		JButton read = new JButton("MOSTRAR");
		JButton cancel = new JButton("CANCELAR");

		panel.add(showLabel);
		panel.add(showText);
		panel.add(read);
		panel.add(cancel);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); // Por que??

				try {
					int idEmpleado = Integer.parseInt(showText.getText());

					Controlador.getInstance().accion(Evento.MOSTRAR_ESPECTACULO_POR_EMPLEADO, idEmpleado);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getLocalizedMessage(), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				Controlador.getInstance().accion(Evento.VISTA_MENU_ESPECTACULO, null);
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);

				try {
					Controlador.getInstance().accion(Evento.VISTA_MENU_ESPECTACULO, null);

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
		Set<TEspectaculo> set = (Set<TEspectaculo>) datos;
		if (evento == Evento.RES_MOSTRAR_ESPECTACULO_POR_EMPLEADO_OK) {
			JTextArea textArea = new JTextArea(set.toString());
			JScrollPane scrollPane = new JScrollPane(textArea);

			scrollPane.setPreferredSize(new Dimension(500, 500));

			JOptionPane.showMessageDialog(this, scrollPane, "ESPECTÁCULOS", JOptionPane.DEFAULT_OPTION);
		}

		else if (evento == Evento.RES_MOSTRAR_ESPECTACULO_POR_EMPLEADO_KO)
			JOptionPane.showMessageDialog(this, "No hay espectáculos registrados para el empleado introducido");
	}
}
